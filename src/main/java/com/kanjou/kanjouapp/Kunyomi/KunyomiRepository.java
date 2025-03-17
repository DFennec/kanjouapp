package com.kanjou.kanjouapp.Kunyomi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface KunyomiRepository extends JpaRepository<Kunyomi, Long>{
    List<Kunyomi> findKunyomiByKanji(Kanji kanji);
    @Query("SELECT k.kanji FROM Kunyomi k WHERE k.kunyomi = :kunyomi")
    List<Kanji> findKanjiByKunyomi(@Param("kunyomi") String kunyomi);
}
