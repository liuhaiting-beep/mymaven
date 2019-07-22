package com.accp.t1.test;

import java.util.List;

import com.accp.t1.biz.StudentBiz;
import com.accp.t1.entity.Student;

public class StudentBizTest {
	
	public static void main(String[] args) {
		StudentBiz b=  new StudentBiz();
		List<Student> student = b.queryAllStudent();
		for (Student s : student) {
			System.out.println(s);	
		}
		System.err.println("12345575");
	}
}
