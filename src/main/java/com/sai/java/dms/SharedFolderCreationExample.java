package com.sai.java.dms;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

/**
 * Example to demonstrate about how to create a shared folder in the system.
 * 
 * @author sai.dandem
 *
 */
public class SharedFolderCreationExample {

	public static void main(String[] args) throws ExecuteException, IOException {
		SharedFolderCreationExample obj = new SharedFolderCreationExample();
		File folder = new File("D:\\share1");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		obj.createSharedFolder("localhost", "sai-share2", folder);
	}

	/**
	 * Creates a shared folder if it does not exist in the given network.
	 * 
	 * @param ipaddress
	 *            Network in which to check.
	 * @param shareName
	 *            Name of the shared folder.
	 * @param file
	 *            File to be shared.
	 * @throws HeadlessException
	 * @throws IOException
	 */
	private void createSharedFolder(String ipaddress, String shareName, File file) throws HeadlessException, IOException {
		if (!checkIfShareExistsUsingRuntime(ipaddress, shareName)) {
			boolean flag = createSharedFolderUsingCommonsExec(shareName, file.getAbsolutePath());
			String msg = flag ? " Shared successfully !!" : "Please check your administrator settings and restart your computer";
			if (!flag) {
				javax.swing.JOptionPane.showMessageDialog((java.awt.Component) null, msg, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			System.out.println(msg);
		} else {
			System.out.println(String.format("Shared folder \"%s\" already exists in \\\\%s", shareName, ipaddress));
		}
	}

	/**
	 * Creates a shared folder using "Runtime" class.
	 * 
	 * @param shareName
	 *            Name of the shared folder.
	 * @param filePath
	 *            Path of the file to be shared.
	 */
	protected void createSharedFolderUsingRuntime(String shareName, String filePath) {
		try {
			// Gives the permissions to all the users in the system. To check more on this run the command in cmd : c:\>icacls
			String command1 = String.format("icacls \"%s\" /grant Everyone:(OI)(CI)F", filePath);
			Process process1 = Runtime.getRuntime().exec(command1);
			final BufferedReader is1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
			String line1;
			while ((line1 = is1.readLine()) != null) {
				System.out.println(line1);
			}
			System.out.println("icacls completed !!");

			// Shares the folder in the network. To check more on this run the command in cmd : c:\>net help share
			String command2 = String.format("net share %s=\"%s\" /GRANT:Everyone,FULL", shareName, filePath);
			Process process2 = Runtime.getRuntime().exec(command2);
			final BufferedReader is2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
			String line2;
			while ((line2 = is2.readLine()) != null) {
				System.out.println(line2);
			}
			System.out.println("share completed !!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a shared folder using "apache-commons-exec" library.
	 * 
	 * @param shareName
	 *            Name of the shared folder.
	 * @param filePath
	 *            Path of the file to be shared.
	 * @return {@code true} if the share is successful else returns {@code false}.
	 */
	protected boolean createSharedFolderUsingCommonsExec(String shareName, String filePath) {
		try {
			String line = String.format("net share %s=\"%s\" /GRANT:Everyone,FULL", shareName, filePath);
			CommandLine cmdLine = CommandLine.parse(line);
			DefaultExecutor executor = new DefaultExecutor();
			// executor.setExitValue(2);
			int exitValue = executor.execute(cmdLine);
			System.out.println("Exit value " + exitValue);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	/**
	 * Checks whether the provided shared folder already exists in the given network.(using Runtime class)
	 * 
	 * @param ipaddress
	 *            Network in which to check.
	 * @param shareName
	 *            Name of the shared folder.
	 * @return {@code true} if it already exists else returns {@code false}.
	 * @throws IOException
	 */
	protected boolean checkIfShareExistsUsingRuntime(String ipaddress, String shareName) throws IOException {
		// String command2 = "cmd if exist \\\\" + ipaddress + "\\" + shareName + " echo";
		String l = "net view \\\\" + ipaddress;
		Process process2 = Runtime.getRuntime().exec(l);
		final BufferedReader is2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
		StringBuilder str = new StringBuilder();
		String line2;
		while ((line2 = is2.readLine()) != null) {
			System.out.println(line2);
			str.append(line2.trim()).append(" ");
		}
		System.out.println(str);
		if (str.indexOf(" "+shareName+" ") > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the provided shared folder already exists in the given network.(using "apache-commons-exec" library)
	 * 
	 * @param ipaddress
	 *            Network in which to check.
	 * @param shareName
	 *            Name of the shared folder.
	 * @return {@code true} if it already exists else returns {@code false}.
	 * @throws ExecuteException
	 * @throws IOException
	 */
	protected boolean checkIfShareExists(String ipaddress, String shareName) throws ExecuteException, IOException {
		// String line = "cmd.exe if exist \\\\" + ipaddress + "\\" + shareName + " echo";
		String line2 = "net view \\\\" + ipaddress;
		CommandLine cmdLine = CommandLine.parse(line2);
		DefaultExecutor executor = new DefaultExecutor();
		// executor.setExitValue(2);
		int exitValue = executor.execute(cmdLine);
		System.out.println("Showing " + exitValue);
		return true;
	}
}
