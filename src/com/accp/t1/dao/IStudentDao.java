package com.accp.t1.dao;

import java.util.List;

import com.accp.t1.entity.Student;

public interface IStudentDao {

	/**
	 * 查询所有学生对象
	 * @return
	 */
	List<Student> queryAllStudent();

}