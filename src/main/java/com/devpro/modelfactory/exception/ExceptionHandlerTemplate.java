package com.devpro.modelfactory.exception;

public class ExceptionHandlerTemplate {

	public static <T> T runAndThrowModelInstantiationException(ExceptionHandler<T> supplier, String errorMessage) throws ModelInstantiationException {
		try {
			return supplier.get();
		}
		catch (Exception ex) {
			throw new ModelInstantiationException(errorMessage, ex);
		}
	}
	
}
