package com.devpro.modelfactory.generator;

public class IntegerGenerator implements ValueGenerator<Integer> {

	private Integer defaultValue;

	public IntegerGenerator(Integer defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	@Override
	public Integer generate(Object ctx) {
		return defaultValue;
	}

}
