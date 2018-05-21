package com.chirag.model.factory.exception;

public class ModelInstantiationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ModelInstantiationException(Throwable cause) {
		super(cause);
	}
	
	public ModelInstantiationException(String message, Throwable cause) {
		super(message, cause);
	}

}