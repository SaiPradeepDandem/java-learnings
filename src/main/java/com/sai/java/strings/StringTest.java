package com.sai.java.strings;

public class StringTest {
	public static void main(String[] args) {
		StringTest obj = new StringTest();
		
		obj.testStringEquity();
	}
	private void testStringEquity(){
		String a = "hi";
		String b = "hi";
		System.out.println(a==b);
		
		String c = "Hi";
		System.out.println(a==c);
	}
}