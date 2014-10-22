package com.andieguo.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferReaderAndWriter {

	public static void main(String[] args){
		File readFile = new File("D:\\Test.java");
		File writeFile = new File("D:\\hello2.txt");
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
