package kr.smhrd.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

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

	// join �޼���
	// join �޼���
	public int join(MemberVO vo) {
		// 1. SqlSession ���� ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. Mapper.xml�� ����� SQL���� ����
		int cnt = 0;
		try {
			cnt = session.insert("join", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. ���� ��ȯ
		session.close();

		// 4. ��� ����
		return cnt;
	}

	public MemberVO login(MemberVO vo) {
		// 1. SqlSession ���� ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		MemberVO mvo = session.selectOne("login", vo);
		
		session.close();
		
		return mvo;
		
		
	}
	public int update(MemberVO vo) {
		// 1. SqlSession ���� ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		int cnt = session.update("update", vo);
		
		session.close();
		
		return cnt;
		
		
	}

}
