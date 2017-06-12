package com.loanapound.engine;

import org.springframework.stereotype.Component;

import com.loanapound.db.LoanApplication;

/**
 * The factory class which choose a proper credit check service to use. 
 * More method (and or rules) can be added when necessary
 * 
 * @author Qifeng Huang
 *
 */
@Component
public class CreditCheckorFactory {
	
	/**
	 * This method choose a credit check service based on the applicant and types of loans with criteria
	 * 
	 * @param loanApplication: details of the loan application.
	 * @return A CreditCheckor class which can be used to call the third party service
	 */
	public CreditCheckor getCreditCheckor(LoanApplication loanApplication){
		if(loanApplication.getAppliedAmount() >= 1000){
			return new Company1CreditCheckor();
		}if(loanApplication.getAppliedAmount() >= 500){
			return new Company2CreditCheckor();
		}
		
		return new DefaultCreditCheckor();
	}
}
