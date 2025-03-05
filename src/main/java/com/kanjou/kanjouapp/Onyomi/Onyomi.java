package com.kanjou.kanjouapp.Onyomi;

import com.kanjou.kanjouapp.Kanji.Kanji;

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

@Entity
@Table(name = "onyomi")
public class Onyomi {
    @Id
    @SequenceGenerator(name = "onyomi_sequence", sequenceName = "onyomi_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "onyomi_sequence")
    private Long id;
    private String onyomi;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kanji_id")
    private Kanji kanji;

    public Onyomi(String onyomi, Kanji kanji) {
        this.onyomi = onyomi;
        this.kanji = kanji;
    }


    public Onyomi() {

    }

    public Kanji getKanji() {
        return kanji;
    }

    public Long getId() {
        return id;
    }

    public String getOnyomi() {
        return onyomi;
    }
}
