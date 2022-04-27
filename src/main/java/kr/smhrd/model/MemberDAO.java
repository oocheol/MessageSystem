package kr.smhrd.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

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

	// join 메서드
	public int join(MemberVO vo) {
		// 1. SqlSession 세션 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. Mapper.xml에 적어둔 SQL문장 실행
		int cnt = 0;
		try {
			cnt = session.insert("join", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. 세션 반환
		session.close();

		// 4. 결과 리턴
		return cnt;
	}

	// login method
	public MemberVO login(MemberVO vo) {
		// 1. SqlSession 세션 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		MemberVO mvo = session.selectOne("login", vo);
		
		session.close();
		
		return mvo;
		
		
	}
	
	// update method
	public int update(MemberVO vo) {
		// 1. SqlSession 세션 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);

		int cnt = 0;
		try {
			cnt = session.update("update", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return cnt;
		
		
	}

}
