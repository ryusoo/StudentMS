package com.shs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;

/**
 * Servlet implementation class SHSDelete
 */
@WebServlet("/SHSDelete")
public class SHSDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // 페이지 띄움
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET: 학생 제적 ");
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("id>>> "+id);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memDelete(id);
		
		if(result > 0) {
			response.sendRedirect("SHSSelect");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// 실제 동작인데 삭제라서 동작할게 없음 그래서 GET에 써줌
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
