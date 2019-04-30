package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_index.jsp"; // 변수 생성해서 값을 집어 넣음. 동작없음
		
		ActionForward forward = new ActionForward(); // 객체 생성 = 사용하겠다는 뜻
		forward.setPath(url); 
		forward.setRedirect(false);
		// forward 방식으로 보냄
		
		return forward; // 메서드 종료하고 forward를 보낸다. "shs_index.jsp", false 보낸 셈이다
	}
	
}
