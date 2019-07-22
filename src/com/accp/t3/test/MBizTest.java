package com.accp.t3.test;

import com.accp.t3.biz.MembersinfoBiz;

public class MBizTest {
	public static void main(String[] args) {
		System.err.println(new MembersinfoBiz().queryMember(0,1, 2));
	}

}
