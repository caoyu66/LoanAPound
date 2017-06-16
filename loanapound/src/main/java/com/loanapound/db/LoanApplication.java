package com.loanapound.db;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LoanApplication")
public class LoanApplication implements Serializable {
	private long id;
	private Applicant applicant;
	private LoanType loanType;
	
	private int appliedAmount;
	
	private Integer approvedAmount;
	private Timestamp applicationTime;
	private Timestamp lastUpdatedTime;
	private LoanApplicationStatus status;
	
	@XmlElement (name="id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@XmlElement (name="AppliedAmount")
	public int getAppliedAmount() {
		return appliedAmount;
	}

	public void setAppliedAmount(int appliedAmount) {
		this.appliedAmount = appliedAmount;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public LoanType getLoanType() {
		return loanType;
	}
	
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public Integer getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(Integer approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public Timestamp getApplicationTime() {
		return applicationTime;
	}
	
	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}
	
	public Timestamp getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	
	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	public LoanApplicationStatus getStatus() {
		return status;
	}
	
	public void setStatus(LoanApplicationStatus status) {
		this.status = status;
	}
}
