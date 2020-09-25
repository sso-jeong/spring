package com.example.sample.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginCtr {

	@RequestMapping("/grp_login")
	public String getLogin() {
		return "login/grp_login";
	}

}
