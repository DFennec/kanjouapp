package com.kanjou.kanjouapp.Student;

/*//DANGER IT BREAKS THE CODE
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
            Student alvaro = new Student(
			1L,
			"Álvaro",
			"8a89l89g9@gmail.com",
			"123456",
			LocalDate.of(1999,8 , 8)
            );
            Student alex = new Student(
			2L,
			"Alex",
			"alex@gmail.com",
			"123456",
			LocalDate.of(2004,2 , 2)
            );
            
            repository.save(alvaro);
            repository.save(alex);
        };
    }
}
*/