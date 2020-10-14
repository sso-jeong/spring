package com.greenart.grp.service.comSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenart.grp.model.ComVO;
import com.greenart.grp.repository.comDao.ComDao;

@Service
public class ComSrv {
	
	@Autowired
	ComDao cDao;
	
	public ComVO getCompany() {
		return cDao.getCompany();
	}
	
	public void setCompany(ComVO cvo) {
		cDao.setCompany(cvo);
	}
}









