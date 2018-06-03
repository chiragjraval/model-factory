package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestLong;
import com.devpro.modelfactory.exception.ExceptionHandler;
import com.devpro.modelfactory.exception.ExceptionHandlerTemplate;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.LongGenerator;
import com.devpro.modelfactory.generator.ValueGenerator;

public class TestLongProcessor implements AnnotationProcessor<Long> {

	@Override
	public ValueGenerator<Long> process(Annotation annotation) throws ModelInstantiationException {
		if(Objects.isNull(annotation) || !TestLong.class.equals(annotation.annotationType())) {
			throw new ModelInstantiationException("Invalid Annotation configuration for Annotation Processor");
		}
		
		return ExceptionHandlerTemplate.runAndThrowModelInstantiationException(new ExceptionHandler<LongGenerator>() {
			@Override
			public LongGenerator get() throws Exception {
				TestLong testIntegerAnnotation = (TestLong) annotation;
				Class<? extends LongGenerator> generatorType = testIntegerAnnotation.generatorType();
				LongGenerator generator = generatorType.newInstance();
				generator.setValue(testIntegerAnnotation.value());
				return generator;
			}
		}, "Error while instantiating generator for " + annotation);
	}
	
}
