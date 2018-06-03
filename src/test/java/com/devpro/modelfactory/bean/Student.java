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

	@TestLong(value=71L)
	private long id;
	
	@TestString(value="Chirag")
	private String name;
	
	@TestInteger(value=100)
	private Integer marks;
	
}
