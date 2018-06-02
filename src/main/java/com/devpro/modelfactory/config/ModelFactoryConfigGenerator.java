package com.devpro.modelfactory.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.devpro.modelfactory.annotation.processor.AnnotationProcessor;
import com.devpro.modelfactory.annotation.processor.AnnotationProcessors;
import com.devpro.modelfactory.exception.ExceptionHandler;
import com.devpro.modelfactory.exception.ExceptionHandlerTemplate;
import com.devpro.modelfactory.exception.ModelInstantiationException;

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
						AnnotationProcessor<?> processor = AnnotationProcessors.getAnnotationProcessor(declaredAnnotaion.annotationType());
						modelFactoryConfig.addValueGenerator(declaredField, processor.process(declaredAnnotaion));
					}
				}
				
				return modelFactoryConfig;
			}
		}, "Error while generating model config for " + modelType.getName());
	}
	
}
