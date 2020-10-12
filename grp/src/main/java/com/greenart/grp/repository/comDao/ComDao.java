package com.greenart.grp.repository.comDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenart.grp.model.ComVO;

@Repository
public class ComDao {
	
	@Autowired
	SqlSession sql;
	
	public ComVO getCompany() {
		return sql.selectOne("company.getCompany");
	}
	
	public void setCompany(ComVO cvo) {
		sql.update("company.setCompany", cvo);
	}

}
