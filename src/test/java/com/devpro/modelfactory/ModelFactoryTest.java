package com.devpro.modelfactory;

import org.junit.Assert;
import org.junit.Test;

import com.devpro.modelfactory.bean.Student;
import com.devpro.modelfactory.exception.ModelInstantiationException;

public class ModelFactoryTest {

	@Test
	public void getObjectSimple() throws ModelInstantiationException {
		Student student = ModelFactory.getObject(Student.class);
		Assert.assertEquals(71L, student.getId());
		Assert.assertEquals("Chirag", student.getName());
		Assert.assertEquals(Integer.valueOf(10000), student.getSalary());
	}
	
}
