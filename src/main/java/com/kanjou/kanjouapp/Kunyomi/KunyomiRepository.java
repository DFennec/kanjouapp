package com.kanjou.kanjouapp.Kunyomi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface KunyomiRepository extends JpaRepository<Kunyomi, Long>{
    List<Kunyomi> findKunyomiByKanji(Kanji kanji);
    List<Kanji> findKanjiByKunyomi(String kunyomi);
}
