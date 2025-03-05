package com.kanjou.kanjouapp.Kanji;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

import com.kanjou.kanjouapp.Kunyomi.Kunyomi;
import com.kanjou.kanjouapp.Onyomi.Onyomi;
import com.kanjou.kanjouapp.Progress.Progress;
import com.kanjou.kanjouapp.Romaji.Romaji;
import com.kanjou.kanjouapp.Vocabulary.Vocabulary;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "kanji")
public class Kanji {

    @Id
    @SequenceGenerator(name = "kanji_sequence", sequenceName = "kanji_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kanji_sequence")
    private Long id;
    private String kanji;
    private Integer jlptLevel;

    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vocabulary> vocabulary = new ArrayList<Vocabulary>();
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Progress> progress = new ArrayList<Progress>();
    
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Kunyomi> kunyomi = new ArrayList<Kunyomi>();
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Onyomi> onyomi = new ArrayList<Onyomi>();
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Romaji> romaji = new ArrayList<Romaji>();

        public Kanji(@NonNull String kanji, Integer jlptLevel, List<Vocabulary> vocabulary, List<Progress> progress, List<Kunyomi> kunyomi, List<Onyomi> onyomi, List<Romaji> romaji) {
            this.kanji = kanji;
            this.jlptLevel = jlptLevel;
            this.vocabulary = vocabulary; 
            this.progress = progress;
            this.kunyomi = kunyomi;
            this.onyomi = onyomi;
            this.romaji = romaji;
        }

        public Kanji() {

        }

        public Long getId() {
            return id;
        }

        public List<Kunyomi> getKunyomi() {
            return kunyomi;
        }

        public List<Onyomi> getOnyomi() {
            return onyomi;
        }

        public List<Romaji> getRomaji() {
            return romaji;
        }

        public List<Vocabulary> getVocabulary() {
            return vocabulary;
        }

        public List<Progress> getProgress() {
            return progress;
        }

        public String getKanji() {
            return kanji;
        }

        public Integer getJlptLevel() {
            return jlptLevel;
        }

    }