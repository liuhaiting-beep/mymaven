package com.accp.t1.entity;

import java.util.Date;

/**
 * 学生类
 * @author Lenovo
 *
 */
public class Student {
	private Integer id;//学号
	private String name;//学生姓名
	private Integer age;//年龄
	private Date startDate;//入学时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Student(Integer id, String name, Integer age, Date startDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.startDate = startDate;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", startDate=" + startDate + "]";
	}
	
	

}
