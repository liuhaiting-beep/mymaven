package com.accp.t2.test;

import java.util.List;

import com.accp.t2.biz.TenderBiz;
import com.accp.t2.entity.Tender;

/**
 * 测试招标信息类
 * @author Lenovo
 *
 */
public class TenderBizTest {
	public static void main(String[] args) {
		TenderBiz b = new TenderBiz();
		Tender t = b.get("1");
			System.out.println(t);
	}

}
