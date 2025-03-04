package com.kanjou.kanjouapp.Vocabulary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;

@Service
public class VocabularyService {
	private final VocabularyRepository vocabularyRepository;

	public VocabularyService(VocabularyRepository vocabularyRepository){
		this.vocabularyRepository = vocabularyRepository;
	}

	public List<Vocabulary> getVocabularyByKanji(Kanji kanji) {
		List<Vocabulary> vocabByKanji=vocabularyRepository.findVocabularyByKanji(kanji);
		if(vocabByKanji.size()>0){
			return vocabByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
	public Vocabulary saveVocabulary(Vocabulary vocabulary) {
		return vocabularyRepository.save(vocabulary);
	}
}
