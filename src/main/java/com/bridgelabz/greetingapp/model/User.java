package com.bridgelabz.greetingapp.model;


public class User {
	private String firstName;
	private String lastName;
	
	public User() {

	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
    public String toString() {
        String message = (firstName != null) ? firstName + " " : "";
        message += (lastName != null) ? lastName : "";
        return message.trim();
    }

	


}
