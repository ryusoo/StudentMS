package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntroduceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "shs_madeby.jsp";
		
		ActionForward forward = new ActionForward(); 
		forward.setPath(url); 
		forward.setRedirect(false);
		
		return forward; 
		
		
	}

}
