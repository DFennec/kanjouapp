package com.kanjou.kanjouapp.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentById(Long id);
}
