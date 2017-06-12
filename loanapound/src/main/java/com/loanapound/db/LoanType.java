package com.loanapound.db;

import java.io.Serializable;

public class LoanType implements Serializable {
	private long id;
	private LoanProvider loadProvider;
	private int term;
	private float rate;
	private float fee; 
	private Integer maximumAmount;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LoanProvider getLoadProvider() {
		return loadProvider;
	}
	
	public void setLoadProvider(LoanProvider loadProvider) {
		this.loadProvider = loadProvider;
	}
	
	public int getTerm() {
		return term;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}
	
	public float getRate() {
		return rate;
	}
	
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public float getFee() {
		return fee;
	}
	
	public void setFee(float fee) {
		this.fee = fee;
	}
	
	public Integer getMaximumAmount() {
		return maximumAmount;
	}
	
	public void setMaximumAmount(Integer maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
}
