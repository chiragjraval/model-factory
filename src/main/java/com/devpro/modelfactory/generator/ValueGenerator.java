package com.devpro.modelfactory.generator;

import java.lang.annotation.Annotation;

public interface ValueGenerator<T> {

	public T generate(Annotation annotation, Object ctx);
	
}
