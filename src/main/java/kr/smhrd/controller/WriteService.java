package kr.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

@WebServlet("/WriteService")
public class WriteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �غ�
		// ���� ���
		// C:\Users\smhrd\Desktop\Web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MessageSystem
		String savePath = request.getServletContext().getRealPath("img");
		int maxSize = 5 * 1024 * 1024; // 5MB
		String encoding = "euc-kr";

		// MultipartRequest ����
		MultipartRequest multi = new MultipartRequest(request, savePath, // ��� ��������
				maxSize, // ��� �뷮
				encoding, // ���ڵ� ���
				new DefaultFileRenamePolicy()
		// �ߺ��� ������ ��������, �ڵ����� �̸� ����
		);

		// �Ķ���� ����
		// multipart/form-data �������� ������ ��,
		// �Ķ���� ���� �� MultipartRequest�κ��� �ؾ��Ѵ�.
		// multi.getParameter("Name");
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");

		// �����̸� ���
		// multi.getFilesystemName("Name");
		String fileName = multi.getFilesystemName("file");
		System.out.println(fileName);

		// VO�� ����
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setWriter(writer);
		bvo.setContent(content);
		bvo.setFileName(fileName);

		// DAO �޼��� ���
		BoardDAO dao = new BoardDAO();
		int cnt = dao.write(bvo);

		// ���� / ����
		if (cnt > 0) {
			System.out.println("�Խñ� �ۼ� ����!!");
			response.sendRedirect("ListService");
		} else {
			System.out.println("�Խñ� �ۼ� ����!!");
			response.sendRedirect("writerBoard.jsp");
		}

	}

}
