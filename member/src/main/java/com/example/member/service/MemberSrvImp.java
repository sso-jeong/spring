package com.example.member.service;

import java.util.List;

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

}





