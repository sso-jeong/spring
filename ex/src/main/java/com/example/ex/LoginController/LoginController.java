package com.example.ex.LoginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex.model.LoginVO;

@Controller
public class LoginController {

	@RequestMapping("/login") /* get, post 없는 방식 */
	public String getLoginForm() {
		return "login/loginForm";
	}
	// @RequestMapping(value = "/login", get) /* get 쓰는 방식 */
	// @RequestMapping(value = "/login", post) /* post 쓰는 방식 */

//  디버깅용

	// 1. 기본적인 방법
//	@RequestMapping("/loginDo")
//	// 로그인 버튼 눌렀을 때 아이디, 비밀번호 받는 것 jsp에서 name을 받음
//	public void getLoginDo(@RequestParam String userid, @RequestParam String passwd) {
//		System.out.println(userid);
//		System.out.println(passwd);
//	}
//	
	// 2. 객체지향언어적으로 get으로 데이터를 가져오는 방법
//	@RequestMapping("/loginDo")
//	public void getLoginDo(@ModelAttribute LoginVO lvo) {
//		System.out.println(lvo.getUserid());
//		System.out.println(lvo.getPasswd());
//	}

	// 3. 다른 화면으로 보여주는 방법
//	@RequestMapping("/loginDo")
//	public String getLoginDo(@ModelAttribute LoginVO lvo) {
//		return "main";
//		
//	}

	// 4. 화면에 입력한 값까지 보여줌
	@RequestMapping(value = "/loginDo", method = RequestMethod.POST)
	public ModelAndView getLoginDo(@ModelAttribute LoginVO lvo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid", lvo.getUserid());
		mav.addObject("passwd", lvo.getPasswd());

		mav.setViewName("main");

		return mav; // mav 배열을 넘겨줘야함
	}

}
