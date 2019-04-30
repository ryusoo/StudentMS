package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class InsertPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "";
		
		
		// 이 자료는 SHSInsert.java servlet에서 가져온다.
		
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
					url = "welcome.shs";
				} else {
					url = "insert.shs";
				}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true); // sendRedirect방식 =>DB작업했을 때 덮어씌우지말고(forward) 새로 페이지를 띄우게 함
		
		return forward;
	}

}
