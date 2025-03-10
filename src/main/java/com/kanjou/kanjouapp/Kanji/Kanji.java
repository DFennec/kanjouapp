package com.kanjou.kanjouapp.Kanji;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.kanjou.kanjouapp.Kunyomi.Kunyomi;
import com.kanjou.kanjouapp.Meaning.Meaning;
import com.kanjou.kanjouapp.Onyomi.Onyomi;
import com.kanjou.kanjouapp.Progress.Progress;
// import com.kanjou.kanjouapp.Romaji.Romaji;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kanji")
public class Kanji {

    @Id
    @SequenceGenerator(name = "kanji_sequence", sequenceName = "kanji_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kanji_sequence")
    private Long id;
    private String kanji;
    @JsonProperty("jlpt")
    private Integer JLPT;

    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vocabulary> vocabulary = new ArrayList<Vocabulary>();
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Progress> progress = new ArrayList<Progress>();
    
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Kunyomi> kunyomi = new ArrayList<Kunyomi>();
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Onyomi> onyomi = new ArrayList<Onyomi>();
    // @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<Romaji> romaji = new ArrayList<Romaji>();
    @OneToMany(mappedBy="kanji", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Meaning> meaning = new ArrayList<Meaning>();


        public Long getId() {
            return id;
        }

        public void setKanji(String kanji) {
            this.kanji = kanji;
        }

        public void setJLPT(Integer jLPT) {
            JLPT = jLPT;
        }

        public void setVocabulary(List<Vocabulary> vocabulary) {
            this.vocabulary = vocabulary;
        }

        public void setProgress(List<Progress> progress) {
            this.progress = progress;
        }

        public void setKunyomi(List<Kunyomi> kunyomi) {
            this.kunyomi = kunyomi;
        }

        public void setOnyomi(List<Onyomi> onyomi) {
            this.onyomi = onyomi;
        }

        // public void setRomaji(List<Romaji> romaji) {
        //     this.romaji = romaji;
        // }

        public void setMeaning(List<Meaning> meaning) {
            this.meaning = meaning;
        }

        public List<Kunyomi> getKunyomi() {
            return kunyomi;
        }

        public List<Onyomi> getOnyomi() {
            return onyomi;
        }

        // public List<Romaji> getRomaji() {
        //     return romaji;
        // }

        public List<Vocabulary> getVocabulary() {
            return vocabulary;
        }

        public List<Progress> getProgress() {
            return progress;
        }

        public String getKanji() {
            return kanji;
        }

        public Integer getJLPT() {
            return JLPT;
        }

    }