package com.bridgelabz.greetingapp.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
    	String message = String.format(template, (user.toString().isEmpty() ? "World" : user.toString()));
    	return new Greeting(counter.incrementAndGet(), message);
    }
    
    @Override
    public Greeting getGreetingById(long id) {
    	Optional<Greeting> greeting = greetingRepository.findById(id);
    	if (greeting.isPresent()) {
    		return greeting.get();
    	}
    	return null;
    }
    
    @Override
    public List<Greeting> getAllGreetings() {
    	return greetingRepository.findAll();
    }
    

    @Override
    public Greeting editGreeting(long id, User user) {
    	String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
    	Optional<Greeting> greetingData = greetingRepository.findById(id);
    	if (greetingData.isPresent()) {
    		Greeting greeting = greetingData.get();
    		greeting.setMessage(message);
    		greetingRepository.save(greeting);
    	}
    	return null;
    }
}
