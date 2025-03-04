package com.kanjou.kanjouapp.Kanji;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KanjiRepository extends JpaRepository<Kanji, Long>{
    Optional<Kanji> findKanjiByKanji(String kanji);
    List<Kanji> findKanjiByJLPT(Integer JLPT);
}
