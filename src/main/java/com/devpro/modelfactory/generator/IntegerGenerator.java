package com.devpro.modelfactory.generator;

public class IntegerGenerator implements ValueGenerator<Integer> {

	protected Integer value;
	
	@Override
	public Integer generate(Object ctx) {
		return value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
