package com.rahul.SpringWebThymeleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Web";
	}
	
	@PostMapping("/post")
	public String postDemo() {
		return "Post Executed";
	}
	
}
