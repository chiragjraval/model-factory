package com.devpro.modelfactory.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.devpro.modelfactory.annotation.TestIntegerValue;
import com.devpro.modelfactory.annotation.TestLongValue;
import com.devpro.modelfactory.annotation.TestStringValue;
import com.devpro.modelfactory.exception.ExceptionHandler;
import com.devpro.modelfactory.exception.ExceptionHandlerTemplate;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.config.IntegerGeneratorConfig;
import com.devpro.modelfactory.generator.config.LongGeneratorConfig;
import com.devpro.modelfactory.generator.config.StringGeneratorConfig;
import com.devpro.modelfactory.generator.simple.BaseGenerator;

public class ModelFactoryConfigGenerator {

	public static ModelFactoryConfig getModelFactoryConfig(final Class<?> modelType) throws ModelInstantiationException {
		return ExceptionHandlerTemplate.runAndThrowModelInstantiationException(new ExceptionHandler<ModelFactoryConfig>() {
			@Override
			public ModelFactoryConfig get() throws Exception {
				ModelFactoryConfig modelFactoryConfig = new ModelFactoryConfig(modelType);
				
				Field[] declaredFields = modelType.getDeclaredFields();
				for (Field declaredField : declaredFields) {
					Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();			
					for (Annotation declaredAnnotaion : declaredAnnotations) {
						if(TestStringValue.class.equals(declaredAnnotaion.annotationType())) {
							TestStringValue testDataAnnotation = (TestStringValue) declaredAnnotaion;
							modelFactoryConfig.addGeneratorConfig(declaredField, getGeneratorConfig(testDataAnnotation));
						}
						else if(TestIntegerValue.class.equals(declaredAnnotaion.annotationType())) {
							TestIntegerValue testDataAnnotation = (TestIntegerValue) declaredAnnotaion;
							modelFactoryConfig.addGeneratorConfig(declaredField, getGeneratorConfig(testDataAnnotation));
						}
						else if(TestLongValue.class.equals(declaredAnnotaion.annotationType())) {
							TestLongValue testDataAnnotation = (TestLongValue) declaredAnnotaion;
							modelFactoryConfig.addGeneratorConfig(declaredField, getGeneratorConfig(testDataAnnotation));
						}
					}
				}
				
				return modelFactoryConfig;
			}
		}, "Error while generating model config for " + modelType.getName());
	}

	private static StringGeneratorConfig getGeneratorConfig(TestStringValue declaredAnnotaion) throws InstantiationException, IllegalAccessException {
		String defaultValue = declaredAnnotaion.defaultValue();
		BaseGenerator<String> generator = declaredAnnotaion.valueGenerator().newInstance();
		return new StringGeneratorConfig(generator, defaultValue);
	}
	
	private static IntegerGeneratorConfig getGeneratorConfig(TestIntegerValue declaredAnnotaion) throws InstantiationException, IllegalAccessException {
		Integer defaultValue = declaredAnnotaion.defaultValue();
		BaseGenerator<Integer> generator = declaredAnnotaion.valueGenerator().newInstance();
		return new IntegerGeneratorConfig(generator, defaultValue);
	}
	
	private static LongGeneratorConfig getGeneratorConfig(TestLongValue declaredAnnotaion) throws InstantiationException, IllegalAccessException {
		Long defaultValue = declaredAnnotaion.defaultValue();
		BaseGenerator<Long> generator = declaredAnnotaion.valueGenerator().newInstance();
		return new LongGeneratorConfig(generator, defaultValue);
	}
	
}
