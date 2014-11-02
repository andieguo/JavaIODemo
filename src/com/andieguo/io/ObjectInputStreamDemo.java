package com.andieguo.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ObjectInputStreamDemo {
	//ObjectOutputStream和ObjectInputStream处理的对象必须实现Serializable接口
	public static void main(String[] args){
//		readObject();
		readList();
	}

	private static void readList() {
		File src = new File("Student.txt");
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(src));
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(src));
			Student student1 = new Student("andy", 24, true, "武汉", "7777777");
			Student student2 = new Student("posly", 24, true, "九江", "88888888");
			List<Student> students = new ArrayList<Student>();
			students.add(student1);
			students.add(student2);
			out.writeObject(students);
			Object obj = null;
			while((obj = in.readObject())!=null){
				System.out.println(((List<Student>)obj).toString());
			}
	        out.close();
	        in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void readObject() {
		File src = new File("Student.txt");
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(src));
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(src));
			Student student1 = new Student("andy", 24, true, "武汉", "7777777");
			Student student2 = new Student("posly", 24, true, "九江", "88888888");
			out.writeObject(student1);
			out.writeObject(student2);
			Object obj = null;
			while((obj = in.readObject())!=null){
				System.out.println(((Student)obj).toString());
			}
	        out.close();
	        in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
