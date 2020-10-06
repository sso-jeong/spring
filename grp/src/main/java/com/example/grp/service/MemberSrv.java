package com.example.grp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grp.model.MemberVO;
import com.example.grp.repository.MemberDao;

@Service
public class MemberSrv {
	
	@Autowired
	MemberDao memberDao;
	
	public void setMember(MemberVO mvo) {
		memberDao.setMember(mvo);
	}
	
	public List<MemberVO> getMemberList(){
		return memberDao.getMemberList();
	}
	
	public int idCheck(String memID) {
		return memberDao.idCheck(memID);
	}
	
	

}
