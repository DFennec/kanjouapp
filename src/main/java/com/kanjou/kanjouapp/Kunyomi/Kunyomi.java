package com.kanjou.kanjouapp.Kunyomi;

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
@Table(name = "kunyomi")
public class Kunyomi {
    @Id
    @SequenceGenerator(name = "kunyomi_sequence", sequenceName = "kunyomi_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kunyomi_sequence")
    private Long id;
    private String kunyomi;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kanji_id")
    private Kanji kanji;

    public Kunyomi(String kunyomi, Kanji kanji) {
        this.kunyomi = kunyomi;
        this.kanji = kanji;
    }


    public Kunyomi() {

    }

    public Kanji getKanji() {
        return kanji;
    }

    public Long getId() {
        return id;
    }

    public String getKunyomi() {
        return kunyomi;
    }
}
