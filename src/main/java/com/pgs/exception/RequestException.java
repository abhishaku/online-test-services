package com.pgs.exception;

public class RequestException extends RuntimeException{

	private static final long serialVersionUID = -6914778114025795551L;
	
	public RequestException(String message) {
		super(message);
	}
	
}
