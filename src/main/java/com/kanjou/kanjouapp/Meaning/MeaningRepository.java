package com.kanjou.kanjouapp.Meaning;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface MeaningRepository extends JpaRepository<Meaning, Long>{
    List<Meaning> findMeaningByKanji(Kanji kanji);
    @Query("SELECT m.kanji FROM Meaning m WHERE m.meaning = :meaning")
    List<Kanji> findKanjiByMeaning(@Param("meaning") String meaning);
}
