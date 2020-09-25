package com.example.sample.controller.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sample.model.GradeVO;
import com.example.sample.service.GradeSrv;

@Controller
public class RegisterCtr {
	
	@Autowired
	GradeSrv gradeSrv;

	@RequestMapping("/register/grp_register")
	public String getRegister() {
		return "register/grp_register";
	}

	@RequestMapping("/register/grp_grade")
	@ResponseBody
	public List<GradeVO> getGrade() {
		//List<GradeVO> list= gradeSrv.getGradeList();
		return gradeSrv.getGradeList();
	}
}
