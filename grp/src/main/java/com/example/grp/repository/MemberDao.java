package com.example.grp.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.grp.model.MemberVO;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public void setMember(MemberVO mvo) {
		sqlSession.insert("member.setMember", mvo);
	}
	
	public List<MemberVO> getMemberList(String searchOpt, String words) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOpt", searchOpt);
		map.put("words", words);
		
		return sqlSession.selectList("member.getMemberList", map);
	}
	
	public int getMemberCount(String searchOpt, String words) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOpt", searchOpt);
		map.put("words", words);
		
		return sqlSession.selectOne("member.getMemberCount", map);
	}
	
	public void setMemConfirm(MemberVO mvo) {
		sqlSession.update("member.setMemConfirm", mvo);
	}
	
	public void setMemLevel(MemberVO mvo) {
		sqlSession.update("member.setMemLevel", mvo);
	}
	
	public int idCheck(String memID) {
		return sqlSession.selectOne("member.idCheck", memID);
	}

}
