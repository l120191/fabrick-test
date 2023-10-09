package it.licia.fabricktest.dto;

import java.util.Date;

public class Amount {

	private Double debtorAmount;
	private String debtorCurrency;
	private Double creditorAmount;
	private String creditorCurrency;
	private Date creditorCurrencyDate;
	private Double exchangeRate;
	
	public Double getDebtorAmount() {
		return debtorAmount;
	}
	public void setDebtorAmount(Double debtorAmount) {
		this.debtorAmount = debtorAmount;
	}
	public String getDebtorCurrency() {
		return debtorCurrency;
	}
	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}
	public Double getCreditorAmount() {
		return creditorAmount;
	}
	public void setCreditorAmount(Double creditorAmount) {
		this.creditorAmount = creditorAmount;
	}
	public String getCreditorCurrency() {
		return creditorCurrency;
	}
	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}
	public Date getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}
	public void setCreditorCurrencyDate(Date creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}
	public Double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	@Override
	public String toString() {
		return "Amount [debtorAmount=" + debtorAmount + ", debtorCurrency=" + debtorCurrency + ", creditorAmount="
				+ creditorAmount + ", creditorCurrency=" + creditorCurrency + ", creditorCurrencyDate="
				+ creditorCurrencyDate + ", exchangeRate=" + exchangeRate + "]";
	}
	
}
