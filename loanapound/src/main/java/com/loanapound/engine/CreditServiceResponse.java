package com.loanapound.engine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is the REST response from the internal implemented credit check service
 * 
 * @author Qifeng Huang
 *
 */
@XmlRootElement(name="CreditScoreResponse")
public class CreditServiceResponse {
	private Integer creditScore;
	private String info;
	
	public CreditServiceResponse(){}
	
	public CreditServiceResponse(Integer creditScore, String info){
		this.creditScore = creditScore;
		this.info = info;
	}

	@XmlElement (name="CreditScore")
	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	@XmlElement (name="info")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
