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

	public List<Kanji> getKanjiByJLPT(Integer level) {
		if(level>6 && level<0 ){
			List<Kanji> kanjiByJLPT=kanjiRepository.findKanjiByJLPT(level);
			return kanjiByJLPT;
		}
		throw new IllegalStateException("JLPT levels go from 5 to 1.");
	}
}
