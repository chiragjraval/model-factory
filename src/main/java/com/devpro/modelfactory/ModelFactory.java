package com.devpro.modelfactory;

import java.lang.reflect.Field;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devpro.modelfactory.config.ModelFactoryConfig;
import com.devpro.modelfactory.config.ModelFactoryConfigGenerator;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.ValueGenerator;

public class ModelFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelFactory.class);
	
	public static <T> T getObject(Class<T> clazz) throws ModelInstantiationException {
		try {
			T obj = clazz.newInstance();
			ModelFactoryConfig modelFactoryConfig = ModelFactoryConfigGenerator.getModelFactoryConfig(clazz);
			
			Map<Field, ValueGenerator<?>> valueGenerators = modelFactoryConfig.getValueGenerators();
			for (Field field : valueGenerators.keySet()) {
				ValueGenerator<?> generator = valueGenerators.get(field);
				field.setAccessible(true);
				field.set(obj, generator.generate(obj));
			}
			
			return obj;
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.error(e.getMessage());
			throw new ModelInstantiationException(e);
		}
	}
	
}
