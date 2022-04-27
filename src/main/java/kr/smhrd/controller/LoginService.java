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
		
		// 1. �Ķ���� ����
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		// vo�� ����
		MemberVO vo = new MemberVO(email, pw);
		
		// 2. DAO �޼��� ���
		MemberDAO dao = new MemberDAO();
		MemberVO mvo = dao.login(vo);
		
		// 3. �α��� ����, ���� �Ǵ�
		if(mvo==null) {
			// ����
			System.out.println("�α��� ����!!");
		} else {
			// ����
			System.out.println("�α��� ����!!");
		}
		
		// 4. main.jsp�� �̵�
	
	}

}
