package com.andieguo.file.encoder;

import java.io.*;
/**
 * 
1.IO流是干什么的？

     IO流指 的是输入输出流，用来处理设备上的数据。这里的设备指硬盘，内存，键盘录入，网络传输等。
     
2.IO流的分类？

     按处理数据类型来分：字节流和字符流

     按流的方向来分：输入流和输入流。

     PS:初学流的时候，新手很容易搞不清什么时候用输入流，什么时候用输出流。简单来说，当需要读数据的时候，需要使用输入流，当需要写数据的时候，需要使用输出流。我以前是这么记忆的:“读入写出”，要读的话就用输入流，要写的话，就用输出流。经常想起这4个字，慢慢就记熟下来了。

3.什么时候使用字节流？什么时候使用字符流？

    首先需要知道的是，任何数据存在硬盘上时，都是以二进制的形式存储的。而通过使用字节流，可以读取任意文件。字节流一次读取一个字节，而字符流使用了字节流读到一个或者多个字节时，去查找指定的编码表，返回对应的编码。所以字符流只能处理纯文本字符数据，而字节流可以处理更多类型的数据，比如图片，视频，音频文件等。因此，只要是纯文本数据处理，优先考虑使用字符流。其他情况就使用字节流。

4.IO流类的关系(列举了其中一部分)

http://www.ibm.com/developerworks/cn/java/j-lo-chinesecoding/
 * @author Administrator
 *
 */
public class OutputStreamWriterDemo {

	public static void main(String[] args){
		File file = new File("D:\\Test.java");
		try {
			// 写字符换转成字节流（使用GBK编码进行写）
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream,"GBk");
			writer.write("我是中国人");
			writer.close();
			
			// 读取字节转换成字符（使用GBK编码进行读）
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(inputStream,"GBk");
			StringBuffer buffer = new StringBuffer();
			char[] cbuf = new char[64];
			int count = 0;
			while((count = reader.read(cbuf))!=-1){
				buffer.append(cbuf,0,count);
				System.out.println(buffer);
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
}
