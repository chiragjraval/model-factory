package com.devpro.modelfactory.exception;

public class ModelInstantiationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ModelInstantiationException(String message) {
		super(message);
	}
	
	public ModelInstantiationException(Throwable cause) {
		super(cause);
	}
	
	public ModelInstantiationException(String message, Throwable cause) {
		super(message, cause);
	}

}
