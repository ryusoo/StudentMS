package com.shs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shs.dto.MemberDTO;
import com.shs.mybatis.SqlMapConfig;

public class MemberDAO {
	// MyBatis 세팅값 호출
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession(); // SqlMapConfig 에 있는 getSqlSession()를 호출함
	
	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
	
	
	
	// Singleton패턴을 활용한 DAO객체 사용
	// : 객체생성은 1회만 동작하고 생성된 객체를 빌려쓰는 형태
	// : + 외부에서는 객체생성이 불가능하게 잠금
	private MemberDAO(){} // : 외부에서 객체생성 못하게 막음
	
	// 외부에서 빌려서 사용할 객체 생성(instance) 
	private static MemberDAO instance = new MemberDAO();
	// 외부에서 getInstance()를 호출하면 객체를 빌려줌
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	
	
	
	int result = 0;
	
	// 학생등록
	// 다른 패키지에 있기 때문에 import해줘야 한다.
	public int memInsert(MemberDTO mDto) {
		
		// mybatis 공장에서 일할 것을 만든다. 이 것이 어떤 DB로 가서 일해야할 지 다 알고있다.
		sqlSession = sqlSessionFactory.openSession(true); //2. commit방법 true써줌 (insert, update, delete만 해주면 됨, auto-commit해줌)
		// sqlSession.commit(); // 1. commit 방법
		
		
		try { // sqlSession (worker)가 insert 일을 하는데 SQL문(memInsert)
			result = sqlSession.insert("memInsert", mDto); // data같이 보냄
			
			if(result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 탄다.
			sqlSession.close(); // 빌려쓰는 애들은 다 닫아서 반납해줘야한다. 자원은 닫아준다. (예, DB,, 스캐너,,_
		}
		
		return result;
	}
	
	// 출석부(회원 전체 출력)
	public List<MemberDTO> memSelect() {
		
		// 일할애(worker)를 만든다. 빌려쓴다고도 한다.
		// worker는 정보를 알고있다. sqlSessionFactory가 mybatis환경설정을 다 알고있다. 그래서 worker도 다 알고있다.
		sqlSession = sqlSessionFactory.openSession(); // true안써도 된다. select문이라서 commit할 필요가 없기 때문이다.
		// worker를 sqlSession의 변수에 담았다.
		
		// 상위인 List로만 가져온다. mybatis에서는 자동으로 List로 바꿔준다. ArrayList, LinkedList는 안된다.
		List<MemberDTO> list = null;
		try {
			
			list = sqlSession.selectList("memSelect"); // 어떤 SQl문을 갈지 설정함. 경로설정. memSelect라고하는 select문을 실행하겠다.
			// 갔다 오면 결과 값이 들어있다.
			// 아래의 for문은 DB에서 값을 제대로 가져왔는지 확인하는 작업이다.
			for (MemberDTO memberDTO : list) { // list에는 DB에서 가져온 값이 다 들어있다.
				System.out.print(memberDTO.getSid()+", ");
				System.out.print(memberDTO.getSname()+", ");
				System.out.print(memberDTO.getSphone());
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려썼기 때문에 반납한다. 자원은 반납을 해주는게 좋다.
		}
		return list;
	}
	
	// 학생정보 출력(1명) - Update페이지 출력시 사용
	public MemberDTO memInfo(int id) {
		sqlSession =sqlSessionFactory.openSession(); // auto commit할 필요없어서 true안쓴다.
		
		MemberDTO mDto = null;
		try {
			mDto = sqlSession.selectOne("memInfo", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return mDto;
	}
	
	// 학생 정보 수정
	public int memUpdate(MemberDTO mDto) {
		
		sqlSession = sqlSessionFactory.openSession(true); // UPDATE니까 auto-commit해줌. true
		
		// DB작업이니까 예외처리해준다
		try {
			
			result = sqlSession.update("memUpdate", mDto); // data같이 보냄
			
				if(result > 0) { // 대체적으로 1이 들어옴
					System.out.println("수정 성공");
				} else { // 0이 들어옴
					System.out.println("수정 실패");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
	
	
	
	// 학생 제적
	public int memDelete(int id) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {			
			result = sqlSession.delete("memDelete", id); // data같이 보냄			
			if(result > 0) { // 대체적으로 1이 들어옴
				System.out.println("삭제 성공");
			} else { // 0이 들어옴
				System.out.println("삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
	
}
