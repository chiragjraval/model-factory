package com.devpro.modelfactory.config;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.devpro.modelfactory.generator.config.BaseGeneratorConfig;

public class ModelFactoryConfig {

	private Class<?> modelType;
	private Map<Field, BaseGeneratorConfig<?>> generatorConfigs;
		
	public ModelFactoryConfig(Class<?> modelType) {
		super();
		this.modelType = modelType;
		this.generatorConfigs = new HashMap<>();
	}

	public ModelFactoryConfig(Class<?> modelType, Map<Field, BaseGeneratorConfig<?>> generatorConfigs) {
		super();
		this.modelType = modelType;
		this.generatorConfigs = generatorConfigs;
	}
	
	public Class<?> getModelType() {
		return this.modelType;
	}

	public Map<Field, BaseGeneratorConfig<?>> getGeneratorConfigs() {
		return Collections.unmodifiableMap(this.generatorConfigs);
	}
	
	public void addGeneratorConfig(Field field, BaseGeneratorConfig<?> generatorConfig) {
		this.generatorConfigs.put(field, generatorConfig);
	}
	
	public void removeGeneratorConfig(Field field) {
		this.generatorConfigs.remove(field);
	}
}
