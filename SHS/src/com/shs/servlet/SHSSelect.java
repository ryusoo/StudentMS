package com.shs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

/**
 * Servlet implementation class SHSSelect
 */
@WebServlet("/SHSSelect")
public class SHSSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GET:출석부 페이지 출력");
		
		
		
		MemberDAO mDao = MemberDAO.getInstance(); 
		// static일 때는 객체생성 하지 않아서 인스턴스가 만들어지지 않음 그래서 인스턴스명으로 접근할 수 없기 때문에 클래스명으로 접근한다
		List<MemberDTO> list = mDao.memSelect();
		
		
		// servlet에서 jsp로 데이터(list) 보냄
		// servlet에서 페이지이동방법 2가지
		// 1. (send)redirect 
		// 2. forward
		
		// forward
		// 받을 때 getParameter(); 보낼 때 setAttribute();
		request.setAttribute("shslist", list); // 이름표를 붙여야 꺼내 올 수 있고 뒤는 실제 값 써준다. 여기가지는 일단 값을 넣음
		
		RequestDispatcher dis = request.getRequestDispatcher("shs_select.jsp");
		dis.forward(request, response); // forward는 A page와 Bpage가 request, response를 둘 다 공유하기 때문에 
		
		// 이렇게 하면 shs_select.jsp로 페이지 이동하고 정보를 가지고 있다.
		
		
		
		
		// response.sendRedirect("shs_select.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
