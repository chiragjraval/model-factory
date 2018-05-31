package com.devpro.modelfactory.generator.simple;

import java.util.Objects;

import com.devpro.modelfactory.generator.config.BaseGeneratorConfig;
import com.devpro.modelfactory.generator.config.StringGeneratorConfig;

public class StringGenerator implements BaseGenerator<String> {

	@Override
	public String generate(BaseGeneratorConfig<String> fieldGeneratorConfig, Object ctx) {
		StringGeneratorConfig stringFieldGeneratorConfig =
				fieldGeneratorConfig instanceof StringGeneratorConfig ? (StringGeneratorConfig) fieldGeneratorConfig : null ;
		
		return Objects.nonNull(stringFieldGeneratorConfig) ? stringFieldGeneratorConfig.getDefaultValue() : null;
	}

}
