package com.devpro.modelfactory.generator;

public class LongGenerator implements ValueGenerator<Long> {
	
	private Long defaultValue;

	public LongGenerator(Long defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public Long generate(Object ctx) {
		return defaultValue;
	}

}
