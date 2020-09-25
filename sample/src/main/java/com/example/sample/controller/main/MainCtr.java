package com.example.sample.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCtr {

	// localhost/sample/
	@RequestMapping("")
	public String getMain() {
		return "main/main";
	}
}
