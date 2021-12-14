package com.bridgelabz.greetingapp.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

@Service
public class GreetingService implements IGreetingService {
	private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user) {
    	String message = String.format(template, (user.toString().isEmpty() ? "World" : user.toString()));
		return new Greeting(counter.incrementAndGet(), message);
    }

}
