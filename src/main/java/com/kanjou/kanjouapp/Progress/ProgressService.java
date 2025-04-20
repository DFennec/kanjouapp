package com.kanjou.kanjouapp.Progress;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;
import com.kanjou.kanjouapp.Student.Student;
import com.kanjou.kanjouapp.Student.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProgressService {

    private final ProgressRepository progressRepository;
    private final StudentRepository studentRepository;
    private final KanjiRepository kanjiRepository;

    public ProgressService(ProgressRepository progressRepository,
                          KanjiRepository kanjiRepository,
                          StudentRepository studentRepository) {
        this.progressRepository = progressRepository;
        this.studentRepository = studentRepository;
        this.kanjiRepository = kanjiRepository;
    }

    public List<Progress> getProgressByStudent(Student student) {
        if (student == null) {
            throw new IllegalStateException("Student cannot be null.");
        }
        
        List<Progress> findProgress = progressRepository.findProgressByStudent(student);
        
        if (findProgress.isEmpty()) {
            throw new IllegalStateException("No progress found for student.");
        }
        return findProgress;
    }

    public Progress getProgressByKanjiAndStudent(Long kanjiId, Long studentId) {
        Kanji kanji = kanjiRepository.findById(kanjiId)
            .orElseThrow(() -> new IllegalStateException("Kanji not found."));
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalStateException("Student not found."));
            
        return progressRepository.findProgressByKanjiAndStudent(kanji, student)
            .orElseThrow(() -> new IllegalStateException("Progress not found."));
    }

	public Progress saveProgress(Long kanjiId, Long studentId, Integer progressValue) {
		
		Kanji kanji = kanjiRepository.findById(kanjiId)
			.orElseThrow(() -> new IllegalStateException("Kanji not found"));
		Student student = studentRepository.findById(studentId)

			.orElseThrow(() -> new IllegalStateException("Student not found"));
		if (progressRepository.findProgressByKanjiAndStudent(kanji, student).isPresent()) {
			throw new IllegalStateException("Progress already exists");
		}
		Progress progress = new Progress();
		progress.setKanji(kanji);
		progress.setStudent(student);
		progress.setProgress(progressValue);
	
		return progressRepository.save(progress);
	}
    
    public Progress updateProgress(Long kanjiId, Long studentId, Integer newProgress) {
        Progress progress = getProgressByKanjiAndStudent(kanjiId, studentId);
        if (newProgress != null) {
            progress.setProgress(newProgress);
        }
        return progressRepository.save(progress);
    }
}