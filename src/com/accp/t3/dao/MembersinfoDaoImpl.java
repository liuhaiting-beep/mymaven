package com.accp.t3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.t3.entity.membersinfo;

public class MembersinfoDaoImpl extends BaseDao implements IMembersinfoDao {
	/* (non-Javadoc)
	 * @see com.accp.t3.dao.IMembersinfoDao#queryMember()
	 */
	@Override
	public List<membersinfo> queryMember(int id,int currn1,int pagesize){
		int currn = (currn1-1)*pagesize;
		ResultSet rs = null;
		List<membersinfo> m = new ArrayList<membersinfo>();
		try {
			if(id!=0) {
				rs = super.query("select * from membersinfo where mid=?",id);
			}else {
				rs = super.query("select * from membersinfo limit ?,?",currn,pagesize);
			}
			while(rs.next()) {
				membersinfo e = new membersinfo(rs.getInt("mid"), rs.getString("mname"), rs.getString("mgender"), rs.getInt("mage"), rs.getString("maddress"), rs.getString("memail"));
				m.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			try {
				super.release(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}
	
	/* (non-Javadoc)
	 * @see com.accp.t3.dao.IMembersinfoDao#setMember(com.accp.t3.entity.membersinfo)
	 */
	@Override
	public int setMember(membersinfo m) {
		try {
			return super.update("UPDATE `membersinfo` SET `mname`=?,`mgender`=?,`mage`=?,`maddress`=?,`memail`=? WHERE `mid`=?", m.getMname(),m.getMgender(),m.getMage(),m.getMaddress(),m.getMemail(),m.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.accp.t3.dao.IMembersinfoDao#queryMemberCount()
	 */
	@Override
	public int queryMemberCount(){
		ResultSet rs = null;
		try {
			rs = super.query("select count(*) from membersinfo");
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			try {
				super.release(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	

}
