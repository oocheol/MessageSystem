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

		// 0. ���ڵ�
		request.setCharacterEncoding("euc-kr");

		// 1. �Ķ���� ����
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		// VO�� ����
		MemberVO vo = new MemberVO(email, pw, tel, address);

		// 2. DAO�޼��� ���
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);

		// 3. ȸ������ ����, ���� �Ǵ�
		if (cnt > 0) {
			// 3.5. ������ �̵�
			// ���� -> join_success.jsp
			// ���� ��Ʈ��
			// url?name=value&...
			// join_success.jsp?name=value...
			response.sendRedirect("join_success.jsp?email=" + vo.getEmail());

		} else {
			// ���� -> main.jsp
			response.sendRedirect("main.jsp");

		}

	}

}