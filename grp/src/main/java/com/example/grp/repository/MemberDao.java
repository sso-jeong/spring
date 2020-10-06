package com.example.grp.repository;

import java.util.List;

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
	
	public List<MemberVO> getMemberList() {
		return sqlSession.selectList("member.getMemberList");
	}
	
	public int idCheck(String memID) {
		return sqlSession.selectOne("member.idCheck", memID);
	}

}
