package com.sai.java.jdk7.experiments;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Points Observed for PreciseRethrow:
 * 		1. Though we catch Exception, we can precisely throw exception as required, which is not
 *         the case in JDK 1.6. Which shows an error to explicitly asks to add Exception in
 *         "throws" clause.
 * @Ref: http://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html#multiple
 * @author Sai.Dandem
 */
public class PreciseRethrow {
	public static void main(String[] args) throws ParseException, IOException {
		 try {
	        new SimpleDateFormat("yyyyMMdd").parse("foo");
	        new FileReader("file.txt").read();
		 } catch (Exception e) {
	        System.out.println("Caught exception: " + e.getMessage());
	        throw e;
		 }
	}
}
