package com.sai.java.general;

import java.util.ArrayList;
import java.util.List;

class Obj1{
	protected String name;
	public Obj1(String name) {
		this.name =name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name+" from Obj1";
	}
}

class Obj2 extends Obj1{
	public Obj2(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return  this.name+" from Obj2";
	}
}

public class ListDemo {
	public static void main(String[] args) {
		List<Obj1> firstList = new ArrayList<Obj1>();
		firstList.add(new Obj1("Apple"));
		firstList.add(new Obj1("Bat"));
		firstList.add(new Obj1("Cat"));
		
		
	}
}
