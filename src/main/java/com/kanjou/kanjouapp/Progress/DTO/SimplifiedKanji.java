package com.kanjou.kanjouapp.Progress.DTO;

import java.util.List;

import com.kanjou.kanjouapp.Kanji.Kanji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplifiedKanji {
    private Long id;
    private String character;
    private Integer JLPT;
    private List<String> meaning;
    private List<String> onyomi;
    private List<String> kunyomi;

    public SimplifiedKanji(Kanji kanji) {
        this.id = kanji.getId();
        this.character = kanji.getKanji();
        this.JLPT = kanji.getJLPT();
        kanji.getMeaning().forEach(Meaning -> {
            this.meaning.add(Meaning.getMeaning());
        });
        kanji.getOnyomi().forEach(Onyomi -> {
            this.onyomi.add(Onyomi.getOnyomi());
        });
        kanji.getKunyomi().forEach(Kunyomi -> {
            this.kunyomi.add(Kunyomi.getKunyomi());
        });

    }
}