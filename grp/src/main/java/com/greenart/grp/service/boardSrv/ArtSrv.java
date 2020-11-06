package com.greenart.grp.service.boardSrv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenart.grp.model.ArticleVO;
import com.greenart.grp.model.BoardVO;
import com.greenart.grp.repository.boardDao.ArtDao;

@Service
public class ArtSrv {
	
	@Autowired
	ArtDao artDao;
	
	public BoardVO getBoardInfo(String boardCode) {
		return artDao.getBoardInfo(boardCode);
	}
	
	public List<ArticleVO> getArticleList(String boardCode) {
		return artDao.getArticleList(boardCode);
	}

}









