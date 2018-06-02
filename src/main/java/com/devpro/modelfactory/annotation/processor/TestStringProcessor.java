package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestString;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.StringGenerator;
import com.devpro.modelfactory.generator.ValueGenerator;

public class TestStringProcessor implements AnnotationProcessor<String> {
	
	@Override
	public ValueGenerator<String> process(Annotation annotation) throws ModelInstantiationException {
		if(Objects.isNull(annotation) || !TestString.class.equals(annotation.annotationType())) {
			throw new ModelInstantiationException("Invalid Annotation configuration for Annotation Processor");
		}
		TestString testStringAnnotation = (TestString) annotation;
		return new StringGenerator(testStringAnnotation.defaultValue());
	}
	
}
