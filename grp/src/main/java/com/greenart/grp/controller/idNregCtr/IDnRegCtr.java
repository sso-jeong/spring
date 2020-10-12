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
	ComSrv comSrv;

	@RequestMapping("")
	public String Main() {
		return "main";
	}

	@RequestMapping(value = "/grp_login", method = RequestMethod.GET)
	public ModelAndView getgrpLogin() {
		
		ComVO cvo = comSrv.getCompany();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comName", cvo.getComName());
		mav.addObject("comSubName", cvo.getComSubName());
		mav.setViewName("grp_login");
		
		return mav;
	}
	
	@RequestMapping(value = "/grp_logout", method = RequestMethod.GET)
	public String getgrpLogout(HttpSession session) {
		irSrv.setLogout(session);
		return "redirect:/grp_login";
	}

	@RequestMapping(value = "/grp_login", method = RequestMethod.POST)
	public ModelAndView setgrpLogin(@ModelAttribute EmpVO evo, HttpSession session) {
		int resnum = irSrv.getEmpNumCheck(evo);
		ComVO cvo = comSrv.getCompany();
		int auth = comSrv.getCompany().getComAuth();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comName", cvo.getComName());
		mav.addObject("comSubName", cvo.getComSubName());
		
		if (resnum > 0) {
			EmpVO vo = irSrv.getEmpInfo(evo);
			if (vo.getEmpAuth() >= 10 && vo.getEmpConfirm().equals("Y")) {
				irSrv.setSession(evo, session);
				mav.setViewName("redirect:/grp_admin");
			} else if (vo.getEmpAuth() >= auth && vo.getEmpConfirm().equals("Y")) {
				irSrv.setSession(evo, session);
				mav.setViewName("redirect:/");
			} else {
				mav.addObject("msg", "접속 권한이 없습니다.\n 관리자에게 문의하세요.");
				mav.setViewName("grp_login");
			}
		} else {
			mav.addObject("msg", "사번과 비밀번호를 확인해주세요.");
			mav.setViewName("grp_login");
		}
		
		return mav;
	}

	@RequestMapping(value = "/grp_register", method = RequestMethod.GET)
	public String getgrpRegister() {
		return "grp_register";
	}

	@RequestMapping(value = "/grp_register", method = RequestMethod.POST)
	public String setgrpRegister(@ModelAttribute EmpVO evo) {

		/* 사원번호 만들기(입사년 + 부서코드 + 직급코드 + PK) */
		int enter = Integer.parseInt(evo.getEmpEnter().substring(0, 4));
		String buseo = evo.getEmpBuseoCode();
		String grade = evo.getEmpGradeCode();
		String eNum = enter + buseo + grade;
		evo.setEmpNum(eNum);
		/**/

		/* 호봉 : empStep(현재년도 - 입사년도) */
		Calendar cal = Calendar.getInstance();
		int now = cal.get(Calendar.YEAR);
		int eStep = (now - enter) + 1;
		evo.setEmpStep(eStep);
		/**/

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
