package com.greenart.grp.controller.adminCtr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grp_admin")
public class AdminCtr {

	@RequestMapping("") //localhost:5678/grp/grp_admin -> 관리자 로그인
	public String grpAdmin() {
		return "grp_admin/grp_admin_main";
	}	
}






