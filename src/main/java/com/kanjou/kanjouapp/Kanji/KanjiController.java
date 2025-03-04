package com.kanjou.kanjouapp.Kanji;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/kanji")
public class KanjiController {
    
    private final KanjiService kanjiService;

    public KanjiController(KanjiService kanjiService){
        this.kanjiService = kanjiService;
    }

    @GetMapping("/{kanji}")
	public Kanji getKanji(@PathVariable String kanji){
		return kanjiService.getKanjiByKanji(kanji);
	}
    
    @GetMapping("/JLPT/{level}")
    public List<Kanji> getKanji(@PathVariable Integer level){
		return kanjiService.getKanjiByJLPT(level);
	}
}
