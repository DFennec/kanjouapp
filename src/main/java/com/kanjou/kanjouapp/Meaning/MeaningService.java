package com.kanjou.kanjouapp.Meaning;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;

@Service
public class MeaningService {
	private final MeaningRepository meaningRepository;
	
	private final KanjiRepository kanjiRepository;

	public MeaningService(MeaningRepository meaningRepository, KanjiRepository kanjiRepository){
		this.meaningRepository = meaningRepository;
		this.kanjiRepository = kanjiRepository;
	}

	public List<Meaning> getMeaningByKanji(String kanji) {
		Kanji kanjiEntity = kanjiRepository.findKanjiByKanji(kanji)
		.orElseThrow(() -> new IllegalStateException("Kanji not found."));
		List<Meaning> meaningByKanji=meaningRepository.findMeaningByKanji(kanjiEntity);
		if(meaningByKanji.size()>0){
			return meaningByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
	public List<Kanji> getKanjiByMeaning(Meaning meaning) {
		List<Kanji> kanjiByMeaning=meaningRepository.findKanjiByMeaning(meaning);
		if(kanjiByMeaning.size()>0){
			return kanjiByMeaning;
		}
		throw new IllegalStateException("There's no such Meaning.");
	}
	public Meaning saveMeaning(Meaning meaning) {
		return meaningRepository.save(meaning);
	}
}
