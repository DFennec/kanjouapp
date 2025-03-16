package com.kanjou.kanjouapp.Vocabulary;

import java.util.ArrayList;
import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vocabulary")
public class Vocabulary {

    @Id
    @SequenceGenerator(name = "vocabulary_sequence", sequenceName = "vocabulary_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vocabulary_sequence")
    private Long id;
    private String word;
    private String translation;

    @OneToMany(mappedBy="vocabulary", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExampleSentences> exampleSentences = new ArrayList<ExampleSentences>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kanji_id")
    private Kanji kanji;

    public List<ExampleSentences> getExampleSentences() {
        return exampleSentences;
    }

    public Kanji getKanji() {
        return kanji;
    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
