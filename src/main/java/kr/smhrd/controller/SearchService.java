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

@WebServlet("/SearchService")
public class SearchService extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 0. ���ڵ�
      request.setCharacterEncoding("utf-8");
      
      // 1. �Ķ���� ����
      String data = request.getParameter("data");
      
      // 2. DAO�� �޼��� ���
      BoardDAO dao = new BoardDAO();
      List<BoardVO> list = dao.search("%"+data+"%");
      
      // 3. ����� Json���� ��ȯ 
      Gson gson = new Gson();
      String json = gson.toJson(list);
      
      // 4. ����
      // ���� ���� ���� 
      response.setContentType("text/html; charset=utf-8");
      // out��ü ����
      PrintWriter out = response.getWriter();
      // ����
      out.print(json);
   
   }

}