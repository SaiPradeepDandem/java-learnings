package com.sai.java.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericMethodsAndConstructors {
	 public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.add(new Integer(10));
        integerBox.inspect("some text"); //This feature, known as "type inference", allows you to invoke a generic method 
        								//as you would an ordinary method, without specifying a type between angle brackets.
        integerBox.<String>inspect("another text");
        
        Box<String> box2 = new Box(new Integer(5));
        Box<String> box = new Box("Fre");
        
        //Map<String, List<String>> myMap = new HashMap<>();
       // List<? extends String> list2 = new ArrayList<>();
        
	 }
}

class Box<T> {

	// Generic constructor
	<S> Box(S s){
		if(s instanceof Integer){
			System.out.println("I am box with "+s.getClass().getName());
		}else{
			System.out.println("I am not");
		}
	}
	
	// Normal Constructor
	Box(){
		
	}
	
    private T t;          

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    // Generic constructor
    public <U> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
     
 }