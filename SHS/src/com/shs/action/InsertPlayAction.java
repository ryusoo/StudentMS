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
	
		
		
		// (7) jsp -> FrontController -> InsertPlayAction 으로 request를 사용하여 전송한 
		// input태그들의 value를 꺼내서 sname, sage, smajor, sphone, 변수에 각각 담음
		String sname = request.getParameter("input_name"); // name이기 때문에 . # 안 쓴다.
		
		/*
		 * String age = request.getParameter("input_age"); int sage =
		 * Integer.parseInt(age);
		 */
		// 위와 아래와 같음
		int sage = Integer.parseInt(request.getParameter("input_age"));
		
				
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		
		// Model Start
		// (8) MemberDAO 객체를 빌림
		MemberDAO mDao = MemberDAO.getInstance(); // sqlSessionFactory 생성
		// (9) MemberDTO객체 생성과 동시에 (이름, 나이, 전공, 번호)값을 초기화
		MemberDTO mDto = new MemberDTO(sname, sage, smajor, sphone);
		// (10) MemberDAO 클래스의 memInsert()함수를 실행
		// 		매개변수로 (이름, 나이, 전공, 번호)가 담긴 mDto를 전송
		int result = mDao.memInsert(mDto); // sqlSession 생성.
		// (16) MemberDAO의 memInsert()메서드에서 보낸 return값을 result 변수에 담음	
		
		// (17) result > 0 : 등록성공
		// 		else : 등록 실패
		// 등록 성공시 이동하는 페이지를 welcome페이지로 설정
		// 등록 실패시 이동하는 페이지를 학생등록페이지로 설정
		if(result > 0) {
			url = "welcome.shs";
		} else {
			url = "insert.shs";
		}
		
		// (18) ActionForward 객체를 생성 후 forward 인스턴스를 활용하여 
		// forward 인스턴스의 path변수에 "welcome.jsp"를 
		// forward 인스턴스의 isRedirect 변수에 true값을 각각 담음
		// (insert, delete, update같이 값이 변하기 때문에 DB를 타기 때문에 true) 
		// * 값이 안변하는 것은 forward, 값이 변하는 것은 sendRedirect
	
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true); // sendRedirect방식 =>DB작업했을 때 덮어씌우지말고(forward) 새로 페이지를 띄우게 함
		// (19) path와 isRedirect 값을 담고 있는 
		// forward를 return을 사용하여 호출한 곳(FrontController)으로 전송
		return forward;
	}

}
