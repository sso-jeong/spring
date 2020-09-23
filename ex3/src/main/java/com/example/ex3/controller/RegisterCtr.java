package com.example.ex3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex3.model.RegisterVO;

@Controller
public class RegisterCtr {

	@RequestMapping("")
	public String getRegister() {
		return "registerView";
	}

	@RequestMapping("/setData")
	@ResponseBody
	public String setData(@ModelAttribute RegisterVO rvo) {
		String dbUserid = "greenart";
		String msg = null;

		if (dbUserid.equals(rvo.getUserid()))
			msg = "NO";
		else
			msg = "Yes";
		return msg;
	}
}
