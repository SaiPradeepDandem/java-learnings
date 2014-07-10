package com.sai.java.general;
class A {
	public void add(){
		System.out.println("Add in A");
	}
}
class B extends A{
	public void add(){
		System.out.println("Add in B");
	}
}
class C  extends B{
	public void add(){
		System.out.println("Add in C");
	}
	
}
public class SuperSuperAccess {
	public static void main(String[] args) {
		C c = new C();
		
	}
	
	public void show(C c){
		//B b = (C.class.getSuperclass())c;
	}
}
