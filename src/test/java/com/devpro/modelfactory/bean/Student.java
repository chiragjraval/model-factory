package com.devpro.modelfactory.bean;

import com.devpro.modelfactory.annotation.TestInteger;
import com.devpro.modelfactory.annotation.TestLong;
import com.devpro.modelfactory.annotation.TestString;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
public class Student {

	@TestLong(defaultValue=71L)
	private long id;
	
	@TestString(defaultValue="Chirag")
	private String name;
	
	@TestInteger(defaultValue=10000)
	private Integer salary;
	
}
