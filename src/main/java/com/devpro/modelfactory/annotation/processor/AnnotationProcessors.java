package com.devpro.modelfactory.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.devpro.modelfactory.annotation.TestInteger;
import com.devpro.modelfactory.annotation.TestLong;
import com.devpro.modelfactory.annotation.TestString;

public class AnnotationProcessors {

	private static final Map<Class<? extends Annotation>, AnnotationProcessor<?>> annotationProcessors = init();

	private static Map<Class<? extends Annotation>, AnnotationProcessor<?>> init() {
		Map<Class<? extends Annotation>, AnnotationProcessor<?>> defaultAnnotationProcessors
			= new HashMap<Class<? extends Annotation>, AnnotationProcessor<?>>();
		
		defaultAnnotationProcessors.put(TestInteger.class, new TestIntegerProcessor());
		defaultAnnotationProcessors.put(TestString.class, new TestStringProcessor());
		defaultAnnotationProcessors.put(TestLong.class, new TestLongProcessor());
		
		return defaultAnnotationProcessors;
	}
	
	public static void registerAnnotationProcessor(Class<? extends Annotation> annotation,
			AnnotationProcessor<?> processor) {
		annotationProcessors.put(annotation, processor);
	}
	
	public static void registerAnnotationProcessors(Map<Class<? extends Annotation>, AnnotationProcessor<?>> processors) {
		annotationProcessors.putAll(processors);
	}
	
	public static void unregisterAnnotationProcessor(Class<? extends Annotation> annotation) {
		annotationProcessors.remove(annotation);
	}
	
	public static void unregisterAnnotationProcessors(Set<Class<? extends Annotation>> annotations) {
		for (Class<? extends Annotation> annotation : annotations) {
			annotationProcessors.remove(annotation);
		}
	}
	
	public static AnnotationProcessor<?> getAnnotationProcessor(Class<? extends Annotation> annotation) {
		return annotationProcessors.get(annotation);
	}
}
