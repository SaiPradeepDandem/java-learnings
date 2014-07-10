package com.sai.java.strings;

import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * Simple class testing the rough differences in performance of String, 
 * StringBuffer, and StringBuilder in repeated (looping) String concatenations. 
 * 
 * @see java.lang.String 
 * @see java.lang.StringBuffer 
 * @see java.lang.StringBuilder 
 */  
public class StringPerformanceTester  
{  
   final private String CONSTANT_STRING;  
  
   /** 
    * Constructor accepting the String to be used for appending or concatenating 
    * to the main String.  The ability to specify this String provides additional 
    * flexibility in the performance testing. 
    */  
   public StringPerformanceTester(final String stringToBeUsed)  
   {  
      CONSTANT_STRING = stringToBeUsed;  
   }  
  
   /** 
    * Concatenate Strings repeatedly the specified number of times. 
    * 
    * @param numberOfStrings Number of times to concatenate Strings. 
    * @return Time in milliseconds required to concatenate Strings. 
    */  
   public long concatenateStrings(final int numberOfStrings)  
   {  
      String masterString = "";  
      final long startTime = System.currentTimeMillis();  
      for ( int i=0; i < numberOfStrings; ++i )  
      {  
         masterString += CONSTANT_STRING;  
      }  
      final long endTime = System.currentTimeMillis();  
      return endTime - startTime;  
   }  
  
   /** 
    * Concatenate Strings repeatedly the specified number of times using 
    * StringBuffer. 
    * 
    * @param numberOfStrings Number of times to append Strings. 
    * @return Time in milliseconds required to append Strings. 
    */  
   public long useStringBuffer(final int numberOfStrings)  
   {  
      final StringBuffer masterString =  
         new StringBuffer(CONSTANT_STRING.length()*numberOfStrings);  
      final long startTime = System.currentTimeMillis();  
      for ( int i=0; i < numberOfStrings; ++i )  
      {  
         masterString.append(CONSTANT_STRING);  
      }  
      final long endTime = System.currentTimeMillis();  
      return endTime - startTime;  
   }  
  
   /** 
    * Concatenate Strings repeatedly the specified number of times using 
    * StringBuilder. 
    * 
    * @param numberOfStrings Number of times to append Strings. 
    * @return Time in milliseconds required to append Strings. 
    */  
   public long useStringBuilder(final int numberOfStrings)  
   {  
      final StringBuilder masterString =  
         new StringBuilder(CONSTANT_STRING.length()*numberOfStrings);  
      final long startTime = System.currentTimeMillis();  
      for ( int i=0; i < numberOfStrings; ++i )  
      {  
         masterString.append(CONSTANT_STRING);  
      }  
      final long endTime = System.currentTimeMillis();  
      return endTime - startTime;  
   }  
  
   /** 
    * Main method for executing timing tests of different methods of String 
    * concatenation. 
    * 
    * @param numberOfStringsForTest Number of strings to be concatenated or appended. 
    * @return Results of running all three types of tests against provided 
    *   number of Strings. 
    */  
   public TestResults runTimingTests(final int numberOfStringsForTest)  
   {  
      final TestResults testResults =  
         this.new TestResults(numberOfStringsForTest);  
      testResults.millisecondsString = concatenateStrings(numberOfStringsForTest);  
      testResults.millisecondsBuffer = useStringBuffer(numberOfStringsForTest);  
      testResults.millisecondsBuilder = useStringBuilder(numberOfStringsForTest);  
      return testResults;  
   }  
  
   /** 
    * Main executable for testing String performance. 
    */  
   public static void main(final String[] arguments)  
   {  
      final StringPerformanceTester me = new StringPerformanceTester("constant");  
      final List<TestResults> testResults = new ArrayList<TestResults>();  
  
      testResults.add( me.runTimingTests(1000) );  
      testResults.add( me.runTimingTests(10000) );  
      testResults.add( me.runTimingTests(100000) );  
      System.out.println(testResults);  
   }  
  
   /** 
    * Class for easy storage and output of test results. 
    */  
   private class TestResults  
   {  
      private int numberOfStrings;  
      private long millisecondsString;  
      private long millisecondsBuffer;  
      private long millisecondsBuilder;  
  
      /** 
       * Constructor accepting the number of String concatenations or appends. 
       * 
       * @param numberOfStrings Number of String concatenations or appends. 
       */  
      public TestResults(final int numberOfStrings)  
      {  
         this.numberOfStrings = numberOfStrings;  
      }  
  
      /** 
       * Provide String representation of me. 
       * 
       * @return String representation of me. 
       */  
      @Override  
      public String toString()  
      {  
         final StringBuffer sb = new StringBuffer();  
         sb.append("#: " + numberOfStrings);  
         sb.append("\tSTRING: " + millisecondsString);  
         sb.append("\tBUFFER: " + millisecondsBuffer);  
         sb.append("\tBUILDER: " + millisecondsBuilder + "\n");  
         return sb.toString();  
      }  
   }  
}  
