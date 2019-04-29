package com.shs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

/**
 * Servlet implementation class SHSInsert
 */
@WebServlet("/SHSInsert") //url Mapping
public class SHSInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET: 학생등록페이지 출력");
		response.sendRedirect("shs_insert.jsp"); // 전송한다. shs_insert.jsp화면을 띄운다. 반환해서 웹브라우저로 보여준다.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST: DB에 학생회원 등록!");
		
		// POST방식 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		// 4개의 값을 받아온다
		// 뷰단에서 오는 자료는 다 String타입
		// DTO이름으로 만들어두면 객체생성해서 넣을 때 바로 넣을 수 있어 편한다
		String sname = request.getParameter("input_name"); // name이기 때문에 . # 안 쓴다.
		
		/*
		 * String age = request.getParameter("input_age"); int sage =
		 * Integer.parseInt(age);
		 */
		// 위와 아래와 같음
		int sage = Integer.parseInt(request.getParameter("input_age"));
		
		
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		MemberDAO mDao = MemberDAO.getInstance(); // sqlSessionFactory 생성
		MemberDTO mDto = new MemberDTO(sname, sage, smajor, sphone);
		int result = mDao.memInsert(mDto); // sqlSession 생성.
		 
		if(result > 0) {
			response.sendRedirect("Welcome");
		} else {
			response.sendRedirect("SHSInsert");
		}
		
		System.out.println(sname+", "+sage+", "+smajor+", "+sphone);
		
	
	}

}
