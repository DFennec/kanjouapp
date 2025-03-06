package com.kanjou.kanjouapp.Romaji;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;

@Service
public class RomajiService {
	private final RomajiRepository romajiRepository;

	private final KanjiRepository kanjiRepository;
	public RomajiService(RomajiRepository romajiRepository, KanjiRepository kanjiRepository){
		this.romajiRepository = romajiRepository;
		this.kanjiRepository = kanjiRepository;
	}

	public List<Romaji> getRomajiByKanji(String kanji) {
		Kanji kanjiEntity = kanjiRepository.findKanjiByKanji(kanji)
		.orElseThrow(() -> new IllegalStateException("Kanji not found."));
		List<Romaji> romajiByKanji=romajiRepository.findRomajiByKanji(kanjiEntity);
		if(romajiByKanji.size()>0){
			return romajiByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
	public List<Kanji> getKanjiByRomaji(String romaji) {
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
