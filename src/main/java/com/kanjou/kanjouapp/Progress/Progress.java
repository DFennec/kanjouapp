package com.kanjou.kanjouapp.Progress;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Student.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name ="progress")
public class Progress {


    @Id
    @SequenceGenerator(name = "progress_sequence", sequenceName = "progress_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progress_sequence")
    private Long id;
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Kanji kanji;
    private Integer progress;

    public Student getStudent() {
        return student;
    }

    public Kanji getKanji() {
        return kanji;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
    
}