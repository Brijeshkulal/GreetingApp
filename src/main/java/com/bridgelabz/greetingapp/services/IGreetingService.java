package com.bridgelabz.greetingapp.services;

import java.util.List;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	
	Greeting getGreetingById(long id);
	
	List<Greeting> getAllGreetings();

	Greeting editGreeting(long id, User user);
	
	Greeting updateGreeting(long id, User user);
	
	void deleteGreeting(long id);
}
