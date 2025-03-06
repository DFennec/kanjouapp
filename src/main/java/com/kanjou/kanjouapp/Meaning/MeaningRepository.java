package com.kanjou.kanjouapp.Meaning;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface MeaningRepository extends JpaRepository<Meaning, Long>{
    List<Meaning> findMeaningByKanji(Kanji kanji);
    List<Kanji> findKanjiByMeaning(Meaning meaning);
}
