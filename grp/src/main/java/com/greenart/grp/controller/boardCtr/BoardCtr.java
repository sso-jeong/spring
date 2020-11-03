package com.greenart.grp.controller.boardCtr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.BoardVO;
import com.greenart.grp.service.boardSrv.BoardSrv;

@Controller
@RequestMapping("/board")
public class BoardCtr {
	
	@Autowired
	BoardSrv boardSrv;

	@RequestMapping("")
	public ModelAndView getBoardHome() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", boardSrv.getBoardList());
		mav.setViewName("grp_board/grp_board_main");
		
		return mav;
	}
	
	@RequestMapping("/grp_board_insert")
	@ResponseBody
	public String setBoard(@ModelAttribute BoardVO bvo) {
		boardSrv.setBoard(bvo);
		boardSrv.createArticleTbl(bvo.getBoardCode());
		boardSrv.createCommentTbl(bvo.getBoardCode());
		return "success";
	}
	
	@RequestMapping("/grp_board_check")
	@ResponseBody
	public String setBoardChk(@RequestParam String boardCode) {
		int result = boardSrv.getBoardChk(boardCode);
		
		String msg;
		if( result > 0 )
			msg = "failure";
		else
			msg = "success";
		
		return msg;
	}
	
	@RequestMapping("/grp_board_delete")
	@ResponseBody
	public String setBoardDelete(@RequestParam String boardCode) {
		boardSrv.dropCommentTbl(boardCode);
		boardSrv.dropArticleTbl(boardCode);
		boardSrv.setBoardDelete(boardCode);
		return "success";
	}
}
















