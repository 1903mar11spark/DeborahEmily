package com.revature.project.exceptions;

public class AccountNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
        super("Account Not Found.");
    }

}
