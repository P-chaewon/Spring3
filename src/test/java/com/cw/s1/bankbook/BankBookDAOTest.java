package com.cw.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cw.s1.MyJunitTest;


public class BankBookDAOTest extends MyJunitTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	public void setDeleteTest() {
		int result = bankBookDAO.setDelete(24L);
		assertEquals(1, result);
	}
	
	/* @Test */
	public void setInsertTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("Spring");
		bankBookDTO.setBookRate(3.35);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setInsert(bankBookDTO);
		assertEquals(1, result);
	}
	
	/* @Test */
	public void getSelectTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(2);
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		//System.out.println(bankBookDTO.getBookName());
		assertNotNull(bankBookDTO);
	}

	/* @Test */
	public void getListTest() {
		List<BankBookDTO> ar = bankBookDAO.getList();
		assertNotEquals(0, ar.size());
	}
}
