package com.greenart.grp.controller.boardCtr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardCtr {
	
	@RequestMapping("")
	public String getBoardHome() {
		return "grp_board/grp_board_main";
	}

}
