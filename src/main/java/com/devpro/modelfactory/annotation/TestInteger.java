package com.devpro.modelfactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.devpro.modelfactory.generator.IntegerGenerator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TestInteger {
	int defaultValue() default 1;
	Class<IntegerGenerator> valueGenerator() default IntegerGenerator.class;
}