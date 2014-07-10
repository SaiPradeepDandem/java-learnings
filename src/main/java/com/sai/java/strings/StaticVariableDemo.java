package com.sai.java.strings;

public class StaticVariableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SVD_A a = new SVD_A();
		System.out.println("a :  "+a.i);
		
		SVD_A a1 = new SVD_B();
		System.out.println("a1 :  "+a1.i);
		
		SVD_C c = new SVD_C();
		System.out.println("c :  "+c.i);
		
		a.i = 40;
		SVD_B b = new SVD_B();
		System.out.println("b :  "+b.i);
		System.out.println(b.throwMe());

		
	}

}

class SVD_A{
	public static int i =10;
}

class SVD_B extends SVD_A{
	public void showMe(){
		System.out.println(i);
	}
	public boolean throwMe(){
		try{
			i=9;
			System.out.println(i);
			return false;
		}
		finally{
			System.out.println("Hi");
		}
	}
}

class SVD_C extends SVD_A{
	public void showMe(){
		System.out.println(i);
	}
}

