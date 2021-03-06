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
import com.shs.action.DeletePlayAction;
import com.shs.action.IndexAction;
import com.shs.action.InsertAction;
import com.shs.action.InsertPlayAction;
import com.shs.action.IntroduceAction;
import com.shs.action.SearchAction;
import com.shs.action.SearchPlayAction;
import com.shs.action.SelectPlayAction;
import com.shs.action.UpdateAction;
import com.shs.action.UpdatePlayAction;
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
		
		
		// 4. uri와 ctx를 빼서 경로를 생성한다. 
		// uri = /SHS/insert.shs
		// ctx = /SHS
		// uri - ctx = /insert.shs
		// 생성된 경로 = /insert.shs = command
		
		
		// (4)  uri와 ctx를 빼서 경로를 생성한다. 
		// uri = /SHS/insert.shs
		// ctx = /SHS
		// uri - ctx = /insertPlay.shs
		// 생성된 경로 = /insertPlay.shs = command

		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		// uri에서 ctx를 빼면 내가 원하는 소스만 뽑을 수 있다.

		// System.out.println("uri>>>"+ uri);
		// System.out.println("ctx>>>"+ ctx);
		// System.out.println("cmd>>>"+ command);
		
		System.out.println("페이지 이동===>" + command);
		
		
		
		
		// 5. if문을 돌면서 생성한 url주소(/insert.shs)와 같은 조건문을 탐색
		// (5) if문을 돌면서 생성한 url주소(/insertPlay.shs)와 같은 조건문을 탐색
		if(command.equals("/index.shs")) { //true
			action = new IndexAction(); // 객체 생성, 실제 동작하는 메서드
			forward = action.execute(request, response); // excute, execute 둘다 가능
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/insert.shs")) { // 등록 화면출력
			// 6. InsertAction 클래스 객체 생성 후 생성된 action인스턴스를 사용하여 
			// execute(request, response)함수를 실행
			// 매개변수로 request와 response를 전송
			action = new InsertAction();
			
			// 9. InsertAction 클래스에서 보낸 return값(forward)를 전역변수 forward에 담음
			forward = action.execute(request, response); 
		} else if(command.equals("/insertPlay.shs")) { 
			// (6) InsertPlayAction 클래스 객체 생성 후 생성된 action인스턴스를 사용하여 
			// execute(request, response)함수를 실행
			// 매개변수로 request와 response를 전송
			// * 현재 jsp에서 보낸 input태그 값은 request에 담겨 있음
			// * execute() 함수를 실행할 때 매개변수로 request를 전송함으로 InsertPlayAction 클래스에서 
			//   input태그들의 값을 사용할 수 있음
			action = new InsertPlayAction(); // Play가 붙어있으면 실제 동작(Action)하는 메서드
			// (20) InsertPlayAction 클래스에서 보낸 return값(forward)를 전역변수 forward에 담음
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
			action = new IntroduceAction();
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/select.shs")) { 
			action = new SelectPlayAction();
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/update.shs")) { 
			action = new UpdateAction();
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} else if(command.equals("/updatePlay.shs")) { 
			action = new UpdatePlayAction();
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		}else if(command.equals("/delete.shs")) { 
			action = new DeletePlayAction();
			forward = action.execute(request, response); 
			// 우측에서 좌측으로 읽는다. action클래스의 execute함수를 실행해라, 매개변수를 request, response를 보낸다
		} 
		
		
		
		
		// ------------------공통 분기 작업-------------------------
		// 10. InsertAction에서 보낸 return값 forward를 사용하여 페이지 이동 경로와 방법 데이터를 전송
		// forward.getPath() = "shs_insert.jsp"
		// forward.isRedirect() = false;
		// forward가 null이 아니기 때문에 if문을 실행
		
		// (21) InsertPlayAction에서 보낸 return값 forward를 사용하여 페이지 이동 경로와 방법 데이터를 전송
		// forward.getPath() = "welcome.jsp"
		// forward.isRedirect() = true;
		// forward가 null이 아니기 때문에 if문을 실행
		
			if(forward != null) { // forward에 값 들어있음. if문 탄다.
			
		// 11. forward.isRedirect()가 false이기 때문에 if문을 실행하지 않고 else문을 실행
		// (22). forward.isRedirect()가 true이기 때문에 if문을 실행
			if(forward.isRedirect()) { // ActionForward 클래스의 isRedirect()함수를 호출. false가 있어서 else를 탄다
				// (23) forward방식으로 'welcome.jsp' 페이지로 이동
				response.sendRedirect(forward.getPath());
			} else { // false이기 때문에 여기를 탄다
				// page 전환 시 forward 방식
				// 12. forward방식으로 'shs_insert.jsp' 페이지로 이동
				
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath()); // shs_index.jsp를 가지고 옴
				rd.forward(request, response); // forward방식이니까 기존에 가지고 있던 request, response방식을 가져야하니까
			}
		}
	}

}
