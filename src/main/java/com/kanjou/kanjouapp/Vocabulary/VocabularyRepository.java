package com.kanjou.kanjouapp.Vocabulary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long>{
    List<Vocabulary> findVocabularyByKanji(Kanji kanji);
}
