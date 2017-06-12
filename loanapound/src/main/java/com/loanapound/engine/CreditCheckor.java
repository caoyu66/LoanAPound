package com.loanapound.engine;

import com.loanapound.db.LoanApplication;

/**
 * This interface should be implemented as a client to call each third party credit check service.
 * 
 * @author Qifeng Huang
 *
 */
public interface CreditCheckor {
	/**
	 * 
	 * @param loanApplication: full details of the loan application, with applicant details wrapped inside
	 * @return The credit score associated with the loan applicant with this particular application. Null when it is possible to get an actual score for whatever reason
	 */
	public Integer getCreditScore(LoanApplication loanApplication);
}
