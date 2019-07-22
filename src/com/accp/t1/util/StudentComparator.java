package com.accp.t1.util;

import java.util.Comparator;

import com.accp.t1.entity.Student;

public class StudentComparator implements Comparator<Student> {

	private Integer status;
	
	
	
	public StudentComparator(Integer status) {
		super();
		this.status = status;
	}


	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		Integer falg = 0;
		
		if(this.status==1) {
			falg = o1.getId()-o2.getId();
		}else if(this.status==2) {
			falg = o2.getAge()-o1.getAge();
		}
		return falg;
	}

}
