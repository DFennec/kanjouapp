package com.kanjou.kanjouapp.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kanjou.kanjouapp.Progress.Progress;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="student")
public class Student implements UserDetails{
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
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy="student", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Progress> progress = new ArrayList<Progress>();

    public List<Progress> getProgress() {
        return progress;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email; 
    }

    @Override
public boolean isAccountNonLocked() {
    return true;
}

@Override
public boolean isCredentialsNonExpired() {
    return true;
}
@Override
public boolean isEnabled() {
    return true;
}
}