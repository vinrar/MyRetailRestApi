package com.vreddy.myretail.exception;

public class MRException extends Exception {
	private static final long serialVersionUID = 1L;

	public MRException(String message) {
	        super(message);
	    }

    public MRException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
