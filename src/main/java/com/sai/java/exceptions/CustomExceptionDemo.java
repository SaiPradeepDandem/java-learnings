package com.sai.java.exceptions;

class MyException extends Exception {

	int a;

	MyException(int b) {

		a = b;

	}

	public String toString() {

		return ("Exception Number =  " + a+" : Cause : "+getCause());

	}

}

public class CustomExceptionDemo {

	public static void main(String args[]) {
		CustomExceptionDemo obj = new CustomExceptionDemo();
		
		try {
			obj.showMe();
			//throw new MyException(2);

			// throw is used to create a new exception and throw it.

		}

		catch (MyException e) {

			System.out.println(e);
		
		}

	}
	
	public void showMe() throws MyException{
		int i =3;
		i = i/0;
	}
}
