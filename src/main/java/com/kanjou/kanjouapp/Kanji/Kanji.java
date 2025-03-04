package com.kanjou.kanjouapp.Kanji;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "kanji")
public class Kanji {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String romaji;
    private String kanji;
    private String meaning;
    private String kunyomi;
    private String onyomi;
    private String vocabulary;
    private Integer jlptLevel;




        public Kanji(String romaji, @NonNull String kanji, String meaning, String kunyomi, String onyomi, String vocabulary,
                Integer jlptLevel) {
            this.romaji = romaji;
            this.kanji = kanji;
            this.meaning = meaning;
            this.kunyomi = kunyomi;
            this.onyomi = onyomi;
            this.jlptLevel = jlptLevel;
        }

        public Kanji() {

        }

        public Long getId() {
            return id;
        }

        public String getRomaji() {
            return romaji;
        }

        public String getKanji() {
            return kanji;
        }

        public String getMeaning() {
            return meaning;
        }

        public String getKunyomi() {
            return kunyomi;
        }

        public String getOnyomi() {
            return onyomi;
        }

        public String getVocabulary() {
            return vocabulary;
        }

        public Integer getJlptLevel() {
            return jlptLevel;
        }

    }