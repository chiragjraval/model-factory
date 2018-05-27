package com.devpro.modelfactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.devpro.modelfactory.generator.simple.SimpleStringValueGenerator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TestStringValue {
	String defaultValue() default "default";
	Class<SimpleStringValueGenerator> valueGenerator() default SimpleStringValueGenerator.class;
}
