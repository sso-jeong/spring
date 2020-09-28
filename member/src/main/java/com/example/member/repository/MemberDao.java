package com.example.member.repository;

import java.util.List;

import com.example.member.model.MemberVO;

public interface MemberDao {
	
	public void setRegisterOne(MemberVO mvo);
	
	public List<MemberVO> getRegisterAll();
	
	public int getCountAll();
	
	public void setRegisterDeleteOne(int id);
	
	public void setRegisterUpdateOne(MemberVO mvo);
	
	public int idCheck(String userid);
	
	public void levelChange(MemberVO mvo);
	
	public MemberVO getRegisterUpdateOne(int id);
	
	public int setLogin(String userid, String passwd);
	
	public MemberVO setSessionLogin(MemberVO mvo);
}






