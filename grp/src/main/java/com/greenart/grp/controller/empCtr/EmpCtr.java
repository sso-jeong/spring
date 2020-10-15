package com.greenart.grp.controller.empCtr;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.EmpVO;
import com.greenart.grp.service.IDnRegSrv.IDnRegSrv;
import com.greenart.grp.service.empSrv.EmpSrv;

@Controller
@RequestMapping("/employee")
public class EmpCtr {
	
	@Autowired
	EmpSrv eSrv;
	
	@Autowired
	IDnRegSrv irSrv;
	
	@Resource(name="uploadPath")
	private String uploadPath;

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
	
	@RequestMapping(value = "grp_employee_register", method = RequestMethod.GET)
	public ModelAndView grpEmpReg(HttpSession session) {
		//System.out.println(session.getAttribute("empNum"));
		String sessionNum = (String) session.getAttribute("empNum");
		
		EmpVO evo = eSrv.getEmpOne(sessionNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("empOne", evo);
		mav.setViewName("grp_employee/grp_employee_register");
		
		return mav;
	}
	
	@RequestMapping(value = "/grp_register", method = RequestMethod.GET)
	public String getGrpRegister() {
		return "grp_register";
	}
	
	@RequestMapping(value = "/grp_admin_register", method = RequestMethod.POST)
	public String setGrpRegister(@ModelAttribute EmpVO evo) {
		int enterYear 	= Integer.parseInt(evo.getEmpEnter().substring(0, 4));
		String bCode 	= evo.getEmpBuseoCode();
		String gCode	= evo.getEmpGradeCode();
		
		String eNum		= enterYear + bCode + gCode;
		evo.setEmpNum(eNum);
		System.out.println(evo.getEmpNum());
		
		Calendar cal = Calendar.getInstance();
		int hYear = cal.get(Calendar.YEAR);
		int eStep = (hYear - enterYear) + 1;
		evo.setEmpStep(eStep);
		
		/* 선택 사원 정보 입력 */
		eSrv.setEmpRegOthers(evo);
		/* 선택 사원 정보 입력 */
		
		/* 파일 업로드*/
		/* 파일 업로드*/
		
		return "redirect:/employee/grp_employee_list";
	}
	
	
}









