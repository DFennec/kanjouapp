package com.kanjou.kanjouapp.Onyomi;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;

@Service
public class OnyomiService {
	private final OnyomiRepository onyomiRepository;

	public OnyomiService(OnyomiRepository onyomiRepository){
		this.onyomiRepository = onyomiRepository;
	}

	public List<Onyomi> getOnyomiByKanji(Kanji kanji) {
		List<Onyomi> onyomiByKanji=onyomiRepository.findOnyomiByKanji(kanji);
		if(onyomiByKanji.size()>0){
			return onyomiByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
	public List<Kanji> getKanjiByOnyomi(Onyomi onyomi) {
		List<Kanji> kanjiByonyomi=onyomiRepository.findKanjiByOnyomi(onyomi);
		if(kanjiByonyomi.size()>0){
			return kanjiByonyomi;
		}
		throw new IllegalStateException("There's no such Onyomi.");
	}
	public Onyomi saveOnyomi(Onyomi onyomi) {
		return onyomiRepository.save(onyomi);
	}
}
