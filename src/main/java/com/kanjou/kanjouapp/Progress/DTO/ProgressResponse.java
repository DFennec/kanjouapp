package com.kanjou.kanjouapp.Progress.DTO;

import com.kanjou.kanjouapp.Progress.Progress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressResponse {
    private Long id;
    private Integer progress;
    private SimplifiedKanji kanji;

    public ProgressResponse(Progress progress) {
        this.id = progress.getId();
        this.progress = progress.getProgress();
        this.kanji = new SimplifiedKanji(progress.getKanji());
    }
}