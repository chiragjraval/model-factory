package com.devpro.modelfactory.exception;

@FunctionalInterface
public interface ExceptionHandler<T> {

	public T get() throws Exception;
	
}
