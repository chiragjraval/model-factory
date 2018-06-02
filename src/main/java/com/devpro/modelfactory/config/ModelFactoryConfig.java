package com.devpro.modelfactory.config;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.devpro.modelfactory.generator.ValueGenerator;

public class ModelFactoryConfig {

	private Class<?> modelType;
	private Map<Field, ValueGenerator<?>> valueGenerators;
		
	public ModelFactoryConfig(Class<?> modelType) {
		super();
		this.modelType = modelType;
		this.valueGenerators = new HashMap<>();
	}

	public ModelFactoryConfig(Class<?> modelType, Map<Field, ValueGenerator<?>> valueGenerators) {
		super();
		this.modelType = modelType;
		this.valueGenerators = valueGenerators;
	}
	
	public Class<?> getModelType() {
		return this.modelType;
	}

	public Map<Field, ValueGenerator<?>> getValueGenerators() {
		return Collections.unmodifiableMap(this.valueGenerators);
	}
	
	public void addValueGenerator(Field field, ValueGenerator<?> valueGenerator) {
		this.valueGenerators.put(field, valueGenerator);
	}
	
	public void removeValueGenerator(Field field) {
		this.valueGenerators.remove(field);
	}
}
