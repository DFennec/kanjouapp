package com.kanjou.kanjouapp.Vocabulary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface VocabularyRepository extends JpaRepository<Kanji, Long>{
    List<Vocabulary> findVocabularyByKanji(String kanji);
}
