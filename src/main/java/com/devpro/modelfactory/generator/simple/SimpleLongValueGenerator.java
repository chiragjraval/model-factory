package com.devpro.modelfactory.generator.simple;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestLongValue;
import com.devpro.modelfactory.generator.ValueGenerator;

public class SimpleLongValueGenerator implements ValueGenerator<Long> {

	@Override
	public Long generate(Annotation annotation, Object ctx) {
		TestLongValue testValueAnnotation = annotation instanceof TestLongValue ? (TestLongValue) annotation : null ;
		return Objects.nonNull(testValueAnnotation) ? testValueAnnotation.defaultValue() : 0L;
	}

}
