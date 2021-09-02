package com.cw.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cw.s1.util.DBConnect;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.cw.s1.bankbook.BankBookDAO."; 
	
	public int setDelete(Long bookNum) {
		return sqlSession.delete(NAMESPACE+"setDelete", bookNum);
	}

	public int setInsert(BankBookDTO bankBookDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert", bankBookDTO);
	}
	
	/*
	 * List : ArrayList, LinkedList 중 어떤 것이 들어갈 지 몰라 부모형으로 만들어주는 것 그래서 ArrayList가 아닌
	 * List가 들어가야 됨
	 */
	public List<BankBookDTO> getList() {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		return sqlSession.selectOne(NAMESPACE+"getSelect", bankBookDTO);
		
	}
	
}
		
		
		
				
				
