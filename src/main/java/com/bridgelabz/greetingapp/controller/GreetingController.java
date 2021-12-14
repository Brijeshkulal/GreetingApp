package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.services.IGreetingService;


@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/query")
	public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/param/{name}")
	public Greeting greetingParam(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/post")
	public Greeting greetingPost(@RequestBody User user) {
		return new Greeting(counter.incrementAndGet(), String.format(template, user.getFirstName() + " " + user.getLastName()));
	}
	
	@PutMapping("put/{firstName}")
	public Greeting greetingPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
		return new Greeting(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
	}
	
	@Autowired
	private IGreetingService greetingService;
	

	@GetMapping("greeting/service")
	public Greeting getGreet(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
    }
}
