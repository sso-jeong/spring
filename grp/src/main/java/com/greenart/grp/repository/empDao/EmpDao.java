package com.greenart.grp.repository.empDao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenart.grp.model.BuseoVO;
import com.greenart.grp.model.EmpVO;
import com.greenart.grp.model.GradeVO;

@Repository
public class EmpDao {
	
	@Autowired
	SqlSession sql;
	
	public List<EmpVO> getEmpList(int start, int end, String searchOpt, String words) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchOpt", searchOpt);
		map.put("words", words);
		map.put("start", start);
		map.put("end", end); 
		
		return sql.selectList("employee.getEmpList", map);
	}
	
	// dao -> map
	public int getEmpCount(String searchOpt, String words) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchOpt", searchOpt);
		map.put("words", words);
		
		return sql.selectOne("employee.getEmpCount", map);
	}
	
	public void setEmpDelete(int eid) {
		sql.delete("employee.setEmpDelete", eid);
	}
	
	public void setEmpDeleteAll(int eid) {
		sql.delete("employee.setEmpDeleteAll", eid);
	}
	
	public void setEmpHeadChange(String empHead, int empID) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empHead", empHead);
		map.put("empID", empID);

		sql.update("employee.setEmpHeadChange", map);
	}
	
	public void setEmpConfirmChange(String empConfirm, int empID) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empConfirm", empConfirm);
		map.put("empID", empID);

		sql.update("employee.setEmpConfirmChange", map);
	}
	
	public void setEmpAuthChange(String empAuth, int empID) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empAuth", empAuth);
		map.put("empID", empID);

		sql.update("employee.setEmpAuthChange", map);
	}
	
	public EmpVO getEmpOne(String sessionNum) {
		return sql.selectOne("employee.getEmpOne", sessionNum);
	}
	
	public void setEmpRegOthers(EmpVO evo) {
		sql.insert("register.setEmpRegOthers", evo);
	}
	
	public List<BuseoVO> grpGetBuseo() {
		return sql.selectList("employee.grpGetBuseo");
	}
	
	public List<GradeVO> grpGetGrade() {
		return sql.selectList("employee.grpGetGrade");
	}
	
}











