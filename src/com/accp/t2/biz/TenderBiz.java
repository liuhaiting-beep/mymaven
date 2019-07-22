package com.accp.t2.biz;


import java.util.List;

import com.accp.t2.dao.ITenderDao;
import com.accp.t2.dao.TenderDaoImpl;
import com.accp.t2.entity.Tender;

public class TenderBiz {
	
	private ITenderDao dao = new TenderDaoImpl();
	
	/**
	 * 获得所有投标信息
	 * @return
	 */
	public List<Tender> getAll(){
		return dao.getAll();
	}
	
	/**
	 * 获得指定的招标信息
	 * @param tenderId
	 * @return
	 */
	public Tender get(String tenderId){
		return dao.get(tenderId);
	}

	/**
	 * 删除指定的招标信息
	 * @param tenderId
	 * @return
	 */
	public int deleteById(String tenderId) {
		int a = dao.delete2(tenderId);
		if(a>0) {
			a = dao.delete(tenderId);
		}
		return a;
	}

	
}
