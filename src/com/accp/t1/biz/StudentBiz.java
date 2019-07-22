package com.accp.t1.biz;

import java.util.Collections;
import java.util.List;

import com.accp.t1.dao.IStudentDao;
import com.accp.t1.dao.StudentDaoImpl;
import com.accp.t1.entity.Student;
import com.accp.t1.util.StudentComparator;

public class StudentBiz {
	
	private IStudentDao dao = new StudentDaoImpl();

	/**
	 * 查询所有学生对象
	 * @return
	 */
	public List<Student> queryAllStudent(){
		return dao.queryAllStudent();
		
	}
	/**
	 * 根据状态判断学生的排序
	 * @param status 状态
	 * @return 
	 */
	public List<Student> findStudent(Integer status){
		List<Student> date = dao.queryAllStudent();
		Collections.sort(date,new StudentComparator(status));
		return date;
	}
}
