package com.sai.java.general;

public class ArgumentPassing {
	public static void main(String[] s) {
		
		if(s.length>0){
			for (int i = 0; i < s.length; i++) {
				System.out.println(s[i]);
				//service.incresal(s[i],100)
			}
		}
		System.out.println(s.length);
	}
}
