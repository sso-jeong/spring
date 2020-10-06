package com.example.grp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {
	private int memNum;
	private String memID;
	private String memPwd;
	private String memName;
	private String memEmail;
	private Date memRegdate;
	private String memLevel;
	private String memConfirm;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemRegdate() {
		return sdf.format(memRegdate);
	}
	public void setMemRegdate(Date memRegdate) {
		this.memRegdate = memRegdate;
	}
	public String getMemLevel() {
		return memLevel;
	}
	public void setMemLevel(String memLevel) {
		this.memLevel = memLevel;
	}
	public String getMemConfirm() {
		return memConfirm;
	}
	public void setMemConfirm(String memConfirm) {
		this.memConfirm = memConfirm;
	}
	
	

}
