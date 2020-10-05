package com.example.grp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grp.model.BuseoVO;
import com.example.grp.repository.BuseoDao;

@Service
public class BuseoSrv {
	
	@Autowired
	BuseoDao buseoDao;
	
	public List<BuseoVO> getBuseoList() {
		return buseoDao.getBuseoList();				
	}

}
