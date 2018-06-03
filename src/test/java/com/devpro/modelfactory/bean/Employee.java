package com.devpro.modelfactory.bean;

import com.devpro.modelfactory.annotation.TestInteger;
import com.devpro.modelfactory.annotation.TestString;
import com.devpro.modelfactory.generator.IntegerAutoIncrementGenerator;

import lombok.Data;

@Data
public class Employee {

	@TestInteger(value=1, generatorType=IntegerAutoIncrementGenerator.class)
	private Integer id;
	
	@TestString(value="Chirag")
	private String name;
	
}