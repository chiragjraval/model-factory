package com.devpro.modelfactory.generator.config;

import com.devpro.modelfactory.generator.simple.BaseGenerator;

public abstract class BaseGeneratorConfig<T> {

	protected BaseGenerator<T> valueGenerator;

	public BaseGeneratorConfig(BaseGenerator<T> valueGenerator) {
		super();
		this.valueGenerator = valueGenerator;
	}

	public BaseGenerator<T> getValueGenerator() {
		return valueGenerator;
	}
	
}
