package com.cw.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//POJP(Plain Old Java Object)
	
	@Autowired
	private BankbookService bankbookService;
	
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv) {
		
		List<BankBookDTO> ar = bankbookService.getList();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(BankBookDTO bankBookDTO, Model model) {
		bankBookDTO = bankbookService.getSelect(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
		
	}
	
	@RequestMapping(value = "bankbookInsert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	@RequestMapping(value = "bankbookInsert", method = RequestMethod.POST)
	public String insert(BankBookDTO bankBookDTO) {
		int result= bankbookService.setInsert(bankBookDTO);
		
		return "redirect: ./bankbookList";
	}
	
	@RequestMapping("bankbookDelete")
	public String delete(Long bookNum) {
		int result = bankbookService.setDelete(bookNum);
		
		return "redirect:./bankbookList";
		
	}
}
