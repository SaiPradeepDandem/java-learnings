package com.sai.java.generics;

class A1{ }
class A2{ }
class A3{ }

class B extends A1{
	
}
class C extends A2{
	
}
class D extends A3{
	
}

class MyClass<T extends A1> extends A2{
	public MyClass(){
		
	}
}
public class MultipleGenericExtending {
	public static void main(String[] args) {
		B b = new B();
		D d = new D();
		MyClass<B> obj = new MyClass<B>();
	}
}
