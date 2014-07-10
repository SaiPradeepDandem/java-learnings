package com.sai.java.jdk7.experiments;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * @Ref: http://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html#multiple
 * @author Sai.Dandem
 *
 */
public class MultiCatch {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		beforeJava7();
		try{
			new FileReader("file.txt").read();  // FileNotFoundException
			Integer k = Integer.parseInt("A");  // NumberFormatException
			int i= 4/0;                         // ArithmeticException
			
		}catch(ArithmeticException | NumberFormatException | FileNotFoundException e){
			System.out.println("MY Exception : "+e);
		}

	}
	
	public static void beforeJava7() throws FileNotFoundException, IOException{
		try{
			new FileReader("file.txt").read();  // FileNotFoundException
			Integer k = Integer.parseInt("A");  // NumberFormatException
			int i= 4/0;                         // ArithmeticException
			
		}catch(FileNotFoundException e){
			System.out.println("MY Exception : "+e);
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException : "+e);
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException : "+e);
		}
	}

}
