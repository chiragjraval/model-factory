package com.devpro.modelfactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devpro.modelfactory.annotation.TestIntegerValue;
import com.devpro.modelfactory.annotation.TestLongValue;
import com.devpro.modelfactory.annotation.TestStringValue;
import com.devpro.modelfactory.exception.ModelInstantiationException;

public class ModelFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelFactory.class);
	
	public static <T> Optional<T> getObject(Class<T> clazz) throws ModelInstantiationException {
		T obj = null;
		
		try {
			obj = clazz.newInstance();
			populatedAllTestFieldsViaGenerators(obj, TestStringValue.class);
			populatedAllTestFieldsViaGenerators(obj, TestIntegerValue.class);
			populatedAllTestFieldsViaGenerators(obj, TestLongValue.class);
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.error(e.getMessage());
			throw new ModelInstantiationException(e);
		}
		
		return Optional.ofNullable(obj);
	}
	
	private static <T,E extends Annotation> void populatedAllTestFieldsViaGenerators(Object obj, Class<E> annotationClazz)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		
		for (Field declaredField : declaredFields) {
			E annotation = declaredField.getDeclaredAnnotation(annotationClazz);
			Object value = null;
			if(Objects.nonNull(annotation) && TestStringValue.class.equals(annotation.annotationType())) {
				TestStringValue testDataAnnotation = (TestStringValue) annotation;
				value = testDataAnnotation.valueGenerator().newInstance().generate(testDataAnnotation, obj);
			}
			else if(Objects.nonNull(annotation) && TestIntegerValue.class.equals(annotation.annotationType())) {
				TestIntegerValue testDataAnnotation = (TestIntegerValue) annotation;
				value = testDataAnnotation.valueGenerator().newInstance().generate(testDataAnnotation, obj);
			}
			else if(Objects.nonNull(annotation) && TestLongValue.class.equals(annotation.annotationType())) {
				TestLongValue testDataAnnotation = (TestLongValue) annotation;
				value = testDataAnnotation.valueGenerator().newInstance().generate(testDataAnnotation, obj);
			}
			
			if(Objects.nonNull(value)) {
				declaredField.setAccessible(true);
				declaredField.set(obj, value);
			}
		}
	}
}
