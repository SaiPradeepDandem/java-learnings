/**
 * 
 */
package com.sai.java.dms;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;

/**
 * Example to demonstrate the usage of apache-commons-exec library.
 * 
 * @see http://commons.apache.org/proper/commons-exec/tutorial.html
 * @author Sai.Dandem
 *
 */
public class ApacheCommonsExecExample {

	public static void main(String[] args) throws ExecuteException, IOException {
		ApacheCommonsExecExample obj = new ApacheCommonsExecExample();
		obj.generalApproach();
		obj.libraryApproach();
	}

	private void libraryApproach() throws ExecuteException, IOException {
		String line = "net share sai-share=\"D:\\share1\" /GRANT:Everyone,FULL";
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(2);

		ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
		executor.setWatchdog(watchdog);

		int exitValue = executor.execute(cmdLine);
		System.out.println("Exit Value : "+exitValue);
	}

	private void generalApproach() throws ExecuteException, IOException {
		String line = "net share sai-share=\"D:\\share1\" /GRANT:Everyone,FULL";
		Runtime.getRuntime().exec(line);
	}

}
