package com.andieguo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterDemo {

	public static void main(String[] args){
//		rename();
		read();
	}
	
	private static void read(){
		File readFile = new File("README.md");
		try {
			BufferedReader in = new BufferedReader(new FileReader(readFile));
			String line = null;
			int i = 0;
			while((line = in.readLine()) != null){
				System.out.println(line);//´òÓ¡µÄÊÇÂÒÂë
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void rename() {
		File readFile = new File("README.md");
		File writeFile = new File("README_1.md");
		try {
			BufferedReader in = new BufferedReader(new FileReader(readFile));
			BufferedWriter out = new BufferedWriter(new FileWriter(writeFile));
			String line = null;
			int i = 0;
			while((line = in.readLine()) != null){
				System.out.println(line);
				i++;
				out.write(i+"."+line);
				out.newLine();
			}
			out.flush();
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
