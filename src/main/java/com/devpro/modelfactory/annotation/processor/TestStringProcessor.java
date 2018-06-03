package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestString;
import com.devpro.modelfactory.exception.ExceptionHandler;
import com.devpro.modelfactory.exception.ExceptionHandlerTemplate;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.StringGenerator;
import com.devpro.modelfactory.generator.ValueGenerator;

public class TestStringProcessor implements AnnotationProcessor<String> {
	
	@Override
	public ValueGenerator<String> process(Annotation annotation) throws ModelInstantiationException {
		if(Objects.isNull(annotation) || !TestString.class.equals(annotation.annotationType())) {
			throw new ModelInstantiationException("Invalid Annotation configuration for Annotation Processor");
		}
		
		return ExceptionHandlerTemplate.runAndThrowModelInstantiationException(new ExceptionHandler<StringGenerator>() {
			@Override
			public StringGenerator get() throws Exception {
				TestString testIntegerAnnotation = (TestString) annotation;
				Class<? extends StringGenerator> generatorType = testIntegerAnnotation.generatorType();
				StringGenerator generator = generatorType.newInstance();
				generator.setValue(testIntegerAnnotation.value());
				return generator;
			}
		}, "Error while instantiating generator for " + annotation);
	}
	
}
