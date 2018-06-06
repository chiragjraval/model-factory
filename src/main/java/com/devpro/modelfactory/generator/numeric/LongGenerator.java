package com.devpro.modelfactory.generator.numeric;

import com.devpro.modelfactory.generator.ValueGenerator;

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
