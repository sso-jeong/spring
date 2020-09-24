package com.example.member.service;

import java.util.List;

import com.example.member.model.MemberVO;

public interface MemberSrv {
	
	public void setRegisterOne(MemberVO mvo);

	public List<MemberVO> getRegisterAll();

	public int getCountAll();

	public void setRegisterDeleteOne(int id);

	public void setRegisterUpdateOne(MemberVO mvo);
	
	public int idCheck(String userid);
}
