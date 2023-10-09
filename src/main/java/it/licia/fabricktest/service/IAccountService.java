package it.licia.fabricktest.service;

import it.licia.fabricktest.dto.CreateMoneyTransferRequest;
import it.licia.fabricktest.dto.Transaction;

public interface IAccountService {
	
	public String retrieveBalance(Long accountId);
	public Transaction[] retrieveTransactionByAccount(Long accountId, String startDate, String endDate);
	public String createMoneyTansfer(Long accountId, CreateMoneyTransferRequest request);
}
