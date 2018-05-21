package com.chirag.model.factory;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chirag.model.factory.exception.ModelInstantiationException;

public class ModelFactoryUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelFactoryUtil.class);
	
	public static <T> Optional<T> getObject(Class<T> clazz) throws ModelInstantiationException {
		T obj = null;
		
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.error(e.getMessage());
			throw new ModelInstantiationException(e);
		}
		
		return Optional.ofNullable(obj);
	}
	
}
