package com.accp.t2.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.t2.biz.TenderBiz;
import com.accp.t2.entity.Tender;

/**
 * Servlet implementation class TenderAction
 */
public class TenderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TenderBiz biz = new TenderBiz();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderAction() {
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
		if("queryById".equals(m)) {
			//根据对应工程查询详情
			String id = request.getParameter("id");
			Tender t = biz.get(id);
			request.setAttribute("LIST", t);
			request.getRequestDispatcher("/WEB-INF/view/Twojsp/findTenderDetail.jsp").forward(request, response);
			
		}else if("delete".equals(m)) {
			//删除
			String id = request.getParameter("id");
			response.getWriter().println(biz.deleteById(id));
		}else {
			//查询所有
			List<Tender> t = biz.getAll();
			request.setAttribute("tenderLIST", t);
			request.getRequestDispatcher("/WEB-INF/view/Twojsp/findAll.jsp").forward(request, response);
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
