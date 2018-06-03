package com.devpro.modelfactory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.devpro.modelfactory.bean.Employee;
import com.devpro.modelfactory.bean.Student;
import com.devpro.modelfactory.exception.ModelInstantiationException;

public class ModelFactoryTest {

	@Test
	public void getData() throws ModelInstantiationException {
		Student student = ModelFactory.getData(Student.class);
		Assert.assertEquals(71L, student.getId());
		Assert.assertEquals("Chirag", student.getName());
		Assert.assertEquals(Integer.valueOf(100), student.getMarks());
	}
	
	@Test
	public void getDataList() throws ModelInstantiationException {
		List<Student> students = ModelFactory.getData(Student.class, 3);
		Assert.assertEquals(3, students.size());
		Assert.assertEquals(Long.valueOf(71), students.stream().map(Student::getId).distinct().findFirst().get());
		Assert.assertEquals("Chirag", students.stream().map(Student::getName).distinct().findFirst().get());
		Assert.assertEquals(Integer.valueOf(100), students.stream().map(Student::getMarks).distinct().findFirst().get());
	}
	
	@Test
	public void getAutoIncrementDataList() throws ModelInstantiationException {
		List<Employee> employees = ModelFactory.getData(Employee.class, 3);
		Assert.assertEquals(3, employees.size());
		Assert.assertEquals(Integer.valueOf(1), employees.get(0).getId());
		Assert.assertEquals(Integer.valueOf(2), employees.get(1).getId());
		Assert.assertEquals(Integer.valueOf(3), employees.get(2).getId());
	}
}
