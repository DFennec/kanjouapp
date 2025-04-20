package com.kanjou.kanjouapp.Login;

import java.time.LocalDate;
import java.util.Optional;

import com.kanjou.kanjouapp.Student.Role;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kanjou.kanjouapp.Config.JwtService;
import com.kanjou.kanjouapp.Student.Student;
import com.kanjou.kanjouapp.Student.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final StudentRepository studentRepository;
    private final PasswordEncoder pEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse loginAuth(AuthenticationRequest request) throws Exception{
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        Student user = studentRepository.findStudentByEmail(request.getEmail()).
        orElseThrow(() -> new Exception("User not found"));
        var jwtToken = jwtService.generateToken(user);
        studentRepository.save(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        Optional<Student> studentByEmail=studentRepository.findStudentByEmail(request.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("Email not available");
		}
        var user = Student.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(pEncoder.encode(request.getPassword()))
            .dateOfBirth(LocalDate.parse(request.getDateOfBirth()))  
            .role(Role.STUDENT)  
            .build();  
        
        var jwtToken = jwtService.generateToken(user);
        studentRepository.save(user);
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }
}
