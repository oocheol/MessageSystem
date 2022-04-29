package kr.smhrd.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {

	// Connection pool 만들기
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// Connection pool 설정
			String resource = "kr/smhrd/mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ============================================

	// write method
	public int write(BoardVO bvo) {

		// 1. SqlSession 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql문 사용
		int cnt = 0;

		try {
			cnt = session.insert("write", bvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. 세션 반납
		session.close();

		// 4. 결과값 리턴
		return cnt;

	}

	// selectBoard method
	public List<BoardVO> selectBoard() {
		// 1. SqlSession 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. SQL 사용
		List<BoardVO> list = session.selectList("selectBoard");

		// 3. SQL session 반환
		session.close();

		// 결과 리턴
		return list;

	}

	// selectOne method
	public BoardVO selectOne(int num) {
		// 1. SqlSession 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. SQL 사용
		BoardVO bvo = session.selectOne("selectOne", num);

		// 3. SQL session 반환
		session.close();

		// 결과 리턴
		return bvo;

	}

	// search method
	public List<BoardVO> search(String data) {

		// 1. SqlSession 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. SQL문 사용
		List<BoardVO> list = session.selectList("search", data);

		// 3. SQL session 반환
		session.close();

		// 결과 리턴
		return list;

	}

}
