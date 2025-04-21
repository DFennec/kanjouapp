package com.kanjou.kanjouapp.Progress.DTO;

import java.util.List;

import com.kanjou.kanjouapp.Student.Student;

import lombok.Data;

@Data
public class StudentProgressResponse {
    private Long id;
    private String name;
    private String email;
    private List<ProgressResponse> progressList;

    public StudentProgressResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.progressList = student.getProgress().stream()
            .map(ProgressResponse::new)
            .toList();
    }
}