package com.kanjou.kanjouapp.Onyomi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface OnyomiRepository extends JpaRepository<Onyomi, Long>{
    List<Onyomi> findOnyomiByKanji(Kanji kanji);
    @Query("SELECT o.kanji FROM Onyomi o WHERE o.onyomi = :onyomi")
    List<Kanji> findKanjiByOnyomi(@Param("onyomi") String onyomi);
}
