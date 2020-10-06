package com.example.grp.controller;

import java.util.List;

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
	
	@RequestMapping("") // 서버 실행 시 첫 화면
	public String getMain() {
		return "main";
	}
	
//	@RequestMapping("/memberList")
//	public String getMemberList() {
//		return "memberList";
//	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	//jsp를 화면에 출력
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
		return "register";
	}
	
	//디비에 저장
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String setRegister(@ModelAttribute MemberVO mvo) {
		memberSrv.setMember(mvo);
		return "redirect:/memberList";
	}
	
	@RequestMapping("/memberList") // 회원목록
	public ModelAndView getMemberList() {
		List<MemberVO> list = memberSrv.getMemberList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("memberList");
		
		return mav;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam String memID) {
		int result = memberSrv.idCheck(memID);
		String msg = null;
		
		if (result > 0)
			msg = "No";
		else
			msg = "Ok";
		return msg;
		
	}
	

}