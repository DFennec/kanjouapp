package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/sentences")
public class ExampleSentencesController {
    
    private final ExampleSentencesService exampleSentencesService;

    public ExampleSentencesController(ExampleSentencesService exampleSentencesService){
        this.exampleSentencesService = exampleSentencesService;
    }

    @GetMapping("/{id}")
	public List<ExampleSentences> getExampleSentences(@PathVariable Long id){
		return exampleSentencesService.getSentencesById(id);
	}

}
