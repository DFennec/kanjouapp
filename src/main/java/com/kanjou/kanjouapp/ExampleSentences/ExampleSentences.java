package com.kanjou.kanjouapp.ExampleSentences;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "example_sentences")
public class ExampleSentences {
    @Id
    @SequenceGenerator(name = "exSentencenes_sequence", sequenceName = "exSentencenes_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exSentencenes_sequence")
    private Long id;
    private String sentence;
    private String translation;

    public ExampleSentences(@NonNull String sentence, String translation) {
        this.sentence = sentence;
        this.translation = translation;
    }

    public ExampleSentences() {

    }

    public Long getId() {
        return id;
    }

    public String getSentence() {
        return sentence;
    }

    public String getTranslation() {
        return translation;
    }
}
