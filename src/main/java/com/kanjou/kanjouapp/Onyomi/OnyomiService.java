package com.kanjou.kanjouapp.Onyomi;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;

@Service
public class OnyomiService {
	private final OnyomiRepository onyomiRepository;
	
	private final KanjiRepository kanjiRepository;
	
	public OnyomiService(OnyomiRepository onyomiRepository, KanjiRepository kanjiRepository){
		this.onyomiRepository = onyomiRepository;
		this.kanjiRepository = kanjiRepository;
	}

	public List<Onyomi> getOnyomiByKanji(String kanji) {
		Kanji kanjiEntity = kanjiRepository.findKanjiByKanji(kanji)
		.orElseThrow(() -> new IllegalStateException("Kanji not found."));
		List<Onyomi> onyomiByKanji=onyomiRepository.findOnyomiByKanji(kanjiEntity);
		if(onyomiByKanji.size()>0){
			return onyomiByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}

	public List<Kanji> getKanjiByOnyomi(String onyomi) {
        List<Kanji> kanjiByOnyomi = onyomiRepository.findKanjiByOnyomi(onyomi);
        if (kanjiByOnyomi.isEmpty()) {
            throw new IllegalStateException("There's no such onyomi.");
        }
        return kanjiByOnyomi;
    }
	
	public Onyomi saveOnyomi(Onyomi onyomi) {
		return onyomiRepository.save(onyomi);
	}
}
