package com.sai.java.reflection;

public class Patient {
	private int age;
	private String name;
	private double amount;
	
	public Patient(){
		super();
	}

	public Patient(int age, String name, double amount) {
		super();
		this.age = age;
		this.name = name;
		this.amount = amount;
	}
	
	public int getAge(){
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void methodWithNoParamAndNoReturn(){
		System.out.println("Hello");
	}
	public double methodWithNoParamAndReturn(){
		return 10*amount;
	}
	public void methodWithParamAndNoReturn(int num){
		System.out.println(num);
	}
	
	public int methodWithParamAndReturn(int num){
		return num*age;
	}
	
	
}
