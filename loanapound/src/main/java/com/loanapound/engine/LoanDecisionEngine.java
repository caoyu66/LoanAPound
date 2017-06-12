package com.loanapound.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loanapound.db.LoanApplication;

/**
 * This is loan decision engine, which can choose a proper credit check service to use, 
 * and can be use to  get back the credit score of each loan application
 * 
 * @author Qifeng Huang
 *
 */
@Component
public class LoanDecisionEngine implements InitializingBean {
	final private Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private CreditCheckorFactory creditCheckorFacotory;

	public void afterPropertiesSet() throws Exception {
		if(creditCheckorFacotory == null){
			throw new Exception("creditCheckorFacotory property is required");
		}
	}
	
	/**
	 * 
	 * @param loanApplication: full details of the loan application, with applicant details wrapped inside
	 * @return THe credit score and/or other information from the third party credit check service
	 */
	public ApplicationDecision processLoanApplication(LoanApplication loanApplication){
		if(loanApplication == null)
			return null;
		
		final CreditCheckor creditCheckor = creditCheckorFacotory.getCreditCheckor(loanApplication);
		Integer creditScore = null;
		try{
			creditScore = creditCheckor.getCreditScore(loanApplication);
			//Add some automatically decision process here, if available
			return new ApplicationDecision(loanApplication, creditScore);
		}catch(Exception ex){
			logger.warn("", ex);
			return new ApplicationDecision(loanApplication, creditScore, "Exception: " + ex.getMessage());
		}
	}

	public CreditCheckorFactory getCreditCheckorFacotory() {
		return creditCheckorFacotory;
	}

	public void setCreditCheckorFacotory(CreditCheckorFactory creditCheckorFacotory) {
		this.creditCheckorFacotory = creditCheckorFacotory;
	}
}
