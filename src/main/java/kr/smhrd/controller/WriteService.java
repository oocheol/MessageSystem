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

		// 준비물
		// 실제 경로
		// C:\Users\smhrd\Desktop\Web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MessageSystem
		String savePath = request.getServletContext().getRealPath("img");
		int maxSize = 5 * 1024 * 1024; // 5MB
		String encoding = "euc-kr";

		// MultipartRequest 생성
		MultipartRequest multi = new MultipartRequest(request, savePath, // 어디에 저장할지
				maxSize, // 허용 용량
				encoding, // 인코딩 방식
				new DefaultFileRenamePolicy()
		// 중복된 파일이 들어왔을때, 자동으로 이름 변경
		);

		// 파라미터 수집
		// multipart/form-data 형식으로 보냈을 때,
		// 파라미터 수집 도 MultipartRequest로부터 해야한다.
		// multi.getParameter("Name");
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");

		// 파일이름 출력
		// multi.getFilesystemName("Name");
		String fileName = multi.getFilesystemName("file");
		System.out.println(fileName);

		// VO로 묶기
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setWriter(writer);
		bvo.setContent(content);
		bvo.setFileName(fileName);

		// DAO 메서드 사용
		BoardDAO dao = new BoardDAO();
		int cnt = dao.write(bvo);

		// 성공 / 실패
		if (cnt > 0) {
			System.out.println("게시글 작성 성공!!");
			response.sendRedirect("ListService");
		} else {
			System.out.println("게시글 작성 실패!!");
			response.sendRedirect("writerBoard.jsp");
		}

	}

}
