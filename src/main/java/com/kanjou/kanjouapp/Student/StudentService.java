package com.kanjou.kanjouapp.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}


    public List<Student> getStudents(){
			return studentRepository.findAll();
	}

	public Student getStudentById(Long Id) {
		Optional<Student> studentById=studentRepository.findById(Id);
		if(studentById.isPresent()){
			return studentById.get();
		}
		throw new IllegalStateException("Student not found.");
	}


	public Student saveStudent(Student student) {
		Optional<Student> studentByEmail=studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("Email not available");
		}
		return studentRepository.save(student);
	}


	public Student updateStudent(Student student) {
		Optional<Student> studentById=studentRepository.findStudentById(student.getId());
		if(studentById.isPresent()){
			return studentRepository.save(student);
		}
		throw new IllegalStateException("Student not found.");
	}


	public String deleteStudent(Long id) {
		Optional<Student> studentById = studentRepository.findStudentById(id);
		if (studentById.isPresent()) {
			studentRepository.deleteById(id);
			return "Student with id " + id + " deleted.";
		}
		throw new IllegalStateException("Student with id " + id + " not found.");
	}
}
