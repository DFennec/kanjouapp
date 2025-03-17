package com.kanjou.kanjouapp.Kunyomi;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;

@Service
public class KunyomiService {
	private final KunyomiRepository kunyomiRepository;
	private final KanjiRepository kanjiRepository;

	public KunyomiService(KunyomiRepository kunyomiRepository, KanjiRepository kanjiRepository) {
		this.kunyomiRepository = kunyomiRepository;
		this.kanjiRepository = kanjiRepository;
	}

	public List<Kunyomi> getKunyomiByKanji(String kanji) {
		Kanji kanjiEntity = kanjiRepository.findKanjiByKanji(kanji)
				.orElseThrow(() -> new IllegalStateException("Kanji not found."));
		return kunyomiRepository.findKunyomiByKanji(kanjiEntity);
	}
    public List<Kanji> getKanjiByKunyomi(String kunyomi) {
        List<Kanji> kanjiByKunyomi = kunyomiRepository.findKanjiByKunyomi(kunyomi);
        if (kanjiByKunyomi.isEmpty()) {
            throw new IllegalStateException("There's no such kunyomi.");
        }
        return kanjiByKunyomi;
    }
	public Kunyomi saveKunyomi(Kunyomi kunyomi) {
		if (kunyomi.getKunyomi() == null || kunyomi.getKunyomi().isEmpty()) {
			throw new IllegalStateException("No kunyomi sent.");
		}
		return kunyomiRepository.save(kunyomi);
	}
}
