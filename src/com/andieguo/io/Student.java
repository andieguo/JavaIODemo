package com.andieguo.io;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private Boolean sex;
	private String address;
	private String tel;
	
	public Student(String name, Integer age, Boolean sex, String address,
			String tel) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + ", tel=" + tel + "]";
	}
	
}
