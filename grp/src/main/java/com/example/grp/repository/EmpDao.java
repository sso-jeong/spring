package com.example.grp.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.grp.model.EmpVO;

@Repository
public class EmpDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public void setEmployeeOne(EmpVO evo) {
		sqlSession.insert("emp.setEmployeeOne", evo);
		
	}
	
	public EmpVO loginCheck(EmpVO evo) {
		return sqlSession.selectOne("emp.loginCheck",evo) ;
		
	}

}
