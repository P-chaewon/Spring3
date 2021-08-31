package com.cw.s1.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.s1.util.DBConnect;

@Service
public class BankbookService {
	
	private BankBookDAO bankBookDAO;
	
	@Autowired
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}
	

	
	public ArrayList<BankBookDTO> getList() {
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		return ar;
	}
}
