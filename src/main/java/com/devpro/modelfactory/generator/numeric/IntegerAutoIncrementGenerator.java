package com.devpro.modelfactory.generator.numeric;

public class IntegerAutoIncrementGenerator extends IntegerGenerator {

	@Override
	public Integer generate(Object ctx) {
		return value++;
	}

}
