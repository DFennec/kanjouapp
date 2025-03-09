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

	public List<Kanji> getKanjiByJLPT(Integer JLPT) {
		if (JLPT >= 1 && JLPT <= 5) {
			return kanjiRepository.findKanjiByJLPT(JLPT);
		}
		throw new IllegalStateException("JLPT levels go from 5 to 1.");
	}

	public Kanji saveKanji(Kanji kanji) {
		Optional<Kanji> kanjiByKanji=kanjiRepository.findKanjiByKanji(kanji.getKanji());
		if(kanjiByKanji.isPresent()){
			throw new IllegalStateException("Kanji already stored.");
		}
		System.out.println("AQUI ESTA EL DEBUG"+ kanji.getJLPT());
		return kanjiRepository.save(kanji);
	}

}
