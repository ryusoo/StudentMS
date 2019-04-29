package com.shs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

/**
 * Servlet implementation class SHSUpdate
 */
@WebServlet("/SHSUpdate")
public class SHSUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 출석부 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET: 학생수정페이지 출력");
		int id = Integer.parseInt(request.getParameter("id")); /* DAO에 있는 id가 int이기 때문에 형변환이 필요*/
		System.out.println("id="+id);
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.memInfo(id);
		
		// forward으로 데이터를 보내는 방식
		request.setAttribute("memInfo", mDto); // request가 넘어온 데이터, 데이터를 보내는 것.
		RequestDispatcher dis = request.getRequestDispatcher("shs_update.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// 수정 누를 때 실제 ACTION
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST: 학생수정 Action 동작");
		
		// POST방식 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		int sid = Integer.parseInt(request.getParameter("input_id"));
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		
		/* toString()은 DTO에 값이 담겨있어야지 다 보여주는 방식이기 때문에 DTO가 있어야 함. */
		MemberDTO mDto = new MemberDTO(sid, sname, sage, smajor, sphone);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memUpdate(mDto);
		
		// System.out.println(">>>>>>>>>>>>>>" + result);
		if(result > 0) { // 수정성공
			response.sendRedirect("SHSSelect");
		} else {
			response.sendRedirect("index");
		}
		
		// System.out.println(mDto.toString());
		
		
	}

}
