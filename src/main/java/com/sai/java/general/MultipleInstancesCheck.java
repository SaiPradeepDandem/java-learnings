package com.sai.java.general;

public class MultipleInstancesCheck {

	private Emp str;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultipleInstancesCheck o = new MultipleInstancesCheck();
		Emp a = o.getString();
		System.out.println(a);
		
	}
	private Emp getString() {
		str = new Emp();
		System.out.println(str);
		return str;
	}

	class Emp{
		
	}
}
