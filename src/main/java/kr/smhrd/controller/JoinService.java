package kr.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 0. 인코딩
		request.setCharacterEncoding("euc-kr");

		// 1. 파라미터 수집
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		// VO로 묶기
		MemberVO vo = new MemberVO(email, pw, tel, address);

		// 2. DAO메서드 사용
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);

		// 3. 회원가입 성공, 실패 판단
		if (cnt > 0) {
			// 3.5. 페이지 이동
			// 성공 -> join_success.jsp
			// 쿼리 스트링
			// url?name=value&...
			// join_success.jsp?name=value...
			response.sendRedirect("join_success.jsp?email=" + vo.getEmail());

		} else {
			// 실패 -> main.jsp
			response.sendRedirect("main.jsp");

		}

	}

}