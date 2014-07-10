package com.sai.java.general;

class StaticDemo1 {
	public StaticDemo1(){
		System.out.println("In constructor");
	}
	static{
		System.out.println("In static");
	}
}

public class StaticDemo{
	public static void main(String[] args) {
		StaticDemo1 obj = new StaticDemo1();
		String a = "ja+ge";
		for(String x : a.split("\\+")){
			System.out.println(x);
		}
	}
}