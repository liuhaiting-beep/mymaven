package com.accp.t3.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.t3.biz.MembersinfoBiz;
import com.accp.t3.entity.Page;
import com.accp.t3.entity.membersinfo;

/**
 * Servlet implementation class MembersinfoAction
 */
public class MembersinfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MembersinfoBiz b = new MembersinfoBiz();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersinfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String m = request.getParameter("m");
		
		if("toup".equals(m)) {
			String id = request.getParameter("id");
			int id1 = 0;
			if(id!=null && id!="") {
				id1=Integer.valueOf(id);
			}
			List<membersinfo> t = b.queryMember(id1, 1, 2);
			request.setAttribute("LIST", t);
			request.getRequestDispatcher("/WEB-INF/view/Threejsp/findMember.jsp").forward(request, response);
			
		}else if("up".equals(m)) {
			String id = request.getParameter("id");
			String name = request.getParameter("mname");
			String age = request.getParameter("mage");
			String gender = request.getParameter("mgender");
			String address = request.getParameter("maddress");
			String email = request.getParameter("memail");
			membersinfo m1 = new membersinfo(Integer.valueOf(id), name, gender, Integer.valueOf(age), address, email);
			int a = b.setMember(m1);
			if(a>0) {
				response.sendRedirect("member");
			}
		}else {
			//查询所有
			String currn = request.getParameter("currn");
			int c = 1;
			if(currn!=null && currn!="") {
				c = Integer.valueOf(currn);	
			}
			Page<membersinfo> t = b.queryPage(0, c,2);
			request.setAttribute("LIST", t);
//			System.err.println("当前："+t.getCurrn()+"总页"+(t.getCurrn()>=t.getTotalpage()?t.getTotalpage():t.getCurrn()+1)+"下一页"+t.getNext());
			request.getRequestDispatcher("/WEB-INF/view/Threejsp/findMemberAll.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
