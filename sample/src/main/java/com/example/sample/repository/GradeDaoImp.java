package com.example.sample.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sample.model.GradeVO;

@Repository
public class GradeDaoImp implements GradeDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GradeVO> getGradeList() {
		return sqlSession.selectList("register.getGradeList");
	}

}
