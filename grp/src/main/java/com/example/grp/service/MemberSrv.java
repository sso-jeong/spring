package com.example.grp.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	public List<MemberVO> getMemberList(String searchOpt, String words) {
		return memberDao.getMemberList(searchOpt, words);
	}
	
	public int getMemberCount(String searchOpt, String words) {
		return memberDao.getMemberCount(searchOpt, words);
	}
	
	public void memConfirm(MemberVO mvo) {
		memberDao.memConfirm(mvo);
	}
	
	public int checkID(String checkID) {
		return memberDao.checkID(checkID);
	}
	
	public MemberVO checkLogin(MemberVO mvo, HttpSession session) {
		//System.out.println("srv"+mvo);
		MemberVO vo = memberDao.checkLogin(mvo);
		
		session.setAttribute("memID", vo.getMemID());
		session.setAttribute("memName", vo.getMemName());
		session.setAttribute("memLevel", vo.getMemLevel());
		session.setAttribute("memConfirm", vo.getMemConfirm());
		
		return vo;
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}
}









