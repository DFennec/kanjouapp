package com.kanjou.kanjouapp.Student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    
    private final StudentService studentService;
    
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}

    
    @GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
	}

    @PostMapping("/save")
	public Student saveStudent(@RequestBody Student student){
		return studentService.saveStudent(student);
	}

    @PatchMapping("/update")
	public Student updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}

    @DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id){
		studentService.deleteStudent(id);
	}
}
