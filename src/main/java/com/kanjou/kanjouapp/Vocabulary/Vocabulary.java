package com.kanjou.kanjouapp.Vocabulary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

import com.kanjou.kanjouapp.ExampleSentences.ExampleSentences;
import com.kanjou.kanjouapp.Kanji.Kanji;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy="vocabulary", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExampleSentences> exampleSentences = new ArrayList<ExampleSentences>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kanji_id")
    private Kanji kanji;

    public Vocabulary(@NonNull String word, List<ExampleSentences> exampleSentences, Kanji kanji) {
        this.word = word;
        this.exampleSentences = exampleSentences;
        this.kanji = kanji;
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
