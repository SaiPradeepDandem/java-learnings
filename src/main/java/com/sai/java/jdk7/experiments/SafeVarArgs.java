package com.sai.java.jdk7.experiments;

/**
 * @Ref: http://docs.oracle.com/javase/7/docs/technotes/guides/language/non-reifiable-varargs.html
 * @author Sai.Dandem
 *
 */
public class SafeVarArgs {

	@SafeVarargs
	public static <T> void print(T... a) {
	  for (T t : a) {
	      System.out.println(t);
	  }
	}
	
	public static void main(String[] args){
		 
		  print("Hello", "World"); //this is fine
		 // print(new Pair<Integer,String>(1,"One"), new Pair<Integer,String>(2,"Two"));
		  //WARNING: Type safety : A generic array of Pair<Integer,String>
		  //is created for a varargs parameter
		}
}
