package com.kanjou.kanjouapp.Romaji;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;

@Service
public class RomajiService {
	private final RomajiRepository romajiRepository;

	public RomajiService(RomajiRepository romajiRepository){
		this.romajiRepository = romajiRepository;
	}

	public List<Romaji> getRomajiByKanji(Kanji kanji) {
		List<Romaji> romajiByKanji=romajiRepository.findRomajiByKanji(kanji);
		if(romajiByKanji.size()>0){
			return romajiByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
	public List<Kanji> getKanjiByRomaji(Romaji romaji) {
		List<Kanji> kanjiByRomaji=romajiRepository.findKanjiByRomaji(romaji);
		if(kanjiByRomaji.size()>0){
			return kanjiByRomaji;
		}
		throw new IllegalStateException("There's no such Romaji.");
	}
	public Romaji saveRomaji(Romaji romaji) {
		return romajiRepository.save(romaji);
	}
}
