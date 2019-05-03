package com.shs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class SelectPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "shs_select.jsp"; 
		
		// 학생목록 DB에서 가져와서 View로 보냄
		// SHSSelect servlet에서 가져온다. 
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
		
		// 총 인원 수
		int cnt = list.size();
		request.setAttribute("cnt", cnt);
		
		ActionForward forward = new ActionForward(); // 객체 생성 = 사용하겠다는 뜻
		forward.setPath(url); 
		forward.setRedirect(false);
		// forward 방식으로 보냄
		
		return forward; 
		
		
		
	}
	
}
