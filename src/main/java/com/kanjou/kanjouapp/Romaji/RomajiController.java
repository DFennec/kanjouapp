package com.kanjou.kanjouapp.Romaji;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Kanji.Kanji;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/romaji")
public class RomajiController {
    
    private final RomajiService romajiService;

    public RomajiController(RomajiService romajiService){
        this.romajiService = romajiService;
    }

    @GetMapping("/kan/{kanji}")
	public List<Romaji> getRomajiByKanji(@PathVariable Kanji kanji){
		return romajiService.getRomajiByKanji(kanji);
	}

    @GetMapping("/rom/{Romaji}")
	public List<Kanji> getKanjiByRomaji(@PathVariable Romaji romaji){
        return romajiService.getKanjiByRomaji(romaji);
	}

    @PostMapping("/")
	public Romaji saveRomaji(@RequestBody Romaji romaji){
		return romajiService.saveRomaji(romaji);
	}

}
