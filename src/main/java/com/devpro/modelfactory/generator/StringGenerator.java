package com.devpro.modelfactory.generator;

public class StringGenerator implements ValueGenerator<String> {

	private String defaultValue;

	public StringGenerator(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public String generate(Object ctx) {
		return defaultValue;
	}

}
