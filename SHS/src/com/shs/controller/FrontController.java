package com.shs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.action.Action;
import com.shs.action.ActionForward;
import com.shs.action.IndexAction;
import com.shs.action.InsertAction;
import com.shs.action.InsertPlayAction;
import com.shs.action.IntroduceAction;
import com.shs.action.SearchAction;
import com.shs.action.SearchPlayAction;
import com.shs.action.WelcomeAction;

/**
 * Servlet implementation class FrontController
 */

//FrontController 패턴
//앞단에 Controller 역할을 하는 Servlet 1개만
//생성 후 생성된 1개의 Servlet이 request와 response를 모두 처리하고,
//실제 동작하는 Action부분만 Class로 여러개 생성해서 사용하는 방법
//기존에 동작마다 Servlet을 생성하던 방식에 비해 효율성이 매우 Up 됨 
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FrontController() {
        super();
        
    }

	
    // doGet(), doPost() 모두 service()로 통해서 작동하게 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글깨짐 방지(POST방식) 항상 맨 첫 줄
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;
		ActionForward forward = null; // IndexAction에 보낸 forward 값이 담겨있음.(DTO처럼 forward가 사용됨)
		
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		// uri에서 ctx를 빼면 내가 원하는 소스만 뽑을 수 있다.

		// System.out.println("uri>>>"+ uri);
		// System.out.println("ctx>>>"+ ctx);
		// System.out.println("cmd>>>"+ command);
		
		System.out.println("페이지 이동===>" + command);
		
		if(command.equals("/index.shs")) { //true
			action = new IndexAction(); // 객체 생성, 실제 동작하는 메서드
			forward = action.execute(request, response); // excute, execute 둘다 가능
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/insert.shs")) { // 등록 화면출력
			action = new InsertAction(); // 객체 생성, 실제 동작하는 메서드
			forward = action.execute(request, response); 
		} else if(command.equals("/insertPlay.shs")) { 
			action = new InsertPlayAction(); // Play가 붙어있으면 실제 동작(Action)하는 메서드
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/welcome.shs")) { 
			action = new WelcomeAction(); 
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/search.shs")) { 
			action = new SearchAction(); // 검색 Page
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/searchPlay.shs")) { 
			action = new SearchPlayAction(); // 검색 동작(Action)
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		}  else if(command.equals("/introduce.shs")) { 
			action = new IntroduceAction(); // 검색 동작(Action)
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		}
		
		
		// ------------------공통 분기 작업-------------------------
		if(forward != null) { // forward에 값 들어있음. if문 탄다.
			if(forward.isRedirect()) { // ActionForward 클래스의 isRedirect()함수를 호출. false가 있어서 else를 탄다
				response.sendRedirect(forward.getPath());
			} else { // false이기 때문에 여기를 탄다
				// page 전환 시 forward 방식
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath()); // shs_index.jsp를 가지고 옴
				rd.forward(request, response); // forward방식이니까 기존에 가지고 있던 request, response방식을 가져야하니까
			}
		}
	}

}
