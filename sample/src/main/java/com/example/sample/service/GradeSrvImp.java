package com.example.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.model.GradeVO;
import com.example.sample.repository.GradeDao;

@Service
public class GradeSrvImp implements GradeSrv {

	@Autowired
	GradeDao gradeDao;
	
	@Override
	public List<GradeVO> getGradeList() {
		return gradeDao.getGradeList();
	}

}
