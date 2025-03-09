package com.kanjou.kanjouapp.ExampleSentences;

import com.kanjou.kanjouapp.Vocabulary.Vocabulary;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "example_sentences")
public class ExampleSentences {

    @Id
    @SequenceGenerator(name = "exSentencenes_sequence", sequenceName = "exSentencenes_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exSentencenes_sequence")
    private Long id;

    private String sentence;
    private String translation;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vocabulary_id")
    private Vocabulary vocabulary;

    public Long getId() {
        return id;
    }

    public String getSentence() {
        return sentence;
    }

    public String getTranslation() {
        return translation;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

}
