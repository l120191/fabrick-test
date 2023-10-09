package it.licia.fabricktest.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import it.licia.fabricktest.dto.CreateMoneyTransfer;
import it.licia.fabricktest.dto.CreateMoneyTransferRequest;
import it.licia.fabricktest.dto.Transaction;
import it.licia.fabricktest.service.IAccountService;

@RestController
@RequestMapping("account")
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	IAccountService accountService;
	
	
	//http://localhost:8080/account/balance/14537780
	@GetMapping("/balance/{accountId}")
	public String accountBalance(@PathVariable Long accountId) {
		log.info("[accountBalance] START ****************** Input  >"+accountId+"<");
		String respsonseBalance = accountService.retrieveBalance(accountId);
		log.info("[accountBalance] END   ****************** Output >"+respsonseBalance+"<");
		return respsonseBalance;
	}
	
	// http://localhost:8080/account/transactions/14537780?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01
	@GetMapping("/transactions/{accountId}")
	public String accountTransactionsList(@PathVariable Long accountId, @RequestParam(name = "fromAccountingDate") String fromAccountingDate, @RequestParam(name = "toAccountingDate") String toAccountingDate) {
		log.info("[accountTransactionsList] START ****************** Input  >"+accountId+", "+fromAccountingDate+", "+toAccountingDate+"<");
		Transaction[] responseTransactions = accountService.retrieveTransactionByAccount(accountId, fromAccountingDate, toAccountingDate);
		log.info("[accountTransactionsList] END   ****************** Output >"+(responseTransactions!=null?Arrays.toString(responseTransactions):null)+"<");
		return (responseTransactions!=null?Arrays.toString(responseTransactions):null); 
	}

	
	// http://localhost:8080/account/bonifico/14537780
	@PostMapping("/bonifico/{accountId}")
	public String accountBonifico(@PathVariable Long accountId, @RequestBody CreateMoneyTransferRequest request) {
		log.info("[accountBalance] START ****************** Input >"+accountId+"<");
		log.info("[accountBalance] START ****************** Input >"+request.toString()+"<");
		Gson gson = new Gson();
		String requestJson = gson.toJson(request);
		log.info("[accountBalance] START ****************** JSON Request >"+requestJson+"<");
		CreateMoneyTransfer responseBonifico = accountService.createMoneyTansfer(accountId, request);
		
		log.info("[accountBalance] START ****************** output >"+responseBonifico+"<");

		return responseBonifico!=null?responseBonifico.toString():"Error"; 
		
	}

}
