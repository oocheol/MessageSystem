package kr.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;
import kr.smhrd.model.MemberDAO;

@WebServlet("/ViewService")
public class ViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. �Ķ���� ����
		int num = Integer.parseInt(request.getParameter("num"));

		// 2. DAO �޼��� ���
		BoardDAO dao = new BoardDAO();
		BoardVO bvo = dao.selectOne(num);
		
		// 3. ��ü ���ε�
		request.setAttribute("bvo", bvo);
		
		// 4. ������ �̵�
		RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
		rd.forward(request, response);

	}

}
