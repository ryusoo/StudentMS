package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "shs_update.jsp"; 
		
		// SHSUpdate servlet에서 GET 방식을 가져옴
		int id = Integer.parseInt(request.getParameter("id")); /* DAO에 있는 id가 int이기 때문에 형변환이 필요*/
		// System.out.println("id="+id);
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.memInfo(id);
		
		// forward으로 데이터를 보내는 방식
		request.setAttribute("memInfo", mDto); // request가 넘어온 데이터, 데이터를 보내는 것.
		
		ActionForward forward = new ActionForward(); // 객체 생성 = 사용하겠다는 뜻
		forward.setPath(url); 
		forward.setRedirect(false);
		// forward 방식으로 보냄
		
		return forward; 
	}
	
}
