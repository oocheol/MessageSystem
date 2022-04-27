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

		// 0. ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		// 1. �Ķ���� ����
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		// ���ǿ��� email ��������
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		String email = vo.getEmail();
		
		// vo�� ����
		MemberVO mvo = new MemberVO(email, pw, tel, address);
		
		// 2. DAO �޼��� ���
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(mvo);
		
		if (cnt>0) {
			System.out.println("���� ���� ����");
			// ���� �����
			session.setAttribute("vo", mvo);
			
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("���� ���� ����");
			response.sendRedirect("update.jsp");
		}

	}
}