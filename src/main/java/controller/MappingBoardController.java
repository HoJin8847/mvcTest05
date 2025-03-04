package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteCommand;
import service.BoardInputCommand;
import service.BoardInterface;
import service.BoardListCommand;
import service.BoardUpdateCommand;

@SuppressWarnings("serial")
@WebServlet("*.do") // 이건 확장자 패턴. 확장자가 do로 되어있는 건 모두 내게로 오라
public class MappingBoardController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		BoardInterface command = null;
		
		String viewPage = "/WEB-INF/mapping";
		// uri는 식별자까지, i는 id? identfy? l은 location
//		String uri = request.getRequestURI();
//		StringBuffer url = (StringBuffer) request.getRequestURL();
		String com = request.getRequestURI();

		
//		System.out.println("uri: " + uri);
//		System.out.println("url: " + url);
		 

		// uri에서 식별자만 잘라내기
		// uri는 /mvcTest05/boardList.do 이거고
		// url은 http://localhost:9090/mvcTest05/boardList.do 이거임
		// 맨뒤 기준으로 / 이거부터 . 이거까지 (boardList)만 잘라서 쓰기
//		String com = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		com = com.substring(com.lastIndexOf("/"),com.lastIndexOf("."));
//		System.out.println("com: " + com);
		
		if(com.equals("/boardList")) {
			command = new BoardListCommand();
			command.execute(request, response);
			viewPage += "/boardList.jsp"; //+-로 viewPage선언한 행이랑 이어붙힘(누적)
		}
		else if(com.equals("/boardInput")) {
			command = new BoardInputCommand();
			command.execute(request, response);
			viewPage += "/boardInput.jsp";
		}
		else if(com.equals("/boardUpdate")) {
			command = new BoardUpdateCommand();
			command.execute(request, response);
			viewPage += "/boardUpdate.jsp";
		}
		else if(com.equals("/boardDelete")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			viewPage += "/boardDelete.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
