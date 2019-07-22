package com.accp.t2.dao;

import java.util.List;

import com.accp.t2.entity.Tender;

public interface ITenderDao {

	//	获得所有投标信息
	List<Tender> getAll();

	//	获得指定的招标信息
	Tender get(String tenderId);

	//	删除指定的招标信息：从表
	int delete(String tenderId);
	
	//  删除指定的招标信息：主表
	int delete2(String tenderId);

}