package com.kanjou.kanjouapp.Progress;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Student.Student;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "api/v1/progress")
public class ProgressController {
    
    private final ProgressService progressService;
    
    public ProgressController(ProgressService progressService){
        this.progressService = progressService;
    }

	@GetMapping("/all")
	public List<Progress> getAllProgress(@RequestParam Student student) {
		return progressService.getProgressByStudent(student);
	}

	@GetMapping("/")
	public Progress getProgressByKanjiAndStudent(@RequestParam Long kanjiId, @RequestParam Long studentId) {
		return progressService.getProgressByKanjiAndStudent(kanjiId, studentId);
	}

	@PostMapping("/")
	public ResponseEntity<Progress> saveProgress(
		@RequestParam Long kanjiId,
		@RequestParam Long studentId,
		@RequestParam Integer progress) {
		
		Progress savedProgress = progressService.saveProgress(kanjiId, studentId, progress);
		return ResponseEntity.ok(savedProgress);
	}

	@PatchMapping("/")
	public Progress updateProgress(@RequestParam Long kanjiId, @RequestParam Long studentId, @RequestBody Integer progress) {
		return progressService.updateProgress(kanjiId,studentId,progress);
	}

}
