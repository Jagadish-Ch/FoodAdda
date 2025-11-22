package com.foodAdda.exception;

public class InvalidCredentials extends RuntimeException {
	public InvalidCredentials(String message) {
		super(message);
	}
}
