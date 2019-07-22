package com.accp.t2.dao;

import java.sql.*;

public abstract class BaseDao {

	private static final String CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/shijuantimu";
	private static final String USER_NAME = "root";
	private static final String USER_PWD = "123456";

	private Connection conn;
	private PreparedStatement ps;

	static {
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void openConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		}
	}

	public void release(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

	public int update(String sql, Object... params) throws SQLException {
		System.out.println("执行SQL:" + sql);
		this.openConnection();
		ps = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		int count = ps.executeUpdate();
		return count;
	}

	public ResultSet query(String sql, Object... params) throws SQLException {
		System.out.println("执行SQL:" + sql);
		this.openConnection();
		ps = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		return rs;
	}

}
