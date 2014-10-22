package com.andieguo.file.encoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class BufferReaderDemo {

	public static void main(String[] args){
		read2();
	}
	/**
	 * 使用BufferedReader按字符流读取文件，文件编码与读取编码不一致时会出现乱码
	 */
	@SuppressWarnings("unused")
	private static void read1() {
		File file = new File("D:\\Test.java");//当Test.java使用UTF-8编码，而使用GBK编码进行读取的时候会出现乱码；
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));//使用本地环境中的默认字符集，例如在中文环境中将使用 GBK编码
			String line = null;
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * InputStreamReader对字节和字符进行转换,指定使用“GBK”编码方式读取文件。
	 */
	private static void read2() {
		File file = new File("D:\\Test.java");//当Test.java使用UTF-8编码，而使用GBK编码进行读取的时候会出现乱码；
		try { 
			//为什么要对FileInputStream进行再一次封装，为了使用InputStreamReader对字节和字符进行转换；
			//为什么要对InputStreamReader进行再一次封装，为了使用BufferedReader的readline方法；
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));//使用本地环境中的默认字符集，例如在中文环境中将使用 GBK编码
			String line = null;
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
