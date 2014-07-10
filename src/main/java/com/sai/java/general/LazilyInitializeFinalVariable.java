package com.sai.java.general;

import java.util.concurrent.Callable;

class Memo<T> {
	private T result;
	private final Callable<T> callable;
	private boolean established;
	 
	public Memo(final Callable<T> callable) {
		this.callable = callable;
	}
 
	public T get() {
		if (!established) {
			try {
				result = callable.call();
				established = true;
			}
			catch (Exception e) {
				throw new RuntimeException("Failed to get value of memo", e);
			}
		}
		return result;
	}
}

class Employee{
	private String name;

	public Employee(){
		System.out.println("Employee is called......");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class ShowMe {
	  private final Memo<Employee> conn;
	 
	  public ShowMe() {
	    conn = new Memo<Employee>(new Callable<Employee>() {
	      public Employee call() throws Exception {
	        return new Employee();
	      }
	    });
	  }
	 
	  public Employee getConnection() {
	    return conn.get();
	  }
}
public class LazilyInitializeFinalVariable{
	public static void main(String[] args) {
		ShowMe obj = new ShowMe();
		System.out.println("Show me is created..");
		obj.getConnection();
	}
}

