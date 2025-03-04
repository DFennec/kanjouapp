package com.kanjou.kanjouapp.Vocabulary;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Kanji.Kanji;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/vocab")
public class VocabularyController {
    
    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService){
        this.vocabularyService = vocabularyService;
    }

    @GetMapping("/{kanji}")
	public List<Vocabulary> getVocabByKanji(@PathVariable Kanji kanji){
		return vocabularyService.getVocabularyByKanji(kanji);
	}

    @PostMapping("/")
	public Vocabulary saveVocabulary(@RequestBody Vocabulary vocabulary){
		return vocabularyService.saveVocabulary(vocabulary);
	}

}
