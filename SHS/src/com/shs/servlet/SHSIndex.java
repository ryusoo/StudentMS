package com.shs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SHSIndex
 */
@WebServlet("/index") //http://localhost:8081/SHS/SHSIndex
// 처음 만들어진 것 @WebServlet("/SHSIndex") -> @WebServlet("/index") 로 바꿔서 index로 뜨게 만들었음.
// http://localhost:8081/SHS/index
public class SHSIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // default로 GET 방식을 탄다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET: index페이지 출력");
		response.sendRedirect("shs_index.jsp"); // "shs_index.jsp"으로 전송하겠다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
