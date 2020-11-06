package com.greenart.grp.repository.boardDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenart.grp.model.ArticleVO;
import com.greenart.grp.model.BoardVO;

@Repository
public class ArtDao {

	@Autowired
	SqlSession sql;
	
	public BoardVO getBoardInfo(String boardCode) {
		return sql.selectOne("article.getBoardInfo", boardCode);
	}
	
	public List<ArticleVO> getArticleList(String boardCode) {
		return sql.selectList("article.getArticleList", boardCode);
	}
	
}







