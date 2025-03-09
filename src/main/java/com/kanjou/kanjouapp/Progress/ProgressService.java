package com.kanjou.kanjouapp.Progress;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Kanji.KanjiRepository;
import com.kanjou.kanjouapp.Student.Student;
import com.kanjou.kanjouapp.Student.StudentRepository;

@Service
public class ProgressService {

	private final ProgressRepository progressRepository;

	private final StudentRepository studentRepository;

	private final KanjiRepository kanjiRepository;

	public ProgressService(ProgressRepository progressRepository,KanjiRepository kanjiRepository,StudentRepository studentRepository){
		this.progressRepository = progressRepository;
		this.studentRepository=studentRepository;
		this.kanjiRepository=kanjiRepository;
	}


    public List<Progress> getProgressByStudent(Student student){//to get every point of progress

	List<Progress>findProgress=progressRepository.findProgressByStudent(student);

	if(student==null){
		throw new IllegalStateException("Student not found.");
	}else if (findProgress.isEmpty()){
		throw new IllegalStateException("No progress found.");
	}
		return progressRepository.findProgressByStudent(student);
	}

	public Progress getProgressByKanjiAndStudent(Long kanjiId, Long studentId) {
		Kanji kanji = kanjiRepository.findById(kanjiId)		.orElseThrow(()->new IllegalStateException("Kanji not found."));
		Student student = studentRepository.findById(studentId)		.orElseThrow(()->new IllegalStateException("Student not found."));
		return progressRepository.findProgressByKanjiAndStudent(kanji, student)
		.orElseThrow(()->new IllegalStateException("Progress not found."));
	}



	public Progress saveProgress(Progress progress) {
		if(progressRepository.findProgressByKanjiAndStudent(progress.getKanji(), progress.getStudent()).isPresent()){
			throw new IllegalStateException("Progress already saved. Try updating/patching.");
		}
		return progressRepository.save(progress);
	}


	public Progress updateProgress(Progress progress) {
		Optional<Progress> progressByKanjiAndStudent=progressRepository.findProgressByKanjiAndStudent(progress.getKanji(),progress.getStudent());
		if(progressByKanjiAndStudent.isPresent()){
			return progressRepository.save(progress);
		}
		throw new IllegalStateException("Progress not registered.");
	}

}
