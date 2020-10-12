package com.greenart.grp.service.comSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenart.grp.model.ComVO;
import com.greenart.grp.repository.comDao.ComDao;

@Repository
public class ComSrv {
	
	@Autowired
	ComDao comDao;
	
	public ComVO getCompany() {
		return comDao.getCompany();
	}
	
	public void setCompany(ComVO cvo) {
		comDao.setCompany(cvo);
	}
}
