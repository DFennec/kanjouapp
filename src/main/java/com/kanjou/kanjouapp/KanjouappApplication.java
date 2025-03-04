package com.kanjou.kanjouapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class KanjouappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanjouappApplication.class, args);
	}



}
