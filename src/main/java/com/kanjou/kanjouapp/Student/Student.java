package com.kanjou.kanjouapp.Student;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="student")
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence", //defines the generator
        sequenceName = "student_sequence",//defines the name of the sequence in the database
        allocationSize = 1 //Used to define the step number of the id in the database (+1 in this case)
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,//defines the strategy of the generator
        generator = "student_sequence"//used to link the generator with the sequence
    )
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;

    public Student(String name, String email, String password, LocalDate dateOfBrith) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBrith;
    }

    public Student(Long id, String name, String email, String password, LocalDate dateOfBrith) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBrith;
    }

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //If I don't want it to appear in the HTTP Response I'll add: @JsonIgnore
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBrith) {
        this.dateOfBirth = dateOfBrith;
    }
    
}