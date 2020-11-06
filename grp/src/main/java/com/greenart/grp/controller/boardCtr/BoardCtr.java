package com.greenart.grp.controller.boardCtr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.BoardVO;
import com.greenart.grp.paging.Pager;
import com.greenart.grp.service.boardSrv.BoardSrv;

@Controller
@RequestMapping("/board")
public class BoardCtr {
	
	@Autowired
	BoardSrv boardSrv;

	@RequestMapping("")
	public ModelAndView getBoardHome(@RequestParam(defaultValue = "1") int curPage) {
		
		ModelAndView mav = new ModelAndView();
		int count = boardSrv.getBoardCount();
		/***********************시작***********************/
		Pager pager = new Pager(count, curPage);
		int start 	= pager.getPageBegin();
		int end 	= pager.getPageEnd();
		/****************************************************/
		
		mav.addObject("count", count);
		mav.addObject("list", boardSrv.getBoardList(start, end));
		
		/***********************시작***********************/
		mav.addObject("start", start); //게시물 개수 자를 시작번호
		mav.addObject("end", end); //게시물 자를 끝 번호
		
		mav.addObject("blockBegin", pager.getBlockBegin());
		mav.addObject("blockEnd", pager.getBlockEnd());
		mav.addObject("curBlock", pager.getCurBlock());
		mav.addObject("totalBlock", pager.getTotBlock());
		
		mav.addObject("prevPage", pager.getPrevPage());
		mav.addObject("nextPage", pager.getNextPage());
		mav.addObject("curPage", pager.getCurPage());
		mav.addObject("totalPage", pager.getTotPage());
		
		//페이지 번호를 클릭했을 때 css active 클래스 처리
		mav.addObject("selected", pager.getCurPage());
		/****************************************************/
		
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
	
	@RequestMapping(value = "/grp_board_delete_all", method = RequestMethod.POST)
	@ResponseBody
	public String setBoardDeleteAll(@RequestParam(value = "chkArr[]") List<String> chkArr) {
		for(String boardCode : chkArr ) {
			boardSrv.dropCommentTbl(boardCode);
			boardSrv.dropArticleTbl(boardCode);
			boardSrv.setBoardDelete(boardCode);
		}
		return "success";		
	}
}
















