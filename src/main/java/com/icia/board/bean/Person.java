package com.icia.board.bean;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.Accessors;
//@Component
@Accessors(chain = true)
@Data
public class Person {
	private String id;
	private String pw;
	private int age;
	
	public String sleep() {
		return "학생은 6시간 잔다";
	}
}
