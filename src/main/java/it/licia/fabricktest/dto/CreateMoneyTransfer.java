package it.licia.fabricktest.dto;

import java.util.Date;

public class CreateMoneyTransfer {
	
	private String moneyTransferId;
	private String status;
	private String direction;
	private Creditor creditor;
	private Debtor debtor;	
	private String cro;
	private String trn;
	private String uri;
	private String description;
	private Date createdDatetime;
	private Date accountedDatetime;
	private Date debtorValueDate;
	private Date creditorValueDate;
	private Amount amount;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountID;
	private Fees[] fees;
	private boolean hasTaxRelief;
	
	public String getMoneyTransferId() {
		return moneyTransferId;
	}
	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Creditor getCreditor() {
		return creditor;
	}
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}
	public Debtor getDebtor() {
		return debtor;
	}
	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getTrn() {
		return trn;
	}
	public void setTrn(String trn) {
		this.trn = trn;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public Date getAccountedDatetime() {
		return accountedDatetime;
	}
	public void setAccountedDatetime(Date accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}
	public Date getDebtorValueDate() {
		return debtorValueDate;
	}
	public void setDebtorValueDate(Date debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}
	public Date getCreditorValueDate() {
		return creditorValueDate;
	}
	public void setCreditorValueDate(Date creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public boolean isInstant() {
		return isInstant;
	}
	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeAccountID() {
		return feeAccountID;
	}
	public void setFeeAccountID(String feeAccountID) {
		this.feeAccountID = feeAccountID;
	}
	public Fees[] getFees() {
		return fees;
	}
	public void setFees(Fees[] fees) {
		this.fees = fees;
	}
	public boolean isHasTaxRelief() {
		return hasTaxRelief;
	}
	public void setHasTaxRelief(boolean hasTaxRelief) {
		this.hasTaxRelief = hasTaxRelief;
	}
	
	
}
