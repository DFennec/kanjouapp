package com.kanjou.kanjouapp.Kunyomi;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
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
