package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Vocabulary.Vocabulary;

@Service
public class ExampleSentencesService {
	private final ExampleSentencesRepository exampleSentences;

	public ExampleSentencesService(ExampleSentencesRepository exampleSentences){
		this.exampleSentences = exampleSentences;
	}

	public List<ExampleSentences> findSentencesByVocabulary(Vocabulary vocabulary) {
		List<ExampleSentences> sentencesById=exampleSentences.findSentencesByVocabulary(vocabulary);
		if(sentencesById.size()>0){
			return sentencesById;
		}
		throw new IllegalStateException("No sentences found.");
	}

	public ExampleSentences saveExample(ExampleSentences example) {
		return exampleSentences.save(example);
	}
}
