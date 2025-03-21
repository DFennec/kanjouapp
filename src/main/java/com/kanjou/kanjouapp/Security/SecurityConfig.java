package com.kanjou.kanjouapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//Users to log in
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails alvaro = User.builder()
            .username("alvaro.s379166@gmail.com")
            .password("{noop}password123")
            .build();
        UserDetails david = User.builder()
            .username("david2012@gmail.com")
            .password("{noop}password123")
            .build();
        UserDetails pilar = User.builder()
            .username("agumarin@gmail.com")
            .password("{noop}password123")
            .build();
        UserDetails julia = User.builder()
            .username("julia5@gmail.com")
            .password("{noop}password123")
            .build();

            return new InMemoryUserDetailsManager(alvaro, david, pilar, julia);
    }
    //Custom login page
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      
        http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated())
        .formLogin(form -> form
        .loginPage("/api/v1/login/page")
        .loginProcessingUrl("/loginAuth")//La autenticación no necesita controlador
        .permitAll());//HAY QUE CREAR UN CONTROLADOR PARA MOSTRAR LA PÁGINA PERSONALIZADA DE LOGIN
        
        return http.build();
    }
}
