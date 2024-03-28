package com.prinsa.springboot.MyToDoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	//say hello ==> "Hello! What are you learing today?"
	//http://localhost:8080/hello
	@GetMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "Hello!What are you learing today?";
	}
	
	/// MyToDoApp/src/main/resources/META-INF/resources/WEB-INF/jsp
	// http://localhost:8080/hello-jsp
	@GetMapping("hello-jsp")
	public String sayHelloHTML() {
		return "hello";
	}
}
