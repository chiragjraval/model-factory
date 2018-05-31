package com.devpro.modelfactory.generator.simple;

import java.util.Objects;

import com.devpro.modelfactory.generator.config.BaseGeneratorConfig;
import com.devpro.modelfactory.generator.config.LongGeneratorConfig;

public class LongGenerator implements BaseGenerator<Long> {
	
	@Override
	public Long generate(BaseGeneratorConfig<Long> fieldGeneratorConfig, Object ctx) {
		LongGeneratorConfig longFieldGeneratorConfig =
			fieldGeneratorConfig instanceof LongGeneratorConfig ? (LongGeneratorConfig) fieldGeneratorConfig : null ;
		
		return Objects.nonNull(longFieldGeneratorConfig) ? longFieldGeneratorConfig.getDefaultValue() : null;
	}

}
