package com.kanjou.kanjouapp.Meaning;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;

@Service
public class MeaningService {
	private final MeaningRepository meaningRepository;

	public MeaningService(MeaningRepository meaningRepository){
		this.meaningRepository = meaningRepository;
	}

	public List<Meaning> getMeaningByKanji(Kanji kanji) {
		List<Meaning> meaningByKanji=meaningRepository.findMeaningByKanji(kanji);
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
