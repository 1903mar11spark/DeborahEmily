  package com.revature.project.exceptions;

public class OverdraftException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 772314690297441599L;

	public OverdraftException() {
        super("The account has been overdrafted, a fee will be charged.");
    }
}
