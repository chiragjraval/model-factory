package com.devpro.modelfactory.generator.config;

import com.devpro.modelfactory.generator.simple.BaseGenerator;

public class IntegerGeneratorConfig extends BaseGeneratorConfig<Integer> {

	private Integer defaultValue;

	public IntegerGeneratorConfig(BaseGenerator<Integer> valueGenerator, Integer defaultValue) {
		super(valueGenerator);
		this.defaultValue = defaultValue;
	}

	public Integer getDefaultValue() {
		return defaultValue;
	}
	
}
