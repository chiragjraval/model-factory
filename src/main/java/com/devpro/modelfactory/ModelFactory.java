package com.devpro.modelfactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devpro.modelfactory.config.ModelFactoryConfig;
import com.devpro.modelfactory.config.ModelFactoryConfigGenerator;
import com.devpro.modelfactory.exception.ModelInstantiationException;
import com.devpro.modelfactory.generator.config.BaseGeneratorConfig;
import com.devpro.modelfactory.generator.simple.BaseGenerator;

public class ModelFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelFactory.class);
	
	@SuppressWarnings("unchecked")
	public static <T> Optional<T> getObject(Class<T> clazz) throws ModelInstantiationException {
		T obj = null;
		
		try {
			ModelFactoryConfig modelFactoryConfig = ModelFactoryConfigGenerator.getModelFactoryConfig(clazz);
			obj = clazz.newInstance();
			Map<Field, BaseGeneratorConfig<?>> generatorConfigs = modelFactoryConfig.getGeneratorConfigs();
			
			for (Field field : generatorConfigs.keySet()) {
				BaseGeneratorConfig<Object> generatorConfig = (BaseGeneratorConfig<Object>) generatorConfigs.get(field);
				BaseGenerator<Object> generator = generatorConfig.getValueGenerator();
				field.setAccessible(true);
				field.set(obj, generator.generate(generatorConfig, obj));
			}
			
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.error(e.getMessage());
			throw new ModelInstantiationException(e);
		}
		
		return Optional.ofNullable(obj);
	}
	
	
}
