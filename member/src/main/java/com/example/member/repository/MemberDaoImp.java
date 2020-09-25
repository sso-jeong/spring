package com.example.member.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.member.model.MemberVO;

@Repository
public class MemberDaoImp implements MemberDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void setRegisterOne(MemberVO mvo) {
		sqlSession.insert("register.setRegisterOne", mvo);
	}

	@Override
	public List<MemberVO> getRegisterAll() {
		return sqlSession.selectList("register.getRegisterAll");
	}

	@Override
	public int getCountAll() {
		return sqlSession.selectOne("register.getCountAll");
	}

	@Override
	public void setRegisterDeleteOne(int id) {
		sqlSession.delete("register.setRegisterDeleteOne", id);
	}

	@Override
	public void setRegisterUpdateOne(MemberVO mvo) {
		sqlSession.update("register.setRegisterUpdateOne", mvo);
	}

	@Override
	public int idCheck(String userid) {
		return sqlSession.selectOne("register.idCheck", userid);
	}

	@Override
	public void levelChange(MemberVO mvo) {
		sqlSession.update("register.levelChange", mvo);
		
	}

}
