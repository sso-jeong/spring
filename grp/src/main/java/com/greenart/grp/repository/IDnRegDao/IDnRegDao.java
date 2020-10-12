package com.greenart.grp.repository.IDnRegDao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenart.grp.model.BuseoVO;
import com.greenart.grp.model.EmpVO;
import com.greenart.grp.model.GradeVO;

@Repository
public class IDnRegDao {

	@Autowired
	SqlSession sqlSession;

	public List<BuseoVO> grpGetBuseo() {
		return sqlSession.selectList("register.grpGetBuseo");
	}

	public List<GradeVO> grpGetGrade() {
		return sqlSession.selectList("register.grpGetGrade");
	}

	public void setEmpRegister(EmpVO evo) {
		sqlSession.insert("register.setEmpRegister", evo);
	}

	public int getEmpNumCheck(EmpVO evo) {
		HashMap<String, String> hs = new HashMap<String, String>();
		hs.put("empNum", evo.getEmpNum());
		hs.put("empPwd", evo.getEmpPwd());
		return sqlSession.selectOne("register.getEmpNumCheck", hs);
	}

	public EmpVO getEmpInfo(EmpVO evo) {
		HashMap<String, String> hs = new HashMap<String, String>();
		hs.put("empNum", evo.getEmpNum());
		hs.put("empPwd", evo.getEmpPwd());
		return sqlSession.selectOne("register.getEmpInfo", hs);
	}

}
