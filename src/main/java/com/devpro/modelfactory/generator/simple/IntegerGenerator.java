package com.devpro.modelfactory.generator.simple;

import java.util.Objects;

import com.devpro.modelfactory.generator.config.BaseGeneratorConfig;
import com.devpro.modelfactory.generator.config.IntegerGeneratorConfig;

public class IntegerGenerator implements BaseGenerator<Integer> {

	@Override
	public Integer generate(BaseGeneratorConfig<Integer> fieldGeneratorConfig, Object ctx) {
		IntegerGeneratorConfig integerFieldGeneratorConfig =
			fieldGeneratorConfig instanceof IntegerGeneratorConfig ? (IntegerGeneratorConfig) fieldGeneratorConfig : null ;
		
		return Objects.nonNull(integerFieldGeneratorConfig) ? integerFieldGeneratorConfig.getDefaultValue() : null;
	}

}
