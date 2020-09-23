package com.example.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

	@RequestMapping("/ajaxTest")
	public String getAjaxTest() {
		return "test";
	}

//	@RequestMapping("/setData") // ajax 주소
//	@ResponseBody // ajax 실행 시 필요한 것, @ResponseBody -> 자바코드를 텍스트로 변환
//	public void setData(@ModelAttribute Login login) {
//		System.out.println(login);
//	}

	@RequestMapping("/setData") // ajax 주소
	@ResponseBody // ajax 실행 시 필요한 것, @ResponseBody -> 자바코드를 텍스트로 변환
	public String setData(@ModelAttribute Login login) {
		return login.getUserid() + "|" + login.getPasswd();
	}
}