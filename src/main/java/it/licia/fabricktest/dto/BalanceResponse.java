package it.licia.fabricktest.dto;

import java.util.Arrays;

public class BalanceResponse {
	private String status;
	private ErrorResponse [] error;
	private Balance payload;
	
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
	public Balance getPayload() {
		return payload;
	}
	public void setPayload(Balance payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "BalanceResponse [status=" + status + ", error=" + Arrays.toString(error) + ", payload=" + payload + "]";
	}
	

}
