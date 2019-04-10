package com.revature.project.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
        super("User Not Found.");
    }
}
