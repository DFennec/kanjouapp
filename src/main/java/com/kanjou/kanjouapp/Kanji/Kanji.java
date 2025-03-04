package com.kanjou.kanjouapp.Kanji;

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
    @SequenceGenerator(name = "kanji_sequence", sequenceName = "kanji_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kanji_sequence")
    private Long id;
    private String kanji;
    private Integer jlptLevel;




        public Kanji(@NonNull String kanji, Integer jlptLevel) {
            this.kanji = kanji;
            this.jlptLevel = jlptLevel;
        }

        public Kanji() {

        }

        public Long getId() {
            return id;
        }

        public String getKanji() {
            return kanji;
        }

        public Integer getJlptLevel() {
            return jlptLevel;
        }

    }