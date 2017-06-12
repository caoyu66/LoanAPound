package com.loanapound.engine;

import com.loanapound.db.LoanApplication;

/**
 * A class implements the CreditCheckor interface, and can be used to get credit score from Company2 
 * 
 * @author Qifeng Huang
 *
 */
public class Company2CreditCheckor implements CreditCheckor {

	/**
	 * This method call the company2's credit score service based on the loan application
	 * @return: Credit score associated with the loan application; null if it isn't available for whatever reason
	 */
	public Integer getCreditScore(LoanApplication loanApplication) {
		// TODO Logic to get credit score from Company1 based on the applicant details and loan details, using the agreed interface
		return null;
	}

}
