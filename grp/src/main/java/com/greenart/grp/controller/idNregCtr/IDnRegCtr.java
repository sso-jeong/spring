package com.greenart.grp.controller.idNregCtr;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.BuseoVO;
import com.greenart.grp.model.ComVO;
import com.greenart.grp.model.EmpVO;
import com.greenart.grp.model.GradeVO;
import com.greenart.grp.service.IDnRegSrv.IDnRegSrv;
import com.greenart.grp.service.comSrv.ComSrv;

@Controller
public class IDnRegCtr {
	
	@Autowired
	IDnRegSrv irSrv;
	
	@Autowired
	ComSrv cSrv;
	
	@RequestMapping("")
	public String Main() {
		return "main";
	}

	@RequestMapping(value = "/grp_login", method = RequestMethod.GET)
	public ModelAndView getGrpLogin() {
		ComVO cvo = cSrv.getCompany();
		ModelAndView mav = new ModelAndView();
		mav.addObject("comName", cvo.getComName());
		mav.addObject("comSubName", cvo.getComSubName());
		mav.setViewName("grp_login");
		return mav;
	}
	
	@RequestMapping(value = "/grp_logout", method = RequestMethod.GET)
	public String getGrpLogout(HttpSession session) {
		irSrv.setLogout(session);
		return "redirect:/grp_login";
	}
	
	@RequestMapping(value = "/grp_login", method = RequestMethod.POST)
	public ModelAndView setGrpLogin(@ModelAttribute EmpVO evo, HttpSession session) {
		int result = irSrv.getEmpNumCheck(evo);
		ComVO cvo = cSrv.getCompany();
		int auth = cSrv.getCompany().getComAuth();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comName", cvo.getComName());
		mav.addObject("comSubName", cvo.getComSubName());
		
		String msg;
		if( result > 0 ) {
			EmpVO vo = irSrv.getEmpInfo(evo);
			if( vo.getEmpAuth() >= auth && vo.getEmpConfirm().equals("Y") ) {
				irSrv.setSession(evo, session);
				mav.setViewName("redirect:/grp_admin");
				
			}else if( vo.getEmpAuth() >= auth && vo.getEmpConfirm().equals("Y") ) {
				irSrv.setSession(evo, session);
				mav.setViewName("redirect:/");
				
			}else {
				msg = "접속 권한이 없습니다.\n관리자에게 문의하세요.";
				mav.addObject("msg", msg);
				mav.setViewName("grp_login");
			}
			
		}else {
			msg = "등록된 사번이 아닙니다.";
			mav.addObject("msg", msg);
			mav.setViewName("grp_login");	
		}
		return mav;
	}
	
	@RequestMapping(value = "/grp_register", method = RequestMethod.GET)
	public String getGrpRegister() {
		return "grp_register";
	}
	
	@RequestMapping(value = "/grp_register", method = RequestMethod.POST)
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
		
		irSrv.setEmpRegister(evo);
		return "redirect:/grp_login";
	}
	
	@RequestMapping(value = "/grp_get_buseo", method = RequestMethod.POST)
	@ResponseBody
	public List<BuseoVO> grpGetBuseo() {
		List<BuseoVO> list = irSrv.grpGetBuseo();
		return list;
	}
	
	@RequestMapping(value = "/grp_get_grade", method = RequestMethod.POST)
	@ResponseBody
	public List<GradeVO> grpGetGrade() {
		List<GradeVO> list = irSrv.grpGetGrade();
		return list;
	}
	
	
	
}








