package com.kanjou.kanjouapp.Login;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanjou.kanjouapp.Student.Student;

@Controller
@RequestMapping("/api/v1/login")
public class LoginController {

    @GetMapping("/page")
    public String loginPage() {
        
        return "loginPage";
    }
    /*
    @PostMapping("/auth")
    public ResponseEntity<?> loginAuth() {

    }
    /*
    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody Student student) {
        String token = JwtTokenClass.generateToken(student.getEmail());  
        return ResponseEntity.ok(Map.of("token", token));
    }*/
}
