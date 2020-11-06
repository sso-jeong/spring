package com.greenart.grp.controller.boardCtr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.BoardVO;
import com.greenart.grp.service.boardSrv.ArtSrv;

@Controller
@RequestMapping("/article")
public class ArticleCtr {

	@Autowired
	ArtSrv artSrv;
	
	@RequestMapping("grp_article_list")
	public ModelAndView getArticleList(@RequestParam String boardCode) {
		
		ModelAndView mav = new ModelAndView();
		BoardVO info = artSrv.getBoardInfo(boardCode);
		
		mav.addObject("boardCode", boardCode);
		mav.addObject("boardTitle", info.getBoardTitle());
		mav.addObject("boardColor", info.getBoardColor());
		mav.addObject("list", artSrv.getArticleList(boardCode));
		mav.setViewName("grp_board/grp_article_list");
		return mav;
	}
	
	@RequestMapping(value="grp_article_insert", method=RequestMethod.GET)
	public ModelAndView getArticleInsert(@RequestParam String boardCode) {
		ModelAndView mav = new ModelAndView();
		BoardVO info = artSrv.getBoardInfo(boardCode);
		
		mav.addObject("boardCode", boardCode);
		mav.addObject("boardTitle", info.getBoardTitle());
		mav.addObject("boardColor", info.getBoardColor());
		mav.setViewName("grp_board/grp_article_insert");
		
		return mav;
	}
	
	@RequestMapping(value="grp_article_insert", method=RequestMethod.POST)
	public void setArticleInsert() {
		
	}
	
}













