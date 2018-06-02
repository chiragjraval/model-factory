package com.devpro.modelfactory.generator;

public interface ValueGenerator<T> {

	public abstract T generate(Object ctx);
	
}
