package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestInteger;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.IntegerGenerator;
import com.devpro.modelfactory.generator.ValueGenerator;

public class TestIntegerProcessor implements AnnotationProcessor<Integer> {

	@Override
	public ValueGenerator<Integer> process(Annotation annotation) throws ModelInstantiationException {
		if(Objects.isNull(annotation) || !TestInteger.class.equals(annotation.annotationType())) {
			throw new ModelInstantiationException("Invalid Annotation configuration for Annotation Processor");
		}
		TestInteger testIntegerAnnotation = (TestInteger) annotation;
		return new IntegerGenerator(testIntegerAnnotation.defaultValue());
	}

}
