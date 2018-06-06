package com.devpro.modelfactory.generator.numeric;

import com.devpro.modelfactory.generator.ValueGenerator;

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
