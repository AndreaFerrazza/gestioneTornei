package it.dstech.tornei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.model.Account;
import it.dstech.tornei.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/public/", method = RequestMethod.POST)
	public Account registraAccount(@RequestBody Account account) throws BadRequestException {
		return accountService.registraAccount(account);
	}
	
}
