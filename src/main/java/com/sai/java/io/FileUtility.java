/**
 * 
 */
package com.sai.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Sai.Dandem
 * 
 */
public class FileUtility {
	private static final int kFILEBUFSIZE = 128;

	/**
	 * read the supplied file in its entirety into a string
	 * 
	 * @param the
	 *            filename to read characters from
	 * @return a string holding the file contents
	 * @exception IOException
	 *                reports problems that occurred
	 */
	public static String readCharacterFile(String fileName) throws IOException {
		if (fileName == null)
			throw new IllegalArgumentException("supplied filename to FileUtil was null");
		return readCharacterFile(new FileReader(fileName));
	}

	/**
	 * read the supplied file in its entirety into a string
	 * 
	 * @param the
	 *            file object to read characters from
	 * @return a string holding the file contents
	 * @exception IOException
	 *                reports problems that occurred
	 */
	public static String readCharacterFile(File theFile) throws IOException {
		if (theFile == null)
			throw new IllegalArgumentException("supplied File object to FileUtil was null");
		return readCharacterFile(new FileReader(theFile));
	}

	/**
	 * read the supplied reader in its entirety into a string
	 * 
	 * @param the
	 *            Reader object to read characters from
	 * @return a string holding the file contents
	 * @exception IOException
	 *                reports problems that occurred
	 */
	public static String readCharacterFile(Reader theReader) throws IOException {
		if (theReader == null)
			throw new IllegalArgumentException("supplied Reader object to FileUtil was null");

		try {
			StringWriter sw = new StringWriter();
			char[] text = new char[kFILEBUFSIZE];
			int n;
			while ((n = theReader.read(text, 0, kFILEBUFSIZE)) > 0)
				sw.write(text, 0, n);

			return sw.toString();
		} finally {
			if (theReader != null)
				theReader.close();
		}
	}

	/**
	 * write the supplied contents to the named file
	 * 
	 * @param the
	 *            filename to write string contents to
	 * @param the
	 *            file contents to be written
	 * @exception IOException
	 *                reports problems that occurred
	 */
	public static void writeCharacterFile(String fileName, String contents) throws IOException {
		if (fileName == null)
			throw new IllegalArgumentException("supplied filename to FileUtil was null");
		writeCharacterFile(new FileWriter(fileName), contents);
	}

	/**
	 * write the supplied contents to the named file
	 * 
	 * @param the
	 *            File object to write string contents to
	 * @param the
	 *            file contents to be written
	 * @exception IOException
	 *                reports problems that occurred
	 */
	public static void writeCharacterFile(File file, String contents) throws IOException {
		if (file == null)
			throw new IllegalArgumentException("supplied File object to FileUtil was null");
		writeCharacterFile(new FileWriter(file), contents);
	}

	/**
	 * write the supplied contents to the name file
	 * 
	 * @param the
	 *            Writer object to write string contents to
	 * @param the
	 *            file contents to be written
	 * @exception IOException
	 *                reports problems that occurred
	 */
	public static void writeCharacterFile(Writer fileWriter, String contents) throws IOException {
		if (fileWriter == null)
			throw new IllegalArgumentException("supplied FileWriter to FileUtil was null");

		try {
			StringReader sr = new StringReader(contents);
			char[] text = new char[kFILEBUFSIZE];
			int n;
			while ((n = sr.read(text, 0, kFILEBUFSIZE)) > 0)
				fileWriter.write(text, 0, n);
		} finally {
			if (fileWriter != null)
				fileWriter.close();
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println(readCharacterFile("E:\\Projects\\HealthConnect\\emr-workspace\\trunk\\be-healthconnect-emr-server\\src\\main\\resources\\gpsmf_samples\\GPSMF_Correct.xml"));
	}
}
