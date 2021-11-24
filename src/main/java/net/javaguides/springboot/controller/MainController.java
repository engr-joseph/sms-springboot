package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
