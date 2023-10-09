package it.licia.fabricktest.dto;

import java.util.Arrays;

public class CreateMoneyTransferResponse {

	private String status;
	private ErrorResponse [] error;
	private CreateMoneyTransfer payload;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ErrorResponse[] getError() {
		return error;
	}
	public void setError(ErrorResponse[] error) {
		this.error = error;
	}
	public CreateMoneyTransfer getPayload() {
		return payload;
	}
	public void setPayload(CreateMoneyTransfer payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "CreateMoneyTransferResponse [status=" + status + ", error=" + Arrays.toString(error) + ", payload="
				+ payload + "]";
	}
	
}
