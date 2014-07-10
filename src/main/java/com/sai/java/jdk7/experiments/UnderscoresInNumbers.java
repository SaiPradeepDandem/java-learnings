package com.sai.java.jdk7.experiments;

/**
 * @Ref: http://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html
 *       http://docs.oracle.com/javase/7/docs/technotes/guides/language/binary-literals.html
 * @author Sai.Dandem
 *
 */
public class UnderscoresInNumbers {

	public static void main(String[] args) {
		 int i = 2_00_000;
		 System.out.println(i);
		 
		//in jdk7, you can create a binary literal like this:
		 int seven = 0b111;
		 int eight = 0b1000;
		 
		 //easier to read bitwise operations
		 int four = 0b1000>>1;
		 int sixteen = 0b1000<<1;
		 
		 System.out.println(seven);
		 System.out.println(four);
		 System.out.println(eight);
		 System.out.println(sixteen);
		 declare();
	}

	private static void declare(){
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		float pi = 	3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;

		final int[] phases = {
		    0x31, 0x62, 0xC4, 0x89, 0x13, 0x26, 0x4C, 0x98
		};
		
		for (int i : phases) {
			System.out.println(i);
		}
	}
}
