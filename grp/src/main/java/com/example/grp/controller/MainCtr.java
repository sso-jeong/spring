package com.example.grp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.grp.model.MemberVO;
import com.example.grp.service.MemberSrv;

@Controller
public class MainCtr {
	
	@Autowired
	MemberSrv memberSrv;

	@RequestMapping("") //서버 실행시 첫 화면
	public String getMain() {
		return "main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String setLogin(@ModelAttribute MemberVO mvo, HttpSession session) {
		MemberVO vo = memberSrv.checkLogin(mvo, session);
		
		String msg;
		if( vo != null ) {
			msg = "success";
		
		}else {
			msg = "failure";
		}
		return msg;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		memberSrv.logout(session);
		return "main";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
		//jsp를 화면에 출력
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getRegisterDo(@ModelAttribute MemberVO mvo) {
		memberSrv.setMember(mvo);
		return "redirect:/login";
	}
	
	@RequestMapping("/memberList") //회원목록
	public ModelAndView getMemberList(
			@RequestParam(defaultValue = "mem_name") String searchOpt,
			@RequestParam(defaultValue = "") String words) {
		
		int count = memberSrv.getMemberCount(searchOpt, words);
		List<MemberVO> list = memberSrv.getMemberList(searchOpt, words);

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchOpt", searchOpt);
		mav.addObject("words", words);
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.setViewName("memberList");
		
		return mav;
	}
	
	@RequestMapping(value = "/memConfirm", method = RequestMethod.POST)
	@ResponseBody
	public String memConfirm(@ModelAttribute MemberVO mvo) {
		memberSrv.memConfirm(mvo);
		return "success";
	}
	
	@RequestMapping(value = "/checkID", method = RequestMethod.POST)
	@ResponseBody
	public String checkID(@RequestParam String memID) {
		int result = memberSrv.checkID(memID);
		String msg;
		if( result > 0 ) {
			msg = "No";
			
		}else {
			msg = "Yes";
		}
		return msg;
	}
}























