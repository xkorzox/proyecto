package com.sophossolutions.exception;

public class UnexpectedResult extends AssertionError{

	
	private static final long serialVersionUID = 1L;

	public UnexpectedResult(String message, Throwable cause) {
		super(message, cause);
	}
}
	