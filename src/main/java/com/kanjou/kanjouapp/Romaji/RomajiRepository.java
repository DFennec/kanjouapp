package com.kanjou.kanjouapp.Romaji;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface RomajiRepository extends JpaRepository<Romaji, Long>{
    List<Romaji> findRomajiByKanji(Kanji kanji);
    List<Kanji> findKanjiByRomaji(String romaji);
}
