package com.loanapound.engine;

import java.io.Serializable;

import com.loanapound.db.LoanApplication;

public class ApplicationDecision implements Serializable {
	private LoanApplication loanApplication;
	private Integer applicantCreditScore;
	private Boolean approved;
	private String info;
	
	public ApplicationDecision(){}
	
	public ApplicationDecision(LoanApplication loanApplication, Integer applicantCreditScore){
		this(loanApplication, applicantCreditScore, null, null);
	}
	
	public ApplicationDecision(LoanApplication loanApplication, Integer applicantCreditScore, String info){
		this(loanApplication, applicantCreditScore, null, info);
	}
	
	public ApplicationDecision(LoanApplication loanApplication, Integer applicantCreditScore, Boolean approved, String info){
		this.loanApplication = loanApplication;
		this.applicantCreditScore = applicantCreditScore;
		this.approved = approved;
		this.info = info;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	public Integer getApplicantCreditScore() {
		return applicantCreditScore;
	}

	public void setApplicantCreditScore(Integer applicantCreditScore) {
		this.applicantCreditScore = applicantCreditScore;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}	
}
