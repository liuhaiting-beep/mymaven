package com.accp.t1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.accp.t1.entity.Student;

public class StudentDaoImpl extends BaseDao implements IStudentDao{
	
	/* (non-Javadoc)
	 * @see com.accp.t1.dao.IStudentDao#queryAllStudent()
	 */
	@Override
	public List<Student> queryAllStudent(){
		ResultSet rs=null;
		try {
			rs = super.query("select * from student");
			List<Student> date = new ArrayList<Student>();
			while(rs.next()) {
				Student s = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4));
				date.add(s);
			}
			return date;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
				super.release(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		
	}
}
