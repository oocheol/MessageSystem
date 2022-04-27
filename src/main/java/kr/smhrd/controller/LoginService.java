package kr.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 파라미터 수집
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		// vo로 묶기
		MemberVO vo = new MemberVO(email, pw);
		
		// 2. DAO 메서드 사용
		MemberDAO dao = new MemberDAO();
		MemberVO mvo = dao.login(vo);
		
		// 3. 로그인 성공, 실패 판단
		if(mvo==null) {
			// 실패
			System.out.println("로그인 실패!!");
		} else {
			// 성공
			System.out.println("로그인 성공!!");
		}
		
		// 4. main.jsp로 이동
	
	}

}
