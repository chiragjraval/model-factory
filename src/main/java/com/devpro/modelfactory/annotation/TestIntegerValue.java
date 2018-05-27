package com.devpro.modelfactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.devpro.modelfactory.generator.simple.SimpleIntegerValueGenerator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TestIntegerValue {
	int defaultValue() default 1;
	Class<SimpleIntegerValueGenerator> valueGenerator() default SimpleIntegerValueGenerator.class;
}
