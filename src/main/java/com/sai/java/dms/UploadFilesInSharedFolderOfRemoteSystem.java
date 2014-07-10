package com.sai.java.dms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

/**
 * Example to upload the provided file in the remote system shared folder.(using credentials)
 * 
 * @see http://ujjwalbsoni.blogspot.in/2013/08/copying-files-over-network-shared.html
 * 
 */
public class UploadFilesInSharedFolderOfRemoteSystem {

	public static void main(String[] args) throws IOException {
		final String userName = "sai.dandem";
		final String password = "redrose";
		final String domain = "EZEST";
		final String sourcePath = "D:\\share1\\test.txt";
		final String destinationPath = "smb://192.168.101.55/sai-share/test.txt";

		copyFileUsingJcifs(domain, userName, password, sourcePath, destinationPath);

		System.out.println("The file has been copied using JCIFS");
	}

	public static void copyFileUsingJcifs(final String domain, final String userName, final String password, final String sourcePath,
			final String destinationPath) throws IOException {

		final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(domain, userName, password);
		final SmbFile sFile = new SmbFile(destinationPath, auth);
		final SmbFileOutputStream smbFileOutputStream = new SmbFileOutputStream(sFile);
		final FileInputStream fileInputStream = new FileInputStream(new File(sourcePath));

		final byte[] buf = new byte[16 * 1024 * 1024];
		int len;
		while ((len = fileInputStream.read(buf)) > 0) {
			smbFileOutputStream.write(buf, 0, len);
		}
		fileInputStream.close();
		smbFileOutputStream.close();
	}

}
