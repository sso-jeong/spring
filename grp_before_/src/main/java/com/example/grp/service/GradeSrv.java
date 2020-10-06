package com.example.grp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.grp.model.GradeVO;
import com.example.grp.repository.GradeDao;

@Service
public class GradeSrv {
	
	@Autowired
	GradeDao gradeDao;
	
	public List<GradeVO> getGradeList(){
		return gradeDao.getGradeList();
	}

}
