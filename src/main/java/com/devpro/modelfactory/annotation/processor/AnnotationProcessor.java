package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;

import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.ValueGenerator;

public interface AnnotationProcessor<T> {

	ValueGenerator<T> process(Annotation annotation) throws ModelInstantiationException;
	
}
