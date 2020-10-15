package com.greenart.grp.service.empSrv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenart.grp.model.EmpVO;
import com.greenart.grp.repository.empDao.EmpDao;

@Service
public class EmpSrv {
	
	@Autowired
	EmpDao eDao;
	
	public List<EmpVO> getEmpList(String searchOpt, String words) {
		return eDao.getEmpList(searchOpt, words);
	}
	
	public int getEmpCount() {
		return eDao.getEmpCount();
	}
	
	public void setEmpDelete(int eid) {
		eDao.setEmpDelete(eid);
	}
	
	public void setEmpHeadChange(String empHead, int empID) {
		eDao.setEmpHeadChange(empHead, empID);
	}
	
	public void setEmpConfirmChange(String empConfirm, int empID) {
		eDao.setEmpConfirmChange(empConfirm, empID);
	}
	
	public void setEmpAuthChange(String empAuth, int empID) {
		eDao.setEmpAuthChange(empAuth, empID);
	}
	
	public EmpVO getEmpOne(String sessionNum) {
		return eDao.getEmpOne(sessionNum);
	}
	

	public void setEmpRegOthers(EmpVO evo) {
		eDao.setEmpRegOthers(evo);
	}
	
}









