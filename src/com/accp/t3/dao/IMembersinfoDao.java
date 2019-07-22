package com.accp.t3.dao;

import java.util.List;

import com.accp.t3.entity.membersinfo;

public interface IMembersinfoDao {

	/**
	 * 查询所有会员
	 * @return
	 */
	List<membersinfo> queryMember(int id,int currn,int pagesize);

	/**
	 * 修改指定会员
	 * @param m
	 * @return
	 */
	int setMember(membersinfo m);

	/**
	 * 查询总条数
	 * @return
	 */
	int queryMemberCount();

}