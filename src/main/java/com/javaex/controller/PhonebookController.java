package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
// @RequestMapping(value="/person")
public class PhonebookController {

	// 필드

	
	@Autowired // @Autowired는 객체 생성을 해준다(메모리에 올린다)
	private PhonebookService phonebookService;
	// 생성자
	// 메소드 gs
	// 메소드 일반

	/* 리스트 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		System.out.println("PhonebookController.list()");

		List<PersonVo> personList = phonebookService.exeGetPerson();
		model.addAttribute("personList", personList);
		
		// return "/WEB-INF/views/list.jsp";
		return "list";
	}

	/* 등록폼 */
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		System.out.println("PhonebookController.writeform()");
		return "writeForm";
	}

	/* 등록 */
	/* Vo로 받을때 */
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {

		System.out.println("PhonebookController.write()");

		// phonebookDao 메소드를 활용해 데이터를 등록한다
		// int count = phonebookDao.insertPerson(personVo);
		// System.out.println(count);
		
		phonebookService.exeWritePerson(personVo);

		// 리스트로 리다이렉트
		// http://localhost:8888/phonebook3/write?name=aaa&hp=123&company=02
		return "redirect:/list";
	}

	/* 수정폼 */
	@RequestMapping(value = "/editform", method = { RequestMethod.GET, RequestMethod.POST })
	public String editForm(@RequestParam(value = "no") int no, Model model) {

		System.out.println("PhonebookController.editform()");

		// 수정할 사람의 정보 가져와서 담기
	    PersonVo personVo = phonebookService.exePersonEditForm(no);

	    // JSP로 데이터 전달
	    model.addAttribute("personVo", personVo);

		return "editForm";
	}

	/* 수정 */
	/* Vo로 받을때 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {

		System.out.println("PhonebookController.update()");

		phonebookService.exePersonUpdate(personVo);

		// 리스트로 리다이렉트
		return "redirect:/list";
	}

	/* 삭제 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		System.out.println("PhonebookController.delete()");

		phonebookService.exePersonDelete(no);

		return "redirect:/list";
	}

	/* 파라미터 1개씩 받을때 */
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value = "name") String name, @RequestParam(value = "hp") String hp,
			@RequestParam(value = "company") String company) {

		System.out.println("PhonebookController.write()");

		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);

		return "write";
	}

}
