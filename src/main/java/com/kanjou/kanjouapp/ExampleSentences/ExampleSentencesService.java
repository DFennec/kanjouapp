package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Vocabulary.Vocabulary;
import com.kanjou.kanjouapp.Vocabulary.VocabularyRepository;

@Service
public class ExampleSentencesService {
	private final ExampleSentencesRepository exampleSentencesRepository;

	private final VocabularyRepository vocabularyRepository;

	public ExampleSentencesService(ExampleSentencesRepository exampleSentencesRepository, VocabularyRepository vocabularyRepository){
		this.exampleSentencesRepository = exampleSentencesRepository;
		this.vocabularyRepository = vocabularyRepository;
	}

	public List<ExampleSentences> findSentencesByVocabulary(Long vocabularyId) {
		Optional<Vocabulary> vocabulary = vocabularyRepository.findById(vocabularyId);
		if (!vocabulary.isPresent()) {
			throw new IllegalArgumentException("No vocabulary found with that id.");
		}
		return exampleSentencesRepository.findSentencesByVocabulary(vocabulary);
	}

	public ExampleSentences saveExample(ExampleSentences example) {
		return exampleSentencesRepository.save(example);
	}
}
