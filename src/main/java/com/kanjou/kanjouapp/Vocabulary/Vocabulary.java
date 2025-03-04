package com.kanjou.kanjouapp.Vocabulary;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
    @Id
    @SequenceGenerator(name = "vocabulary_sequence", sequenceName = "vocabulary_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vocabulary_sequence")
    private Long id;
    private String word;

    public Vocabulary(@NonNull String word) {
        this.word = word;
    }

    public Vocabulary() {

    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
}
