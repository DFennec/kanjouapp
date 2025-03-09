package com.kanjou.kanjouapp.Kanji;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    
    @GetMapping("/JLPT/{JLPT}")
    public List<Kanji> getKanjiByJLPT(@PathVariable Integer JLPT){
		return kanjiService.getKanjiByJLPT(JLPT);
	}

    @PostMapping("/")
    public Kanji saveKanji(@RequestBody Kanji kanji){
		return kanjiService.saveKanji(kanji);
	}
}
