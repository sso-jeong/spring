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
	
	public List<MemberVO> getMemberList(String searchOpt, String words){
		return memberDao.getMemberList(searchOpt, words);
	}
	
	public int getMemberCount(String searchOpt, String words){
		return memberDao.getMemberCount(searchOpt, words);
	}
	
	public void setMemConfirm(MemberVO mvo) {
		memberDao.setMemConfirm(mvo);
	}
	
	public void setMemLevel(MemberVO mvo) {
		memberDao.setMemLevel(mvo);
	}
	
	public int idCheck(String memID) {
		return memberDao.idCheck(memID);
	}
	
	

}
