package com.devpro.modelfactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.devpro.modelfactory.generator.simple.SimpleLongValueGenerator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TestLongValue {
	long defaultValue() default 1L;
	Class<SimpleLongValueGenerator> valueGenerator() default SimpleLongValueGenerator.class;
}
