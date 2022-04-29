package kr.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

@WebServlet("/ListService")
public class ListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAO�޼��� ����ؼ� ��� �� ���� ��������
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectBoard();
		
		// ��ü ���ε�
		request.setAttribute("list", list);
		
		// ������ �̵�
		// forward �̵�
		RequestDispatcher rd = request.getRequestDispatcher("boardMain.jsp");
		rd.forward(request, response);
		
		
		
	}
}