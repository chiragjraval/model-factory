package com.devpro.modelfactory.bean;

import com.devpro.modelfactory.annotation.TestIntegerValue;
import com.devpro.modelfactory.annotation.TestLongValue;
import com.devpro.modelfactory.annotation.TestStringValue;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
public class Student {

	@TestLongValue(defaultValue=71L)
	private long id;
	
	@TestStringValue(defaultValue="Chirag")
	private String name;
	
	@TestIntegerValue(defaultValue=10000)
	private Integer salary;
	
}
