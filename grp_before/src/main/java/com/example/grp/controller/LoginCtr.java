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
public class LoginCtr {
	
	@RequestMapping("/grp_login")
	public String getLogin() {
		return "login/grp_login";
	}

}
