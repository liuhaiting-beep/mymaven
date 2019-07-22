package com.accp.t2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.accp.t2.entity.Bid;
import com.accp.t2.entity.Tender;

public class TenderDaoImpl extends BaseDao implements ITenderDao{

	/* (non-Javadoc)
	 * @see com.accp.t2.dao.ITenderDao#getAll()
	 */
	@Override
	public List<Tender> getAll(){
		ResultSet rs = null;
		List<Tender> date = new ArrayList<Tender>();
		try {
			rs = super.query("select * from tender");
			while (rs.next()) {
				Tender t = new Tender(rs.getInt(1),rs.getString(2));
				date.add(t);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
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
		return date;
	}


	/* (non-Javadoc)
	 * @see com.accp.t2.dao.ITenderDao#get(java.lang.String)
	 */
	@Override
	public Tender get(String tenderId){
		ResultSet rs = null;
		Tender t = null;
		try {
			rs = super.query("SELECT * FROM tender AS t " + 
					" INNER JOIN `bid` AS b ON t.`tender_id`=b.`tender_id` "
					+ " WHERE t.`tender_id`=?",tenderId);
			Set<Bid> bset = new HashSet<Bid>();
			Integer id=0;
			String name=null;
			while (rs.next()) {
				Bid b = new Bid(rs.getInt("bid_id"), rs.getString("company"));
				bset.add(b);
				id = rs.getInt("tender_id");
				name = rs.getString("project_name");
			}
			t = new Tender(id,name,bset);
		} catch (Exception e) {
			// TODO: handle exception
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
		return t;
	}


	/* (non-Javadoc)
	 * @see com.accp.t2.dao.ITenderDao#delete(java.lang.String)
	 */
	@Override
	public int delete(String tenderId) {
		try {
			return super.update("DELETE FROM  `tender` WHERE `tender_id`=?", tenderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.accp.t2.dao.ITenderDao#delete2(java.lang.String)
	 */
	@Override
	public int delete2(String tenderId) {
		try {
			return super.update("DELETE FROM  `bid` WHERE `tender_id`=?", tenderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
