关于BufferedInputStream和FileInputStream的区别

我觉得您可能是不太了解“堵塞”的意思吧！
假设一个文件的长度是100个字节，要将之读取到内存中，再假设您每次只读取10个字节，那么读完整个文件是不是读取10次的呀？

假设老板让你完成100件事情，老板说，你每天只完成10件就可以了，难道你非得等到第十天才完成第100件事情吗？有一天您在中午下班前就完成了10件事情，下午您不妨多干一点，那么也许在第9天的时候就完成了100件事情。

同理，BufferedInputStream有可能会读取比您规定的更多的东西到内存，以减少访问IO的次数，
总之您要记住一句话，访问IO的次数越少，性能就越高，原因就在于CPU和内存的速度》》》》远大于硬盘或其他外部设备的速度。

换一个不太恰当的例子来说，您和您的朋友一起去登山，你朋友太不给力了，走一会儿就要休息，而您呢，您的体力比他要好的多，根本不需要休息，所以每当他休息的时候，您得等着他，您那时候什么也干不了，这就叫堵塞，堵塞就是说您有能力干某事，但是迫于某种原因您什么也干不了，只能干等。所以您朋友休息的次数越少，你们两个到达山顶所花费的时间就越少。CPU访问硬盘的次数越少，程序就越快。BufferedInputStream在小型文件中的性能优势无法体现出来，假设您将以个2G大小的文件从D盘完全复制到E盘，性能之优势便展露无疑！

    import java.io.*;
    public class SS {
    	public static void main(String[] args) throws Exception {
    		File f = new File("d:\\大型数据库文件.mdf");	
    		FileInputStream fis = new FileInputStream(f);
    		//如果下面的语句使用BufferedOutputStream来修饰则带来更好的性能现。
    		FileOutputStream fos = new FileOutputStream("e:\\" + f.getName());	
    		int length = 0;
    		byte[] b = new byte[1024];
    		while((length = fis.read(b)) != -1)
    		{
    			fos.write(b, 0, length);
    		}
    		fos.close();
    		fis.close();
    	}
    }





拷贝多媒体文件(图片,音乐,视频等)  

    import java.io.BufferedInputStream;
    import java.io.BufferedOutputStream;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    
    public class Io{
	    public static void main(String[] args){
		    try {
			    BufferedInputStream in = new BufferedInputStream(new FileInputStream("d:\\1.jpg"));
			    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("d:\\1\\2.jpg"));
			    int by = 0;
			    while((by=in.read())!=-1){
			    	out.write(by);
			    }
			    in.close();
			    out.close();
		    } catch (FileNotFoundException e) {
		    	e.printStackTrace();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
	    
	    }
    }

[BufferedInputStream-我们到底能走多远系列（3）](http://www.cnblogs.com/killbug/archive/2012/08/22/2651524.html)
