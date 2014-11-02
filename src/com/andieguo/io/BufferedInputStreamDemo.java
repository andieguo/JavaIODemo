package com.andieguo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedInputStreamDemo {
	
	public static void main(String[] args){
		rename2();
	}
	/**
	 * 使用BufferedInputStream、BufferedOutputStream进行数据的读取与写入。
	 */
	private static void rename2() {
		File src = new File("IO.jpg");
		File dst = new File("IO_2.jpg");
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst));
			int len = 0;
			byte[] b = new byte[1024];
			while((len = in.read(b)) != -1){
				out.write(b,0,len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
