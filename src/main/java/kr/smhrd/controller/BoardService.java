package kr.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

@WebServlet("/BoardService")
public class BoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAO 메서드 사용
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectBoard();

		// Gson 이용 List --> Json
		Gson gson = new Gson();
		String json = gson.toJson(list);

		// 응답 형식 지정
		response.setContentType("text/html; charset=utf-8");

		// out객체
		PrintWriter out = response.getWriter();

		// 응답
		out.print(json);

	}

}
