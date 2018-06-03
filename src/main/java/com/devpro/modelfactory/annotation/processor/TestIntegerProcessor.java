package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestInteger;
import com.devpro.modelfactory.exception.ExceptionHandler;
import com.devpro.modelfactory.exception.ExceptionHandlerTemplate;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.IntegerGenerator;
import com.devpro.modelfactory.generator.ValueGenerator;

public class TestIntegerProcessor implements AnnotationProcessor<Integer> {

	@Override
	public ValueGenerator<Integer> process(Annotation annotation) throws ModelInstantiationException {
		if(Objects.isNull(annotation) || !TestInteger.class.equals(annotation.annotationType())) {
			throw new ModelInstantiationException("Invalid Annotation configuration for Annotation Processor");
		}
		
		return ExceptionHandlerTemplate.runAndThrowModelInstantiationException(new ExceptionHandler<IntegerGenerator>() {
			@Override
			public IntegerGenerator get() throws Exception {
				TestInteger testIntegerAnnotation = (TestInteger) annotation;
				Class<? extends IntegerGenerator> generatorType = testIntegerAnnotation.generatorType();
				IntegerGenerator generator = generatorType.newInstance();
				generator.setValue(testIntegerAnnotation.value());
				return generator;
			}
		}, "Error while instantiating generator for " + annotation);

	}

}
