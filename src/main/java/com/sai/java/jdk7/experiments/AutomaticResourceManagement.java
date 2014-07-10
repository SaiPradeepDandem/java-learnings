package com.sai.java.jdk7.experiments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Points Observed for Automatic Resource Management:
 *  1. Resource is closed before the catch block is called.
 *  2. Resource which are declared in try(), should implement "AutoCloseable" interface
 *  3. If a try is declared with resource, the catch/finally is not required and no compilation error shows.
 *  4. The close methods of resources are called in the opposite order of their creation
 *  
 * @Ref: http://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html 
 * @author Sai.Dandem
 */
public class AutomaticResourceManagement {

	public static void main(String[] args) {
		// #1: Without any exception
		try(ARM a = new ARM("One")){
			System.out.println("I am in try");
			a.showMe();
		}catch(Exception e){
			System.out.println("I am in exception.");
		}
		System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
		// #2: With exception
		try(ARM a = new ARM("Two")){
			System.out.println("I am in try");
			a.showMe();
			int i = 5/0;
		}catch(Exception e){
			System.out.println("I am in exception.");
		}
		
		multipleResources();
		
	}
	
	private static void multipleResources(){
		System.out.println("\n****************** MULTIPLE RESOURCES ***********************\n");
		try(ARM a1 = new ARM("Three");
			ARM a2 = new ARM("Four")){
			System.out.println("I am in try");
			a1.showMe();
			a2.showMe();
			int i = 5/0;
		}catch(Exception e){
			System.out.println("I am in exception.");
		}
	}
	
	public void readFile() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:/check.txt"));
		try {
		    br.readLine();
		} finally {
		    if (br != null) br.close();
		}
	}
	
	public void readFileWithTryResource() throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("C:/check.txt"))){
			 br.readLine();
		}
	}
	
	public static void copyFile(String src, String dest) throws IOException  {
		try (BufferedReader in = new BufferedReader(new FileReader(src));
			BufferedWriter out = new BufferedWriter(new FileWriter(dest))){
			String line;
			while((line = in.readLine()) != null) {
				out.write(line);
				out.write('\n');
			}
		}
	}
}

class ARM implements AutoCloseable{
	String title;
	
	public ARM(String title){
		this.title = title;
	}
	
	@Override
	public void close() throws Exception {
		System.out.println(title+" is closed.");
	}
	
	public void showMe(){
		System.out.println("I am in show me of "+title);
	}
}

class ARMWithNoClose{
	public void showMe(){
		System.out.println("I am in ARMWithNoClose show me.");
	}
	
	public void close() throws Exception {
		System.out.println("I am ARMWithNoClose closed.");
	}
}
