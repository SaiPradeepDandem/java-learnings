package com.sai.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ReadSplCharatersFile {
	public static void main(String[] args) {
		ReadSplCharatersFile obj = new ReadSplCharatersFile();
		//obj.method1();
		//obj.method2();
		//obj.method3();
		obj.method5();
	}
	
	private void method1(){
		System.out.println("************ METHOD #1 ******************\n");
		try{
			File file = new File(ReadSplCharatersFile.class.getResource("default_contact_letter.mv").toURI());
			FileChannel fc = new FileInputStream(file).getChannel();
			ByteBuffer buf = ByteBuffer.allocateDirect(10);
			StringBuilder appender = new StringBuilder();
			int read;

			while (true) {
				buf.rewind();
				if ((read = fc.read(buf)) != -1) {
					buf.rewind();
					for (; read != 0; read--) {
						appender.append((char) buf.get());
					}
				} else {
					break;
				}
			}
			fc.close();
			System.out.println(appender.toString());
		}catch(Exception e){
			
		}
	}
	private void method2(){
		System.out.println("************ METHOD #2 ******************\n");
		try{
			File file = new File(ReadSplCharatersFile.class.getResource("default_contact_letter.mv").toURI());
			FileInputStream fis = new FileInputStream(file);
			UnicodeReader ur = new UnicodeReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(ur);
			String strLine;
			String s ="";
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  s = s +strLine;
			  }
			  System.out.println(s);
			  //Close the input stream
			  br.close();
		}catch(Exception e){
			
		}
	}
	private void method3(){
		System.out.println("************ METHOD #3 ******************\n");
		try{
			File file = new File(ReadSplCharatersFile.class.getResource("default_contact_letter.mv").toURI());
			
			InputStream in = new FileInputStream(file);
			  byte[] b  = new byte[(int) file.length()];
			  int len = b.length;
			  int total = 0;

			  while (total < len) {
			    int result = in.read(b, total, len - total);
			    if (result == -1) {
			      break;
			    }
			    total += result;
			  }

			  System.out.println( new String( b , Charset.forName("UTF-8") ));
		}catch(Exception e){
			
		}
	}
	private void method4(){
		System.out.println("************ METHOD #4 ******************\n");
		try{
			File file = new File(ReadSplCharatersFile.class.getResource("default_contact_letter.mv").toURI());
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "ISO-8859-1");
			
			int data = reader.read();
			while(data != -1){
			    char theChar = (char) data;
			    System.out.print(theChar);
			    data = reader.read();
			}

			reader.close();  
		}catch(Exception e){
			
		}
	}
	private void method5(){
		try{
			File file = new File(ReadSplCharatersFile.class.getResource("default_contact_letter.mv").toURI());
			System.out.println(readInFile(file));
		}catch(Exception e){
			
		}
	}
	
	public static String readInFile(File file) {
		InputStreamReader reader = null;
		try {
			StringBuilder appender = new StringBuilder();
			reader = new InputStreamReader(new FileInputStream(file), "ISO-8859-1");
			int data = reader.read();
			while (data != -1) {
				appender.append((char) data);
				data = reader.read();
			}
			reader.close();
			return appender.toString();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		return null;
	}
	
	private void method(){
		try{
			File file = new File(ReadSplCharatersFile.class.getResource("default_contact_letter.mv").toURI());
		}catch(Exception e){
			
		}
	}
}


