package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Vocabulary.Vocabulary;

public interface ExampleSentencesRepository extends JpaRepository<ExampleSentences, Long>{
    List<ExampleSentences> findSentencesByVocabulary(Vocabulary vocabulary);
}
