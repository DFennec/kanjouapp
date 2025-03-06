package com.kanjou.kanjouapp.Meaning;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Kanji.Kanji;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/meaning")
public class MeaningController {
    
    private final MeaningService meaningService;

    public MeaningController(MeaningService meaningService){
        this.meaningService = meaningService;
    }

    @GetMapping("/kan/{kanji}")
	public List<Meaning> getMeaningByKanji(@PathVariable Kanji kanji){
		return meaningService.getMeaningByKanji(kanji);
	}

    @GetMapping("/men/{meaning}")
	public List<Kanji> getKanjiByMeaning(@PathVariable Meaning meaning){
        return meaningService.getKanjiByMeaning(meaning);
	}

    @PostMapping("/")
	public Meaning saveMeaning(@RequestBody Meaning meaning){
		return meaningService.saveMeaning(meaning);
	}

}
