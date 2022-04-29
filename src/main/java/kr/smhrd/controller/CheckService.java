package kr.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

@WebServlet("/CheckService")
public class CheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 파라미터 수집
		String email = request.getParameter("email");
		
		// 2. DAO 메서드 사용
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.emailCheck(email);
		
		// 3. 결과 응답
		// 응답 형식 지정
		response.setContentType("text/html; charset=utf-8");
		
		// out 객체 생성
		PrintWriter out = response.getWriter();
		
		// 응답
		out.print( vo == null );
		
		
	}

}
