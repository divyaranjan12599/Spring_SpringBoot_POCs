package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Alien {

	private String name;
	private int id;

	@Autowired
	@Qualifier("lap1")
	private Laptop l;

	

	public Laptop getL() {
		return l;
	}

	public void setL(Laptop l) {
		this.l = l;
	}

	public Alien() {
		System.out.println("object created...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void show() {
		System.out.println("shoooowwwwww....");
		l.compile();
	}
}
