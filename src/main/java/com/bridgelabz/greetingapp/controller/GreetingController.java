package com.bridgelabz.greetingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.services.GreetingService;



@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;

	@PostMapping("/greeting")
	public Greeting addGreeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/get/{id}")
	public String getMessageById(@PathVariable Long id) {
		return greetingService.getGreetingById(id).getMessage();
	}
	
	@GetMapping("/get")
	public List<Greeting> getAllGreets() {
		return greetingService.getAllGreetings();
	}
	
	@PutMapping("/edit/{id}")
	public Greeting sayHelloPutMethod(@PathVariable Long id,
			@RequestParam(value="firstName",defaultValue = "")String firstName,
			@RequestParam(value="lastName",defaultValue = "")String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.editGreeting(id,user);
	}
}
