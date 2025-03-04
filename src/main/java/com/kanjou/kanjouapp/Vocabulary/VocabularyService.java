package com.kanjou.kanjouapp.Vocabulary;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VocabularyService {
	private final VocabularyRepository vocabularyRepository;

	public VocabularyService(VocabularyRepository vocabularyRepository){
		this.vocabularyRepository = vocabularyRepository;
	}

	public List<Vocabulary> getVocabularyByKanji(String kanji) {
		List<Vocabulary> vocabByKanji=vocabularyRepository.findVocabularyByKanji(kanji);
		if(vocabByKanji.size()>0){
			return vocabByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
}
