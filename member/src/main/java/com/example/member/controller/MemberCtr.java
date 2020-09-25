package com.example.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.member.model.MemberVO;
import com.example.member.service.MemberSrv;

@Controller
public class MemberCtr {

	@Autowired
	MemberSrv memberSrv;

	@RequestMapping("")
	public String getMain() {
		return "main";
	}

	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public ModelAndView getList() {
		// 자료
		List<MemberVO> list = memberSrv.getRegisterAll();
		// html 화면
		//return "member/list";
		// ModelAndView - html화면과 db 2개 동시에 보냄
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberList", list);
		mav.setViewName("member/list");
		
		return mav;
	}

	@RequestMapping(value = "/member/register", method = RequestMethod.GET)
	public String setRegister() {
		return "member/register";
	}

	@RequestMapping(value = "/member/register", method = RequestMethod.POST)
	public String setRegisterDo(@ModelAttribute MemberVO mvo) {
		memberSrv.setRegisterOne(mvo);
		return "redirect:/member/list";
	}

	@RequestMapping(value = "/member/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam String userid) {
		int result = memberSrv.idCheck(userid);
		String msg = null;
		
		if (result > 0)
			msg = "No";
		else
			msg = "Ok";
	
		return msg; // 뒤로가기 문제 해결
	}
	
	@RequestMapping("/member/levelChange")
	@ResponseBody
	// @ModelAttribute 값을 여러개 받을 때 씀
	public String levelChange(@ModelAttribute MemberVO mvo) {
		//System.out.println(mvo);
		memberSrv.levelChange(mvo);
		return "success";
	}
}
