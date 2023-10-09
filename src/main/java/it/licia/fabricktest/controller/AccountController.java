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
	
//	
//	// http://localhost:8080/account/bonifico/14537780
//	@GetMapping("/bonifico/{accountId}")
//	public Long accountBonifico(@PathVariable Long accountId) {
//		log.info("[accountBalance] START ****************** Input >"+accountId+"<");
//
//		CreateMoneyTransferRequest request = new CreateMoneyTransferRequest();
//		Creditor creditor = new Creditor();
//		creditor.setName("Licia Belli");
//		Account account = new Account();
//		account.setAccountCode("IT04J0200801622000105250298");
//		account.setBicCode("UNCRITM1222");
//		creditor.setAccount(account);
//		request.setCreditor(creditor);
//		request.setDescription("Test fabrick");
//		request.setCurrency("EUR");
//		String dateS = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//		request.setExecutionDate("2023-10-11");
//		request.setAmount(10.00);
//		
//		accountService.createMoneyTansfer(accountId, request);
//		
//		return accountId; 
//		
//	}
	
	// http://localhost:8080/account/bonifico/14537780
	@PostMapping("/bonifico/{accountId}")
	public Long accountBonifico(@PathVariable Long accountId, @RequestBody CreateMoneyTransferRequest request) {
		log.info("[accountBalance] START ****************** Input >"+accountId+"<");
		log.info("[accountBalance] START ****************** Input >"+request.toString()+"<");
		Gson gson = new Gson();
		String resJson = gson.toJson(CreateMoneyTransferRequest.class);

		log.info("[accountBalance] START ****************** JSON  >"+resJson+"<");
		String responseBonifico = accountService.createMoneyTansfer(accountId, request);
		
		log.info("[accountBalance] START ****************** output >"+responseBonifico+"<");

		return accountId; 
		
	}
//	{
//		  "creditor": {
//		    "name": "John Doe",
//		    "account": {
//		      "accountCode": "IT04J0200801622000105250298",
//		      "bicCode": "UNCRITM1222"
//		    }
//		  },
//		  "executionDate": "2023-11-11",
//		  "description": "Test fabrick",
//		  "amount": 10,
//		  "currency": "EUR",
//		  "isUrgent": false,
//		  "isInstant": false
//		}
	
	
// [creditor=Creditor [name=John Doe, 
//	account=Account [accountCode=IT04J0200801622000105250298, bicCode=UNCRITM1222], 
//		address=null], executionDate=2023-11-11, uri=null, 
	description=Test fabrick, amount=10.0, currency=EUR, isUrgent=false, isInstant=false, feeType=null, feeAccountId=null, taxRelief=null, legalPersonBeneficiary=null]<

	
	
}
