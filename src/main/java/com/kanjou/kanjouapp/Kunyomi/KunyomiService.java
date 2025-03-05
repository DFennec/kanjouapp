package com.kanjou.kanjouapp.Kunyomi;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;

@Service
public class KunyomiService {
	private final KunyomiRepository kunyomiRepository;

	public KunyomiService(KunyomiRepository kunyomiRepository){
		this.kunyomiRepository = kunyomiRepository;
	}

	public List<Kunyomi> getKunyomiByKanji(Kanji kanji) {
		List<Kunyomi> kunyomiByKanji=kunyomiRepository.findKunyomiByKanji(kanji);
		if(kunyomiByKanji.size()>0){
			return kunyomiByKanji;
		}
		throw new IllegalStateException("There's no such kanji.");
	}
	public List<Kanji> getKanjiByKunyomi(Kunyomi kunyomi) {
		List<Kanji> kanjiByKunyomi=kunyomiRepository.findKanjiByKunyomi(kunyomi);
		if(kanjiByKunyomi.size()>0){
			return kanjiByKunyomi;
		}
		throw new IllegalStateException("There's no such kunyomi.");
	}
	public Kunyomi saveKunyomi(Kunyomi kunyomi) {
		return kunyomiRepository.save(kunyomi);
	}
}
