package com.example.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.model.MemberVO;
import com.example.member.repository.MemberDao;

@Service
public class MemberSrvImp implements MemberSrv {
	
	@Autowired
	MemberDao memberDao;

	@Override
	public void setRegisterOne(MemberVO mvo) {
		memberDao.setRegisterOne(mvo);
	}

	@Override
	public List<MemberVO> getRegisterAll() {
		return memberDao.getRegisterAll();
	}

	@Override
	public int getCountAll() {
		return memberDao.getCountAll();
	}

	@Override
	public void setRegisterDeleteOne(int id) {
		memberDao.setRegisterDeleteOne(id);
	}

	@Override
	public void setRegisterUpdateOne(MemberVO mvo) {
		memberDao.setRegisterUpdateOne(mvo);
	}

	@Override
	public int idCheck(String userid) {
		return memberDao.idCheck(userid);
	}

	@Override
	public void levelChange(MemberVO mvo) {
		memberDao.levelChange(mvo);
		
	}

	@Override
	public MemberVO getRegisterUpdateOne(int id) {
		return memberDao.getRegisterUpdateOne(id);
	}

	@Override
	public int setLogin(String userid, String passwd) {
		return memberDao.setLogin(userid, passwd);
	}

	@Override
	public MemberVO setSessionLogin(MemberVO mvo, HttpSession session) {
		MemberVO vo = memberDao.setSessionLogin(mvo);
		
		// 세션 생성
		if ( vo != null ) {
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("username", vo.getUsername());
			session.setAttribute("level", vo.getLevel());
		}
		
		return vo;
	}

}





