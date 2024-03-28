package com.prinsa.springboot.MyToDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyToDoAppApplication.class, args);
		System.out.println("My Todo app is starting..");
	}

}
