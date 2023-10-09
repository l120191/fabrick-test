package it.licia.fabricktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FabrickTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabrickTestApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	/** 
	 * Base URI : https://sandbox.platfr.io
	 * 
	 * Operazioni: 
	 *  - Lettura saldo : /api/gbs/banking/v4.0/accounts/{accountId}/balance
	 *  - Lista transaz : /api/gbs/banking/v4.0/accounts/{accountId}/transactions 
	 *  - Bonifico  	: /api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers
	 * 
	 * e.g. https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/balance
	 * 
	 * 
	 * Per auth: 
	 * 
	 * 	BaseUrl: 		https://sandbox.platfr.io
	 *	Auth-Schema: 	S2S
	 *	Api-Key: 		FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP
	 *	Id chiave: 		3202 (per uso interno, non utile al fine del test)
	 *	accountId: 		14537780
	 *
	 */

}
