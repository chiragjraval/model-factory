package com.devpro.modelfactory.generator.simple;

import com.devpro.modelfactory.generator.config.BaseGeneratorConfig;

public interface BaseGenerator<T> {

	public abstract T generate(BaseGeneratorConfig<T> generatorConfig, Object ctx);
	
}
