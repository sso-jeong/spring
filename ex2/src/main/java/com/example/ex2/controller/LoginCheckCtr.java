package com.example.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex2.model.LoginVO;

@Controller
public class LoginCheckCtr {

	//("")안에 없으면 실행시 바로 뜸 
	@RequestMapping("/getView")
	public String getView() {
		return "getView";
	}

	@RequestMapping("/checkData")
	@ResponseBody
	public String checkData(@ModelAttribute LoginVO vo) {
		String dbUserid = "greenart";
		String dbPwd = "1234";
		String msg = null;

		if (vo.getUserid().equals(dbUserid)) {
			msg = "NO";
		} else {
			msg = "YES";
		}

		return msg;
	}

}
