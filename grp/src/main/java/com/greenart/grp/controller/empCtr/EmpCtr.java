package com.greenart.grp.controller.empCtr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.EmpVO;
import com.greenart.grp.service.empSrv.EmpSrv;

@Controller
@RequestMapping("/employee")
public class EmpCtr {
	
	@Autowired
	EmpSrv eSrv;

	@RequestMapping(value = "/grp_employee_list")
	public ModelAndView empList(@RequestParam(defaultValue = "emp_name") String searchOpt, @RequestParam(defaultValue = "") String words) {
		ModelAndView mav = new ModelAndView();
		
		List<EmpVO> list = eSrv.getEmpList(searchOpt, words);
		int count = eSrv.getEmpCount();
		
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("searchOpt", searchOpt);
		mav.addObject("words", words);
		mav.setViewName("grp_employee/grp_employee_list");
		return mav;
	}
	
	@RequestMapping(value ="/grp_employee_delete", method = RequestMethod.POST)
	@ResponseBody
	public String grpEmpDelete(@RequestParam int eid) {
		eSrv.setEmpDelete(eid);
		return "success";
	}
	
	@RequestMapping(value ="/grp_employee_head_change", method = RequestMethod.POST)
	@ResponseBody
	public String setEmpHeadChange(@RequestParam String empHead, @RequestParam int empID) {
		eSrv.setEmpHeadChange(empHead, empID);
		return "success";
	}
	
	
	@RequestMapping(value ="/grp_employee_confirm_change", method = RequestMethod.POST)
	@ResponseBody
	public String setEmpConfirmChange(@RequestParam String empConfirm, @RequestParam int empID) {
		eSrv.setEmpConfirmChange(empConfirm, empID);
		return "success";
	}
	
	
	@RequestMapping(value ="/grp_employee_auth_change", method = RequestMethod.POST)
	@ResponseBody
	public String setEmpAuthChange(@RequestParam String empAuth, @RequestParam int empID) {
		eSrv.setEmpAuthChange(empAuth, empID);
		return "success";
	}
	
	
}









