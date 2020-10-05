package com.example.grp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.grp.model.BuseoVO;
import com.example.grp.model.EmpVO;
import com.example.grp.model.GradeVO;
import com.example.grp.service.BuseoSrv;
import com.example.grp.service.EmpSrv;
import com.example.grp.service.GradeSrv;

@Controller
public class RegisterCtr {
	
	@Autowired
	BuseoSrv buseoSrv;
	
	@Autowired
	GradeSrv gradeSrv;
	
	@Autowired
	EmpSrv empSrv;
	
	@RequestMapping(value = "/grp_register", method = RequestMethod.GET)
	public String getRegister() {
		return "register/grp_register";
	}
	
	@RequestMapping(value = "/grp_register", method = RequestMethod.POST)
	@ResponseBody
	public String setRegister(@ModelAttribute EmpVO evo) {
		System.out.println(evo);
		empSrv.setEmployeeOne(evo);
		return "success";
	}
	
	@RequestMapping("/getBuseoList")
	@ResponseBody
	public List<BuseoVO> getBuseoList() {
		List<BuseoVO> list = buseoSrv.getBuseoList();
		return list;
	}
	
	@RequestMapping("/getGradeList")
	@ResponseBody
	public List<GradeVO> getGradeList(){
		List<GradeVO> list = gradeSrv.getGradeList();
		return list;
	}

}
