package it.licia.fabricktest;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.licia.fabricktest.controller.AccountController;
import it.licia.fabricktest.dto.Account;
import it.licia.fabricktest.dto.CreateMoneyTransferRequest;
import it.licia.fabricktest.dto.Creditor;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FabrickTestApplicationTests {

	static final String ACCOUNTID = "14537780";
	static final String BASE_URI = "http://localhost:8080/account";

	@Autowired
	private AccountController controller;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void testBalance() {

		String url = BASE_URI + "/balance/" + ACCOUNTID;
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(url, String.class);
			System.out.println(response);
			assertThat(response).isNotNull();
			assertThat(response.getBody()).isNotNull();
			Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			Assertions.assertEquals(response.getBody(), "100124.36");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testTransactions() {

		String url = BASE_URI + "/transactions/" + ACCOUNTID
				+ "?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01";
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(url, String.class);

			assertThat(response.getBody()).isNotNull();
			Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody()).isNotNull();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testBonifico() {

		String url = BASE_URI + "/bonifico/" + ACCOUNTID;
		ResponseEntity<String> response = null;
		try {
			CreateMoneyTransferRequest request = new CreateMoneyTransferRequest();
			Creditor creditor = new Creditor();
			creditor.setName("Licia Belli");
			Account account = new Account();
			account.setAccountCode("IT04J0200801622000105250298");
			account.setBicCode("UNCRITM1222");
			creditor.setAccount(account);
			request.setCreditor(creditor);
			request.setDescription("Test fabrick");
			request.setCurrency("EUR");
			request.setExecutionDate(giornoBonifico());
			request.setAmount(10.00);
			response = restTemplate.postForEntity(url, request, String.class);
			assertThat(response).isNull();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String giornoBonifico() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 3);
		String day =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return day;
	}

}
