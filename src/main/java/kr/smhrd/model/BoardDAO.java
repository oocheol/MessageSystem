package kr.smhrd.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {

	// Connection pool �����
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// Connection pool ����
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

		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ���
		int cnt = 0;

		try {
			cnt = session.insert("write", bvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. ���� �ݳ�
		session.close();

		// 4. ����� ����
		return cnt;

	}

	// selectBoard method
	public List<BoardVO> selectBoard() {
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. SQL ���
		List<BoardVO> list = session.selectList("selectBoard");

		// 3. SQL session ��ȯ
		session.close();

		// ��� ����
		return list;

	}

	// selectOne method
	public BoardVO selectOne(int num) {
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. SQL ���
		BoardVO bvo = session.selectOne("selectOne", num);

		// 3. SQL session ��ȯ
		session.close();

		// ��� ����
		return bvo;

	}

	// search method
	public List<BoardVO> search(String data) {

		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. SQL�� ���
		List<BoardVO> list = session.selectList("search", data);

		// 3. SQL session ��ȯ
		session.close();

		// ��� ����
		return list;

	}

}
