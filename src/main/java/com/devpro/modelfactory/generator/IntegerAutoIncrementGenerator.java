package com.devpro.modelfactory.generator;

public class IntegerAutoIncrementGenerator extends IntegerGenerator {

	@Override
	public Integer generate(Object ctx) {
		return value++;
	}

}
