package it.licia.fabricktest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Balance {

//	{
//		  "date": "2018-08-17",
//		  "balance": 29.64,
//		  "availableBalance": 29.64,
//		  "currency": "EUR"
//		}
	
	private Date date;
	private Double balance;
	private Double availableBalance;
	private String currency;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Balance [date=" + date + ", balance=" + balance + ", availableBalance=" + availableBalance
				+ ", currency=" + currency + "]";
	}
	
	
}
