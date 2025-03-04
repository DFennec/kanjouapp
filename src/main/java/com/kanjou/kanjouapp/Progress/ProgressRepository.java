package com.kanjou.kanjouapp.Progress;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Student.Student;

public interface ProgressRepository extends JpaRepository<Progress, Long>{
    List<Progress> findProgressByStudent(Student student);
    Optional<Progress> findProgressByKanjiAndStudent(Kanji kanji, Student student);
}
