package com.andieguo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferWriterDemo {

	public static void main(String[] args){
		addNumber();
	}
	
	/**
	 * 在每一行前添加Number+“.”
	 */
	private static void addNumber(){
		File file1 = new File("D:\\Test.java");
		File file2 = new File("D:\\Test2.java");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file1),"GBK"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2),"GBK"));
			String line = null;
			int count = 0;
			while((line = in.readLine()) != null){
				System.out.println(line);
				count ++;
				out.write(count+"."+line);
				out.newLine();
			}
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * 删除每一行前的Number+“.”
	 */
	@SuppressWarnings("unused")
	private static void delNumber(){
		File file1 = new File("D:\\Test.java");
		File file2 = new File("D:\\Test5.java");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file1),"UTF-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2),"UTF-8"));
			String line = null;
			int count = 0;
			while((line = in.readLine()) != null){
				count ++ ;
				if(line.indexOf(".") != -1){
					line = line.replace(count+".", "");//将count+"."替换为空格
					out.write(line);
					out.newLine();
				}
			}
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
