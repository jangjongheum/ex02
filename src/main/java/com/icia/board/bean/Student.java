package com.icia.board.bean;

import org.springframework.stereotype.Component;

import lombok.Data;
//@Component//���� Ŭ������ Ioc �����̳ʿ� �÷����ڴ�.(��ä ����)
@Data
public class Student extends Person{

	private String name;
	private int sNo;
	
	public void study() {
		System.out.println("�л��� �����Ѵ�");
	}
	public String sleep() {
		return "�л��� 6�ð� �ܴ�";
	}
}
