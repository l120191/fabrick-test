package it.licia.fabricktest.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.licia.fabricktest.dto.BalanceResponse;
import it.licia.fabricktest.dto.CreateMoneyTransferRequest;
import it.licia.fabricktest.dto.CreateMoneyTransferResponse;
import it.licia.fabricktest.dto.Transaction;
import it.licia.fabricktest.dto.TransactionsResponse;
import it.licia.fabricktest.service.IAccountService;


@Service("accountServiceImpl")
public class AccountServiceImpl implements IAccountService{
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	private static final String BASE_URI = "https://sandbox.platfr.io";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String retrieveBalance(Long accountId) {
		
		String url = BASE_URI+ "/api/gbs/banking/v4.0/accounts/{accountId}/balance";
		ResponseEntity<BalanceResponse> response = null;
		String result = null;
		url = url.replace("{accountId}", Long.toString(accountId));
		
		log.info("[retrieveBalance] START ****************** Input >"+accountId+"<");
		log.info("[retrieveBalance] URL >"+url+"<");
		
		try {
			HttpEntity<String> entity = new HttpEntity<>("parameters",  getHeaderWithAuth());
			response = restTemplate.exchange(url, HttpMethod.GET, entity, BalanceResponse.class);
			log.info("[retrieveBalance] response >"+(response!=null?response.toString():response)+"<");
			if(response!=null && HttpStatus.OK.equals(response.getStatusCode()) && response.getBody()!=null){	
				if(response.getBody().getPayload()!=null && response.getBody().getPayload().getBalance()!=null) {
					result = response.getBody().getPayload().getBalance().toString();
				} 
			}
		} catch(Exception e) {
			log.error("[retrieveBalance] error call to service  >"+e);
		}

		log.info("[retrieveBalance] END result >"+result+"<");
		return result;
	}

	
	@Override
	public Transaction[] retrieveTransactionByAccount(Long accountId, String startDate, String endDate) {
		String url = BASE_URI+ "/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={startDate}&toAccountingDate={endDate}";
		ResponseEntity<TransactionsResponse> response = null;
		Transaction [] result = null;
		url = url.replace("{accountId}", Long.toString(accountId));
		url = url.replace("{startDate}", startDate);
		url = url.replace("{endDate}", endDate);
		
		log.info("[retrieveTransactionByAccount] START ****************** Input >"+accountId+", " + startDate +", " + endDate +"<");
		log.info("[retrieveTransactionByAccount] URL >"+url+"<");

		try {
			HttpEntity<String> entity = new HttpEntity<>("parameters",  getHeaderWithAuth());
			response = restTemplate.exchange(url, HttpMethod.GET, entity, TransactionsResponse.class);
			log.info("[retrieveTransactionByAccount] response >"+(response!=null?response.toString():response)+"<");
			if(response!=null && HttpStatus.OK.equals(response.getStatusCode()) && response.getBody()!=null ){
				if(response.getBody().getPayload()!=null && response.getBody().getPayload().getList()!=null) {
					result = response.getBody().getPayload().getList();
				} 
			} 
		} catch(Exception e) {
			log.error("[retrieveTransactionByAccount] error call to service  >"+e);
		}
		
		log.info("[retrieveTransactionByAccount] END result >"+(result!=null?Arrays.toString(result):null)+"<");
		return result;
	}
	
	
	@Override
	public String createMoneyTansfer(Long accountId, CreateMoneyTransferRequest request) {
		String url = BASE_URI+ "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";
		ResponseEntity<String> response = null;
		CreateMoneyTransferResponse res = null;
		String responseMoneyTransfer = null;
		url = url.replace("{accountId}", Long.toString(accountId));
		
		log.info("[createMoneyTansfer] START ****************** Input >"+accountId+"<");
		log.info("[createMoneyTansfer] URL >"+url+"<");
		try {
			HttpEntity<CreateMoneyTransferRequest> httpEntity = new HttpEntity<>(request, getHeaderWithAuth());
			responseMoneyTransfer = restTemplate.postForObject(url, httpEntity, String.class);
			log.info("[createMoneyTansfer] response >"+(responseMoneyTransfer!=null?responseMoneyTransfer.toString():responseMoneyTransfer)+"<");
			if(response!=null && HttpStatus.OK.equals(response.getStatusCode()) && response.getBody()!=null ){
//				if(response.getBody().getPayload()!=null && response.getBody().getPayload().getList()!=null) {
//					result = response.getBody().getPayload().getList();
//				} 
			} 
		
		} catch(Exception e) {
			log.error("[retrieveTransactionByAccount] error call to service  >"+e);
		}
		
		log.info("[createMoneyTansfer] response >"+responseMoneyTransfer+"<");
		return responseMoneyTransfer;
	}
	
	private HttpHeaders getHeaderWithAuth() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Auth-Schema", "S2S");
		headers.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		return headers;
	}

}
