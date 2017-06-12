package com.loanapound.engine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.loanapound.db.LoanApplication;

/**
 * This class is an implementation of interface CreditCheckor. 
 * It can be use to check the credit score associated with a loan application with the internal implemented credit score service on a RESTful API
 * 
 * @author Qifeng Huang
 *
 */
public class DefaultCreditCheckor implements CreditCheckor {
	private String serviceUrl = "http://localhost:8080/loanapound/scoresrv/getCreditScore";

	public Integer getCreditScore(LoanApplication loanApplication) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CreditServiceResponse> creditsrvRes = restTemplate.postForEntity(serviceUrl, loanApplication, CreditServiceResponse.class);
		
		if(creditsrvRes.getStatusCode() == HttpStatus.OK && creditsrvRes.getBody() != null){
			return creditsrvRes.getBody().getCreditScore();
		}else{
			return null;
		}
	}

}
