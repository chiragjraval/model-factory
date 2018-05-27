package com.devpro.modelfactory.generator.simple;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.devpro.modelfactory.annotation.TestStringValue;
import com.devpro.modelfactory.generator.ValueGenerator;

public class SimpleStringValueGenerator implements ValueGenerator<String> {

	@Override
	public String generate(Annotation annotation, Object ctx) {
		TestStringValue testValueAnnotation = annotation instanceof TestStringValue ? (TestStringValue) annotation : null ;
		return Objects.nonNull(testValueAnnotation) ? testValueAnnotation.defaultValue() : "";
	}

}
