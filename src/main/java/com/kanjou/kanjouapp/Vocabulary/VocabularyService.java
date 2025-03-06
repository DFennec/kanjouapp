package com.kanjou.kanjouapp.Vocabulary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;

@Service
public class VocabularyService {
	private final VocabularyRepository vocabularyRepository;

	private final KanjiRepository kanjiRepository;

	public VocabularyService(VocabularyRepository vocabularyRepository, KanjiRepository kanjiRepository){
		this.vocabularyRepository = vocabularyRepository;
		this.kanjiRepository = kanjiRepository;
	}

	public List<Vocabulary> getVocabularyByKanji(String kanji) {
		Kanji kanjiEntity = kanjiRepository.findKanjiByKanji(kanji)
			.orElseThrow(() -> new IllegalStateException("Kanji not found."));
		List<Vocabulary> vocabByKanji = vocabularyRepository.findVocabularyByKanji(kanjiEntity);
		if (vocabByKanji.isEmpty()) {
			throw new IllegalStateException("There's no such kanji.");
		}
		return vocabByKanji;
	}

	public Vocabulary saveVocabulary(Vocabulary vocabulary) {
		return vocabularyRepository.save(vocabulary);
	}
}
