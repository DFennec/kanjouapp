package com.kanjou.kanjouapp.Progress;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Kanji.Kanji;
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
	public Progress getProgressByProgress(@RequestParam Kanji kanji, @RequestParam Student student) {
		return progressService.getProgressByKanjiAndStudent(kanji, student);
	}

	@PostMapping("/")
	public Progress saveProgress(@RequestBody Progress progress) {
		return progressService.saveProgress(progress);
	}

	@PatchMapping("/")
	public Progress updateProgress(@RequestBody Progress progress) {
		return progressService.updateProgress(progress);
	}

}
