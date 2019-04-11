package com.revature.project.exceptions;

public class TransactionNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException() {
		super("The account has been overdrafted, a fee will be charged.");
	}
}
