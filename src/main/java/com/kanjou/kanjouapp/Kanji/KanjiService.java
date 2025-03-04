package com.kanjou.kanjouapp.Kanji;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class KanjiService {
    	public List<Kanji> getKanji(){
		return List.of(
			new Kanji(
			));
	}
}
