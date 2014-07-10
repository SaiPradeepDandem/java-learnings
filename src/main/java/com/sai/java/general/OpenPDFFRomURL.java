package com.sai.java.general;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OpenPDFFRomURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL ("http://195.130.154.23/urlnotices/lid/lid.aspx?sLID=9476&sUID=W6PF512EVA");
			URLConnection conn = url.openConnection();
			BufferedInputStream  bis = new BufferedInputStream(conn.getInputStream());
			generatePdfFromInputStream(bis, "Hey");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void generatePdfFromInputStream(InputStream response, String fileName){
		if (response != null) {
			OutputStream os = null;
			try {
				if (response.available() == 0 ? false : true) {
					File file = File.createTempFile( fileName , ".pdf");
					os = new FileOutputStream(file);
					copyLarge(response, os);
					os.flush();
					closeQuietly(response);
					closeQuietly(os);
					Desktop.getDesktop().open(file);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeQuietly(response);
				closeQuietly(os);
			}
		}
	}
	
	public static long copyLarge(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[4096];
		long count = 0L;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	public static void closeQuietly(InputStream input) {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioe) {
		}
	}

	public static void closeQuietly(OutputStream output) {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioe) {
		}
	}
	

}
