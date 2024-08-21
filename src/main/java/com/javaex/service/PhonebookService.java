package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;

	/* 전화번호 전체 가져오기 */
	public List<PersonVo> exeGetPerson() {
		
		System.out.println("PhonebookService.exeGetPerson()");

		List<PersonVo> personList = phonebookDao.getPersonList();

		return personList;
	}

	/* 전화번호 등록 */
	public int exeWritePerson(PersonVo personVo) {
		
		System.out.println("PhonebookService.exeWritePerson()");

		int count = phonebookDao.insertPerson(personVo);

		return count;
	}

	/* 전화번호 삭제 */
	public int exePersonDelete(int no) {
		
		System.out.println("PhonebookService.exePersonDelete()");

		int count = phonebookDao.deletePerson(no);

		return count;

	}
	
	/* 전화번호 수정폼 - 사람 정보 불러오기 */
	public PersonVo exePersonEditForm(int no) {
		
		System.out.println("PhonebookService.exePersonEditForm()");

		PersonVo personVo = phonebookDao.getPersonOne(no);

		return personVo;

	}
	
	/* 전화번호 수정 */
	public int exePersonUpdate(PersonVo personVo) {
		
		System.out.println("PhonebookService.exePersonUpdate()");

		int count = phonebookDao.updatePerson(personVo);

		return count;

	}

}
