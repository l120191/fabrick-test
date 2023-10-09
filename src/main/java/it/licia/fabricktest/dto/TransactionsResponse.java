package it.licia.fabricktest.dto;

import java.util.Arrays;

public class TransactionsResponse {

	private String status;
	private ErrorResponse [] error;
	private TransactionList payload;
	
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
	public TransactionList getPayload() {
		return payload;
	}
	public void setPayload(TransactionList payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "TransactionsResponse [status=" + status + ", error=" + Arrays.toString(error) + ", payload=" + payload
				+ "]";
	}
	
}
