package com.example.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		List<MemberVO> list = memberSrv.getRegisterAll();
		
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
		
		if( result > 0 ) msg = "No";
		else msg = "Ok";
		
		return msg;
	}
	
	@RequestMapping("/member/levelChange")
	@ResponseBody
	public String levelChange(@ModelAttribute MemberVO mvo) {
		memberSrv.levelChange(mvo);
		return "success";
	}
	
	@RequestMapping("/member/delete")
	@ResponseBody
	public String setRegisterDeleteOne(@RequestParam int mid) {
		memberSrv.setRegisterDeleteOne(mid);
		return "success";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public ModelAndView getRegisterUpdate(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		MemberVO mvo = memberSrv.getRegisterUpdateOne(id);
		
		mav.addObject("update", mvo);
		mav.setViewName("member/update");
		
		return mav;
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String setRegisterUpdate(@ModelAttribute MemberVO mvo) {
		memberSrv.setRegisterUpdateOne(mvo);
		System.out.println(mvo);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	@ResponseBody
	public String setLogin(@RequestParam String userid, @RequestParam String passwd) {
		int result = memberSrv.setLogin(userid, passwd);
		String msg = null;
		if( result > 0 ) msg = "success";
		else msg = "failure";
		
		return msg;
	}
	
	
	@RequestMapping(value = "/member/sessionLogin", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView setSessionLogin(@ModelAttribute MemberVO mvo, HttpSession session) {
		MemberVO vo = memberSrv.setSessionLogin(mvo, session);
		ModelAndView mav = new ModelAndView();
		if( vo != null ) {
			mav.setViewName("redirect:/"); //메인 페이지로 이동
			
		}else {
			mav.addObject("msg", "아이디/비밀번호를 확인하세요.");
			mav.setViewName("/member/login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.POST)
	@ResponseBody
	public String logout(HttpSession session) {
		memberSrv.logout(session);
		return "success";
	}
	
}















