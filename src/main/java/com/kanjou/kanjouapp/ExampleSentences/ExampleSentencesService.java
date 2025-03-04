package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExampleSentencesService {
	private final ExampleSentencesRepository exampleSentences;

	public ExampleSentencesService(ExampleSentencesRepository exampleSentences){
		this.exampleSentences = exampleSentences;
	}

	public List<ExampleSentences> getSentencesById(Long id) {
		List<ExampleSentences> sentencesById=exampleSentences.findSentencesById(id);
		if(sentencesById.size()>0){
			return sentencesById;
		}
		throw new IllegalStateException("No sentences found.");
	}
}
