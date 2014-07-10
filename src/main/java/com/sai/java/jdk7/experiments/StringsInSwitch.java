package com.sai.java.jdk7.experiments;

/**
 * @Ref:http://docs.oracle.com/javase/7/docs/technotes/guides/language/strings-switch.html
 * @author Sai.Dandem
 *
 */
public class StringsInSwitch {
	public static void main(String[] args) {
		String name = "Arun";
		switch (name) {
		case "Raja":
			System.out.println("I am raja");
			break;
		case "Rani":
			System.out.println("I am Rani");
			break;
		case "arun":
			System.out.println("I am arun");
			break;

		case "Arun":
			System.out.println("I am Arun");
			break;

		default:
			System.out.println("I am default");
			break;
		}
	}
	public static int getDaysInMonth(String month, int year) {
	    if("January".equals(month) ||
	       "March".equals(month)   ||
	       "May".equals(month)     ||
	       "July".equals(month)    ||
	       "August".equals(month)  ||
	       "October".equals(month) ||
	       "December".equals(month))
	        return 31;
	    else if("April".equals(month)    ||
	            "June".equals(month)     ||
	            "September".equals(month)||
	            "November".equals(month))
	        return 30;
	    else if("February".equals(month))
	        return ((year % 4 == 0 && year % 100 != 0) ||
	                 year % 400 == 0) ? 29 : 28;
	    else
	        throw new IllegalArgumentException("Invalid month: " + month);
	}
	
	public static int getDaysInMonth2(String month, int year) {
	    switch(month) {
	        case "January":
	        case "March":
	        case "May":
	        case "July":
	        case "August":
	        case "October":
	        case "December":
	            return 31;
	        case "April":
	        case "June":
	        case "September":
	        case "November":
	            return 30;
	        case "February":
	            return ((year % 4 == 0 && year % 100 != 0) ||
	                     year % 400 == 0) ? 29 : 28;
	        default:
	            throw new IllegalArgumentException("Invalid month: " + month);
	    }
	}


}
