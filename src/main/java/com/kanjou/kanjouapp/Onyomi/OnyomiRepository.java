package com.kanjou.kanjouapp.Onyomi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface OnyomiRepository extends JpaRepository<Onyomi, Long>{
    List<Onyomi> findOnyomiByKanji(Kanji kanji);
    List<Kanji> findKanjiByOnyomi(Onyomi onyomi);
}
