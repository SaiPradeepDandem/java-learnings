package com.sai.java.dms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Example to demonstrate about how to create a shared folder in the system.
 * 
 * @author sai.dandem
 *
 */
public class SharedFolderCreationExample {

	public static void main(String[] args) {
		SharedFolderCreationExample obj = new SharedFolderCreationExample();
		obj.createSharedForWindows();
	}

	private void createSharedForWindows() {
		try {
			// Gives the permissions to all the users in the system. To check more on this run the command in cmd : c:\>icacls
			String command1 = "icacls \"D:\\share1\" /grant Everyone:(OI)(CI)F";
			Process process1 = Runtime.getRuntime().exec(command1);
			final BufferedReader is1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
            String line1;
            while ((line1 = is1.readLine()) != null) {
                System.out.println(line1);
            }
			System.out.println("Shared1 successfully !!");
			
			
			// Shares the folder in the network. To check more on this run the command in cmd : c:\>net help share
			String command2 = "net share sai-share=\"D:\\share2\" /GRANT:Everyone,FULL";
			Process process2 = Runtime.getRuntime().exec(command2);
			final BufferedReader is2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
            String line2;
            while ((line2 = is2.readLine()) != null) {
                System.out.println(line2);
            }
			System.out.println("Shared2 successfully !!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
