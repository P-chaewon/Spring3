package com.cw.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankbookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;

	public int setDelete(Long bookNum) {
		return bankBookDAO.setDelete(bookNum);
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public List<BankBookDTO> getList() {
		return bankBookDAO.getList();
	}
	
	public int setInsert(BankBookDTO bankBookDTO) {
		return bankBookDAO.setInsert(bankBookDTO);
	}
}
