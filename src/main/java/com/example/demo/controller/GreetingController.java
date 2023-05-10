package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.GreetingService;

@RequiredArgsConstructor
@RestController
public class GreetingController {

	private final GreetingService greetingService;

	@GetMapping("/greeting")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return greetingService.printHello(name);
	}
}
