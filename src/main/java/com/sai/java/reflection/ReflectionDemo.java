package com.sai.java.reflection;

import java.lang.reflect.Method;

public class ReflectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReflectionDemo obj = new ReflectionDemo();
		try {
			obj.createNewClassInstance();
			obj.methodWithNoParamAndNoReturn();
			obj.methodWithNoParamAndReturn();
			obj.methodWithParamAndNoReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createNewClassInstance() throws Exception{
		Class klass = Class.forName("com.sai.java.reflection.Patient");
		Patient patient = (Patient) klass.newInstance();
	}

	private void methodWithNoParamAndNoReturn() throws Exception {
		Class klass = Class.forName("com.sai.java.reflection.Patient");
		final Patient patient = (Patient) klass.newInstance();
		Method m = klass.getDeclaredMethod("methodWithNoParamAndNoReturn", null);
		m.invoke(patient);
	}
	
	private void methodWithNoParamAndReturn() throws Exception {
		Class klass = Class.forName("com.sai.java.reflection.Patient");
		final Patient patient = (Patient) klass.newInstance();
		patient.setAmount(45);
		Method m = klass.getDeclaredMethod("methodWithNoParamAndReturn", null);
		Object o = m.invoke(patient);
		System.out.println(o);
	}
	
	private void methodWithParamAndNoReturn() throws Exception {
		Class klass = Class.forName("com.sai.java.reflection.Patient");
		final Patient patient = (Patient) klass.newInstance();
		Method m = klass.getDeclaredMethod("setAge", Integer.TYPE);
		m.invoke(patient,23);
		System.out.println(patient.getAge());
	}
	
	
}
