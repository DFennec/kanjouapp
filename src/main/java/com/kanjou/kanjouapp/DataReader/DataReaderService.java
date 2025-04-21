package com.kanjou.kanjouapp.DataReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;
import com.kanjou.kanjouapp.Kunyomi.Kunyomi;
import com.kanjou.kanjouapp.Meaning.Meaning;
import com.kanjou.kanjouapp.Onyomi.Onyomi;
import com.kanjou.kanjouapp.Vocabulary.Vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class DataReaderService {

    @Autowired
    private KanjiRepository kanjiRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void bulkSaveKanji() {
        String jsonGlobal = restTemplate.getForObject("https://kanjiapi.dev/v1/kanji/all", String.class);
        try {
            List<String> kanjiList = objectMapper.readValue(jsonGlobal, new TypeReference<List<String>>() {});

            for (String kanjiChar : kanjiList) {            
                    try {
                        fetchAndSaveKanji(kanjiChar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchAndSaveKanji(String kanjiChar) {
        String json = restTemplate.getForObject("https://kanjiapi.dev/v1/kanji/" + kanjiChar, String.class);

        try {
            JsonNode root = objectMapper.readTree(json);

            Kanji kanji = new Kanji();
            kanji.setKanji(root.path("kanji").asText());

            if (root.has("jlpt")) {
                kanji.setJLPT(root.path("jlpt").asInt());
                System.out.println(kanji.getKanji() + " JLPT " + kanji);
            }

            List<Meaning> meanings = new ArrayList<>();
            for (JsonNode meaningNode : root.path("meanings")) {
                Meaning meaning = new Meaning();
                meaning.setMeaning(meaningNode.asText());
                meaning.setKanji(kanji);
                meanings.add(meaning);
            }
            kanji.setMeaning(meanings);

            List<Onyomi> onyomiList = new ArrayList<>();
            for (JsonNode onyomiNode : root.path("on_readings")) {
                Onyomi onyomi = new Onyomi();
                onyomi.setOnyomi(onyomiNode.asText());
                onyomi.setKanji(kanji);
                onyomiList.add(onyomi);
            }
            kanji.setOnyomi(onyomiList);

            List<Kunyomi> kunyomiList = new ArrayList<>();
            for (JsonNode kunyomiNode : root.path("kun_readings")) {
                Kunyomi kunyomi = new Kunyomi();
                kunyomi.setKunyomi(kunyomiNode.asText());
                kunyomi.setKanji(kanji);
                kunyomiList.add(kunyomi);
            }
            kanji.setKunyomi(kunyomiList);

            String jsonVocab = restTemplate.getForObject("https://kanjiapi.dev/v1/words/" + kanjiChar, String.class);
            JsonNode rootVocab = objectMapper.readTree(jsonVocab);
            List<Vocabulary> vocabList = new ArrayList<>();

            for (JsonNode wordNode : rootVocab) {
                for (JsonNode variantNode : wordNode.path("variants")) {
                    String written = variantNode.path("written").asText();

                    for (JsonNode meaningNode : wordNode.path("meanings")) {
                        for (JsonNode glossNode : meaningNode.path("glosses")) {
                            Vocabulary vocabulary = new Vocabulary();
                            vocabulary.setTranslation(glossNode.asText());
                            vocabulary.setWord(written);
                            vocabulary.setKanji(kanji);
                            //vocabulary.setHiragana##TODO
                            vocabList.add(vocabulary);
                        }
                    }
                }
            }
            kanji.setVocabulary(vocabList);

            kanjiRepository.save(kanji);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}