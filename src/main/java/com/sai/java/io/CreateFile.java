package com.sai.java.io;

import java.io.File;
import java.io.IOException;

public class CreateFile{
	  public static void main(String[] args) throws IOException{
	  File f;
	  f=new File("myfile.txt");
	  if(!f.exists()){
	  f.createNewFile();
	  System.out.println("New file \"myfile.txt\" has been created to the current directory");
	  }
	  }
	}