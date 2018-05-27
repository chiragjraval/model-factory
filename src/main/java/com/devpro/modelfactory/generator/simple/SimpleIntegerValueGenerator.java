package com.devpro.modelfactory.generator.simple;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestIntegerValue;
import com.devpro.modelfactory.generator.ValueGenerator;

public class SimpleIntegerValueGenerator implements ValueGenerator<Integer> {

	@Override
	public Integer generate(Annotation annotation, Object ctx) {
		TestIntegerValue testValueAnnotation = annotation instanceof TestIntegerValue ? (TestIntegerValue) annotation : null ;
		return Objects.nonNull(testValueAnnotation) ? testValueAnnotation.defaultValue() : 0;
	}

}
