package com.kanjou.kanjouapp.Kanji;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/kanji")
public class KanjiController {
    
    private final KanjiService kanjiService;

    public KanjiController(KanjiService kanjiService){
        this.kanjiService = kanjiService;
    }

    @GetMapping("/get")
	public List<Kanji> getKanji(){
		return kanjiService.getKanji();
	}
}
