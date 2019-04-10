package com.revature.project.exceptions;

public class OverdraftException extends RuntimeException {
    public OverdraftException() {
        super("The account has been overdrafted, a fee will be charged.");
    }
}
