package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class UpdatePlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = ""; 
		// DB를 타고 온 출석부를 띄워야함. 바로 jsp띄우면 빈깡통이 온다 shs_select.jsp 는 안된다.  
		
		// SHSUpdate 에서 가지고 온다
		int sid = Integer.parseInt(request.getParameter("input_id"));
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		
		/* toString()은 DTO에 값이 담겨있어야지 다 보여주는 방식이기 때문에 DTO가 있어야 함. */
		MemberDTO mDto = new MemberDTO(sid, sname, sage, smajor, sphone);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memUpdate(mDto);
		
		if(result > 0) {
			url = "select.shs";
		} else {
			url = "index.shs";
		} 
		
		
		
		ActionForward forward = new ActionForward(); // 객체 생성 = 사용하겠다는 뜻
		forward.setPath(url); 
		forward.setRedirect(true); // sendRedirect
		
		return forward; // 메서드 종료하고 forward를 보낸다. "shs_index.jsp", false 보낸 셈이다

	}	
	
}
