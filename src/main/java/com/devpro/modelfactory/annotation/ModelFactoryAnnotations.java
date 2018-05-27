package com.devpro.modelfactory.annotation;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class ModelFactoryAnnotations {

	private static final Set<Class<? extends Annotation>> annotations = registerDefaultAnnotations();
	
	private static Set<Class<? extends Annotation>> registerDefaultAnnotations() {
		Set<Class<? extends Annotation>> defaultAnnotations = new HashSet<>();
		defaultAnnotations.add(TestIntegerValue.class);
		defaultAnnotations.add(TestLongValue.class);
		defaultAnnotations.add(TestStringValue.class);
		return defaultAnnotations;
	}
	
	public static void registerAnnotation(Class<? extends Annotation> annotationType) {
		annotations.add(annotationType);
	}
	
	public static void registerAnnotations(Set<Class<? extends Annotation>> annotationTypes) {
		annotations.addAll(annotationTypes);
	}
	
	public static void unregisterAnnotation(Class<? extends Annotation> annotationType) {
		annotations.remove(annotationType);
	}
	
	public static void unregisterAnnotations(Set<Class<? extends Annotation>> annotationTypes) {
		annotations.removeAll(annotationTypes);
	}
}
