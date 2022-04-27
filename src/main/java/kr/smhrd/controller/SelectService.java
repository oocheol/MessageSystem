package kr.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.MemberDAO;
import kr.smhrd.model.MemberVO;

@WebServlet("/SelectService")
public class SelectService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAO���� ������ ������
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.select();

		// request scope�� ������ ����

		request.setAttribute("list", list);

		// forward ������� �̵�
		// url ��ΰ� �ٲ��� �ʴ´�.
		// ���� ����(������Ʈ �� ����)�θ� �̵� �����ϴ�.
		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);

	}
}
