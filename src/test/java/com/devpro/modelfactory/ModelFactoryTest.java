package com.devpro.modelfactory;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.devpro.modelfactory.ModelFactory;
import com.devpro.modelfactory.bean.Student;
import com.devpro.modelfactory.exception.ModelInstantiationException;

public class ModelFactoryTest {

	@Test
	public void getObjectSimple() throws ModelInstantiationException {
		Optional<Student> studentOptional = ModelFactory.getObject(Student.class);
		Assert.assertTrue(studentOptional.isPresent());
		Assert.assertEquals(71L, studentOptional.get().getId());
		Assert.assertEquals("Chirag", studentOptional.get().getName());
		Assert.assertEquals(Integer.valueOf(10000), studentOptional.get().getSalary());
	}
	
}
