package com.example.grp.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grp.model.EmpVO;
import com.example.grp.repository.EmpDao;

@Service
public class EmpSrv {
	
	@Autowired
	EmpDao empDao;
	
	public void setEmployeeOne(EmpVO evo) {
		empDao.setEmployeeOne(evo);
	}
	
	public EmpVO loginCheck(EmpVO evo, HttpSession session) {
		/* 세션 생성 (백그라운드 실행) */
		EmpVO vo = empDao.loginCheck(evo);
		
		if ( vo != null ) {
			session.setAttribute("buseo", vo.getBuseo());
			session.setAttribute("grade", vo.getGrade());
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("username", vo.getUsername());
			session.setAttribute("level", vo.getLevel());
		}
		/* 세션 생성 */
		return vo;
	}

}
