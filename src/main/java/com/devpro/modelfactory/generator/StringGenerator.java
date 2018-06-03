package com.devpro.modelfactory.generator;

public class StringGenerator implements ValueGenerator<String> {

	private String value;

	@Override
	public String generate(Object ctx) {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
