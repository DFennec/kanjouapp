package com.kanjou.kanjouapp.Romaji;

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
@Table(name = "romaji")
public class Romaji {
    @Id
    @SequenceGenerator(name = "romaji_sequence", sequenceName = "romaji_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "romaji_sequence")
    private Long id;
    private String romaji;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kanji_id")
    private Kanji kanji;

    public Romaji(String romaji, Kanji kanji) {
        this.romaji = romaji;
        this.kanji = kanji;
    }


    public Romaji() {

    }

    public Kanji getKanji() {
        return kanji;
    }

    public Long getId() {
        return id;
    }

    public String getRomaji() {
        return romaji;
    }
}
