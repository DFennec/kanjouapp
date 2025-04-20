package com.kanjou.kanjouapp.Login;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {


    private final AuthenticationService authService;

    @GetMapping("/page")
    public String loginPage() {
        
        return "loginPage";
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> loginAuth(@RequestBody AuthenticationRequest request) throws Exception {
        return ResponseEntity.ok(authService.loginAuth(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
