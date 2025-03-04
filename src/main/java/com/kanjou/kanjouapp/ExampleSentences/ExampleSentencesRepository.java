package com.kanjou.kanjouapp.ExampleSentences;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleSentencesRepository extends JpaRepository<ExampleSentences, Long>{
    List<ExampleSentences> findSentencesById(Long id);
}
