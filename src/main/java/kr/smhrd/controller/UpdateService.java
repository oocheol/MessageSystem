package kr.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 0. 인코딩
		request.setCharacterEncoding("euc-kr");
		
		// 1. 파라미터 수집
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		// 세션에서 email 가져오기
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		String email = vo.getEmail();
		
		// vo로 묶기
		MemberVO mvo = new MemberVO(email, pw, tel, address);
		
		// 2. DAO 메서드 사용
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(mvo);
		
		if (cnt>0) {
			System.out.println("정보 수정 성공");
			// 세션 덮어쓰기
			session.setAttribute("vo", mvo);
			
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("정보 수정 실패");
			response.sendRedirect("update.jsp");
		}

	}
}