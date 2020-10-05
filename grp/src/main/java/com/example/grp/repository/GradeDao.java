package com.example.grp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.grp.model.GradeVO;

@Repository
public class GradeDao {
	
	@Autowired
	SqlSession sqlSession;
	public List<GradeVO> getGradeList(){
		return sqlSession.selectList("grade.getGradeList");
	}

}
