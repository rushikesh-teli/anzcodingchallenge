package com.anz.codingchallenge.accountservice.exception;

public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 6724336964557204700L;
	
	public DataNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public DataNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
