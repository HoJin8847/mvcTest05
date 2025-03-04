package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

@WebServlet({ "/boardInput", "/bi" }) //두개 중 아무거나로 들어와도 수행할게. 두개 이상은 중괄호.
public class BoardInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//service가 doGet이나 doPost 보다 무조건 제일 먼저 실행
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String viewPage = "/boardTest/boardInput.jsp"; // 첫번째 슬래쉬는 wepapp을 뜻함
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		dispatcher.forward(request, response);
//	}
	
	//실무에서 doGet과 doPost는 필요시에만 쓴다고 보면 됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/boardTest/boardInput.jsp"; // 첫번째 슬래쉬는 wepapp을 뜻함
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		String title = request.getParameter("title") == null ? "" : request.getParameter("name");
		String content = request.getParameter("content") == null ? "" : request.getParameter("name");
		//String hostIp = request.getParameter("hostIp");
		String hostIp = request.getRemoteAddr();
		
		BoardVo vo = new BoardVo();
//		vo.setName(request.getParameter("name") == null ? "" : request.getParameter("name"));
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setHostIP(hostIp);
		
		BoardDao dao = new BoardDao();
		int res = dao.setBoardInput(vo);
		
		PrintWriter out = response.getWriter(); 
		if(res !=0 ) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='boardList';");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('게시글이 등록실패.')");
			out.println("location.href='boardInput';");
			out.println("</script>");
		}
	}

}
