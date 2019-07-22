package com.accp.t3.biz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.t3.dao.IMembersinfoDao;
import com.accp.t3.dao.MembersinfoDaoImpl;
import com.accp.t3.entity.Page;
import com.accp.t3.entity.membersinfo;

public class MembersinfoBiz {
	
	private IMembersinfoDao dao = new MembersinfoDaoImpl();

	/**
	 *  查询所有会员
	 * @return
	 */
	public List<membersinfo> queryMember(int id,int currn,int pagesize){
		return dao.queryMember(id,currn, pagesize);
	}
	/**
	 * 修改指定会员
	 * @param m
	 * @return
	 */
	public int setMember(membersinfo m) {
		return dao.setMember(m);
	}
	/**
	 * 查询总条数
	 * @return
	 */
	public int queryMemberCount(){
		return dao.queryMemberCount();
	}
	
	/**
	 * 无参分页
	 * @param currn
	 * @param pagesize
	 * @return
	 */
	public Page<membersinfo> queryPage(Integer id,Integer currn,Integer pagesize){
		int a = dao.queryMemberCount();
		List<membersinfo> m = dao.queryMember(id,currn, pagesize);
		Page<membersinfo> date = new Page<>(currn, pagesize, a, m);
		return date;
		
	}
}
