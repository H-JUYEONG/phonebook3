package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자
	// 기본생성자 사용(그래서 생략)

	// 메소드 gs
	// 필드값을 외부에서 사용하면 안됨(그래서 생략)

	// 메소드 일반
	// DB연결 메소드

	/* 전체 가져오기 */
	public List<PersonVo> getPersonList() {
		System.out.println("PhonebookDao.getPersonList()");
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

		return personList;
	}
	
	/* 등록 */
	public int insertPerson(PersonVo personVo) {
		System.out.println("PhonebookDao.insertPerson()");

		int count = sqlSession.insert("phonebook.insert", personVo);
		return count;
	}

	/* 1개 삭제 */
	public int deletePerson(int no) {

		int count = sqlSession.delete("phonebook.delete", no);

		return count;
	}

	/* 수정폼 - 사람 1명 정보 불러오기 */
	public PersonVo getPersonOne(int no) {
		System.out.println("PhonebookDao.getPersonOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);

		return personVo;
	}

	/* 수정 */
	public int updatePerson(PersonVo personVo) {
		System.out.println("PhonebookDao.updatePerson()");

		int count = sqlSession.update("phonebook.update", personVo);
		return count;
	}

	

}
