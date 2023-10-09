package it.licia.fabricktest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.licia.fabricktest.controller.AccountController;
import it.licia.fabricktest.dto.Balance;
import it.licia.fabricktest.dto.Transaction;

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

		String url = BASE_URI + "/transactions/" + ACCOUNTID+"?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01";
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
			response = restTemplate.getForEntity(url, String.class);
			
			assertThat(response.getBody()).isNotNull();
			Assertions.assertNotEquals(response.getStatusCode(), HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			//assertThat(response.getBody().get).isNotNull();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
