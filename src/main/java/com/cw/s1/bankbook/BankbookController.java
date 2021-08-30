package com.cw.s1.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//POJP(Plain Old Java Object)
	
	@RequestMapping("bankbookList.do")
	public String list() {
		System.out.println("bankbook list");
		return "bankbook/bankbookList";
	}
	
	@RequestMapping(value = "bankbookSelect.do", method = RequestMethod.GET)
	public String select(int num, String name) {
		
		System.out.println("Value : "+num);
		System.out.println("Name : "+name);
		return "bankbook/bankbookSelect";
	}
}
