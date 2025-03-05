package com.kanjou.kanjouapp.Kunyomi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Kanji.Kanji;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/kunyomi")
public class KunyomiController {
    
    private final KunyomiService kunyomiService;

    public KunyomiController(KunyomiService kunyomiService){
        this.kunyomiService = kunyomiService;
    }

    @GetMapping("/kan/{kanji}")
	public List<Kunyomi> getKunyomiByKanji(@PathVariable Kanji kanji){
		return kunyomiService.getKunyomiByKanji(kanji);
	}

    @GetMapping("/kun/{kunyomi}")
	public List<Kanji> getKanjiByKunyomi(@PathVariable Kunyomi kunyomi){
        return kunyomiService.getKanjiByKunyomi(kunyomi);
	}

    @PostMapping("/")
	public Kunyomi saveKunyomi(@RequestBody Kunyomi kunyomi){
		return kunyomiService.saveKunyomi(kunyomi);
	}

}
