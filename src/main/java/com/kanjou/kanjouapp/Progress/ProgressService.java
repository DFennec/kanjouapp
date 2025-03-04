package com.kanjou.kanjouapp.Progress;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Kanji.Kanji;
import com.kanjou.kanjouapp.Student.Student;

@Service
public class ProgressService {

	private final ProgressRepository progressRepository;

	public ProgressService(ProgressRepository studentRepository){
		this.progressRepository = studentRepository;
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

	public Progress getProgressByKanjiAndStudent(Kanji kanji, Student student){//to get the progress of a student in a specific kanji
		
		List<Progress>findProgress=progressRepository.findProgressByStudent(student);
	
		if(student==null){
			throw new IllegalStateException("Student not found.");
		}else if (findProgress.isEmpty()){
			throw new IllegalStateException("No progress found.");
		}

		return progressRepository.findProgressByKanjiAndStudent(kanji, student).get();
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
