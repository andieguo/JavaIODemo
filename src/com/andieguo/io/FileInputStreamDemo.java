package com.andieguo.io;

import java.io.*;

public class FileInputStreamDemo {

	public static void main(String[] args){
//		rename();
		read();
	}
	/**
	 * 使用FileInputStream读取文本文件内容
	 */
	private static void read() {
		File src = new File("README.md");
		try {
			InputStream in = new FileInputStream(src);
			int len = 0;
			byte[] b = new byte[1024];
			StringBuffer buffer = new StringBuffer();
			while((len = in.read(b)) != -1){//区别于in.read();in.read(b)该方法是将读取到的字节填充到字节数组b中。
				//将字节数组转换为字符串;
				String str = new String(b,0,len,"UTF-8");//将字节数组转换为字符串默认使用GBK编码；如果所读取的文件使用的是非GBK编码，采用默认的GBK编码转换，则会出现乱码。
				buffer.append(str);
				System.out.println(buffer.toString());
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用FileInputStream、FileOutputStream进行数据的读取与写入；
	 */
	private static void rename() {
		File src = new File("IO.jpg");
		File dst = new File("IO_2.jpg");
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			int len = 0;
			byte[] b = new byte[1024];
			while((len = in.read(b)) != -1){//区别于in.read();in.read(b)该方法是将读取到的字节填充到字节数组b中。
				out.write(b,0,len);//区别于out.write(b);out.write(b,0,len)该方法是将字节数组b中0-len长度的字节写入到输出流。
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 是否更见规范？直接关闭流与在finally中关闭流有什么不同？
	 */
	private static void rename2() {
		File src = new File("IO.jpg");
		File dst = new File("IO_2.jpg");
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			int len = 0;
			byte[] b = new byte[1024];
			while((len = in.read(b)) != -1){//区别于in.read();in.read(b)该方法是将读取到的字节填充到字节数组b中。
				out.write(b,0,len);//区别于out.write(b);out.write(b,0,len)该方法是将字节数组b中0-len长度的字节写入到输出流。
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
