package com.devpro.modelfactory.generator.config;

import com.devpro.modelfactory.generator.simple.BaseGenerator;

public class StringGeneratorConfig extends BaseGeneratorConfig<String> {

	private String defaultValue;

	public StringGeneratorConfig(BaseGenerator<String> valueGenerator, String defaultValue) {
		super(valueGenerator);
		this.defaultValue = defaultValue;
	}

	public String getDefaultValue() {
		return defaultValue;
	}
	
}
