package com.org.cancer.pojo;

import java.io.Serializable;

public class Student implements Serializable{
	private int id ;         //id
	
	private int num ;        //学号
	
	private String password ;    //密码
	
	private String name ;      //姓名
	
	private int age ;         //年龄
	
	private double score ;    //成绩
	
	public Student() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}



	public Student(int num, String password, String name, int age, double score) {
		super();
		this.num = num;
		this.password = password;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	

	public Student(int num, String name, int age, double score) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.score = score;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", num=" + num + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", score=" + score + "]";
	}
	
	

}
