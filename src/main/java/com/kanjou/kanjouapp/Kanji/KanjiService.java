package com.kanjou.kanjouapp.Kanji;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class KanjiService {
	private final KanjiRepository kanjiRepository;

	public KanjiService(KanjiRepository kanjiRepository){
		this.kanjiRepository = kanjiRepository;
	}

	public Kanji getKanjiByKanji(String kanji) {
		Optional<Kanji> kanjiByKanji=kanjiRepository.findKanjiByKanji(kanji);
		if(kanjiByKanji.isPresent()){
			return kanjiByKanji.get();
		}
		throw new IllegalStateException("There's no such kanji.");
	}

	public List<Kanji> getKanjiByjlptLevel(Integer jlptLevel) {
		if(jlptLevel>6 && jlptLevel<0 ){
			List<Kanji> kanjiByJLPT=kanjiRepository.findKanjiByjlptLevel(jlptLevel);
			return kanjiByJLPT;
		}
		throw new IllegalStateException("JLPT levels go from 5 to 1.");
	}
}
