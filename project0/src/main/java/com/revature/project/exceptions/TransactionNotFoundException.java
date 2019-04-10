package com.revature.project.exceptions;

public class TransactionNotFoundException extends Exception {
	public TransactionNotFoundException() {
		super("The account has been overdrafted, a fee will be charged.");
	}
}
