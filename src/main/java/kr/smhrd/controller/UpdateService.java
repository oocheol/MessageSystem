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

		// 1. 파라미터 수집
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		// vo로 묶기
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		MemberVO mvo = new MemberVO(vo.getEmail(), pw, tel, address);
		

		// 2. DAO 메서드 사용
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(mvo);
		
		if (cnt>0) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("update.jsp");
		}

	}
}