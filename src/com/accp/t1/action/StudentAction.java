package com.accp.t1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.t1.biz.StudentBiz;

/**
 * Servlet implementation class StudentAction
 */


public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentBiz b = new StudentBiz();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String m = request.getParameter("m");
		if("findStudent".equals(m)) {
			String status = request.getParameter("status");
			request.setAttribute("LIST", b.findStudent(Integer.valueOf(status)));
			request.getRequestDispatcher("/WEB-INF/view/Onejsp/selectStudent.jsp").forward(request, response);
		}
		else {
			request.setAttribute("LIST", b.queryAllStudent());
			
			request.getRequestDispatcher("/WEB-INF/view/Onejsp/selectStudent.jsp").forward(request, response);
		}
	}

}
