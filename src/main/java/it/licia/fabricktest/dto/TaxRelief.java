package it.licia.fabricktest.dto;

public class TaxRelief {

	private String taxReliefId;
	private boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private String beneficiaryType;
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	private LegalPersonBeneficiary legalPersonBeneficiary;
	
	public String getTaxReliefId() {
		return taxReliefId;
	}
	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}
	public boolean isCondoUpgrade() {
		return isCondoUpgrade;
	}
	public void setCondoUpgrade(boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}
	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}
	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}
	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}
	public LegalPersonBeneficiary getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}
	public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}
	@Override
	public String toString() {
		return "TaxRelief [taxReliefId=" + taxReliefId + ", isCondoUpgrade=" + isCondoUpgrade + ", creditorFiscalCode="
				+ creditorFiscalCode + ", beneficiaryType=" + beneficiaryType + ", naturalPersonBeneficiary="
				+ naturalPersonBeneficiary + ", legalPersonBeneficiary=" + legalPersonBeneficiary + "]";
	}
	
	
}
