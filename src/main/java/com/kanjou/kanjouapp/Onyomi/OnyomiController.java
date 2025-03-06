package com.kanjou.kanjouapp.Onyomi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Kanji.Kanji;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/onyomi")
public class OnyomiController {
    
    private final OnyomiService onyomiService;

    public OnyomiController(OnyomiService onyomiService){
        this.onyomiService = onyomiService;
    }

    @GetMapping("/kan/{kanji}")
	public List<Onyomi> getOnyomiByKanji(@PathVariable String kanji){
		return onyomiService.getOnyomiByKanji(kanji);
	}

    @GetMapping("/on/{onyomi}")
	public List<Kanji> getKanjiByOnyomi(@PathVariable String onyomi){
        return onyomiService.getKanjiByOnyomi(onyomi);
	}

    @PostMapping("/")
	public Onyomi saveOnyomi(@RequestBody Onyomi onyomi){
		return onyomiService.saveOnyomi(onyomi);
	}

}
