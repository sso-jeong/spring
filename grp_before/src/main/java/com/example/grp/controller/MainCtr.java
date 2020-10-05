package com.example.grp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.grp.model.EmpVO;
import com.example.grp.service.EmpSrv;

@Controller
public class MainCtr {

	@Autowired
	EmpSrv empSrv;
	
	@RequestMapping("")
	public String getMain() {
		return "main/main";
	}
	
	@RequestMapping("/grp_main")
	public String getAdmin() {
		return "admin/grp_main";
	}
	
	@RequestMapping("/grp_loginCheck")
	@ResponseBody
	public String loginCheck(@ModelAttribute EmpVO evo, HttpSession session) {
		EmpVO vo = empSrv.loginCheck(evo, session);
		
		String msg;
		if(vo != null) msg ="success";
		else msg="failure";
		return msg;
	}

}
