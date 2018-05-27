package com.devpro.modelfactory.generator;

import java.util.HashSet;
import java.util.Set;

import com.devpro.modelfactory.generator.simple.SimpleStringValueGenerator;

public class ModelFactoryGenerators {

	private static final Set<Class<? extends ValueGenerator<?>>> generators = registerDefaultGenerators();
	
	private static Set<Class<? extends ValueGenerator<?>>> registerDefaultGenerators() {
		Set<Class<? extends ValueGenerator<?>>> defaultGenerators = new HashSet<>();
		defaultGenerators.add(SimpleStringValueGenerator.class);
		return defaultGenerators;
	}
	
	public static void registerGenerator(Class<? extends ValueGenerator<?>> generator) {
		generators.add(generator);
	}
	
	public static void registerGenerators(Set<Class<? extends ValueGenerator<?>>> generatorSet) {
		generators.addAll(generatorSet);
	}
	
	public static void unregisterGenerator(Class<? extends ValueGenerator<?>> generator) {
		generators.add(generator);
	}
	
	public static void unregisterGenerators(Set<Class<? extends ValueGenerator<?>>> generatorSet) {
		generators.removeAll(generatorSet);
	}
	
	public static ValueGenerator<?> getGenerator(Class<? extends ValueGenerator<?>> generatorClazz)
			throws InstantiationException, IllegalAccessException {
		return generatorClazz.newInstance();
	}
}
