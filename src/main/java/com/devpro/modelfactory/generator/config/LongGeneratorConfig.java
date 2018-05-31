package com.devpro.modelfactory.generator.config;

import com.devpro.modelfactory.generator.simple.BaseGenerator;

public class LongGeneratorConfig extends BaseGeneratorConfig<Long> {

	private Long defaultValue;

	public LongGeneratorConfig(BaseGenerator<Long> valueGenerator, Long defaultValue) {
		super(valueGenerator);
		this.defaultValue = defaultValue;
	}

	public Long getDefaultValue() {
		return defaultValue;
	}
	
}
