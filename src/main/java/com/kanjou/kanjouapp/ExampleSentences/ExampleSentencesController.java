package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/sentences")
public class ExampleSentencesController {
    
    private final ExampleSentencesService exampleSentencesService;

    public ExampleSentencesController(ExampleSentencesService exampleSentencesService){
        this.exampleSentencesService = exampleSentencesService;
    }

    @GetMapping("/")
    public List<ExampleSentences> getExampleSentencesByVocabulary(@RequestParam Long vocabularyId) {
        return exampleSentencesService.findSentencesByVocabulary(vocabularyId);
    }
    @PostMapping("/")
	public ExampleSentences saveExampleSentences(@RequestBody ExampleSentences example){
		return exampleSentencesService.saveExample(example);
	}

}
