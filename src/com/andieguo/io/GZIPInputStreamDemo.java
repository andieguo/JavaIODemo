package com.andieguo.io;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
public class GZIPInputStreamDemo {

	public static void main(String[] args) {
		readZipFile();
//		writeZipFile();
	}
	/**
	 * 通过InputStream输入流读取README.md文件的内容，通过GZIPOutputStream将读取到的字节写入到README.zip
	 */
	private static void writeZipFile(){
		File src = new File("README.md");
		File dst = new File("README.zip");
		try{
			InputStream in = new FileInputStream(src);
			GZIPOutputStream gzipOut = new GZIPOutputStream(new FileOutputStream(dst));
			int len = 0;
			byte[] b = new byte[1024];
			while((len = in.read(b)) != -1){
				gzipOut.write(b, 0, len);
			}
			gzipOut.close();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 通过GZIPInputStream输入流读取README.zip压缩文件内的内容。
	 */
	private static void readZipFile() {
		File src = new File("README.zip");
		try{
			GZIPInputStream gzipIn = new GZIPInputStream(new FileInputStream(src));
			int len = 0;
			byte[] b = new byte[1024];
			StringBuffer buffer = new StringBuffer("");
			while((len = gzipIn.read(b)) != -1){
				String str = new String(b,0,len,"UTF-8");
				buffer.append(str);
			}
			System.out.println(buffer.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
