package com.devpro.modelfactory.generator;

public class LongGenerator implements ValueGenerator<Long> {
	
	protected Long value;

	@Override
	public Long generate(Object ctx) {
		return value;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
