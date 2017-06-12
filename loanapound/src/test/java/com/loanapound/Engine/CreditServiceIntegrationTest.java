package com.loanapound.Engine;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loanapound.LoanAPoundConfig;
import com.loanapound.db.LoanApplication;
import com.loanapound.engine.ApplicationDecision;
import com.loanapound.engine.LoanDecisionEngine;

/**
 * End to end tests from ApplicationDecisionEnine to third party credit check services.
 * 
 * @author Qifeng Huang
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=LoanAPoundConfig.class)
public class CreditServiceIntegrationTest {

	@Autowired
	private LoanDecisionEngine loanDecisionEngine;
	
	/**
	 * Test with the default credit check service
	 */
	@Test
	public void defaultCreditServiceTest(){
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setAppliedAmount(100);
		ApplicationDecision  decision = loanDecisionEngine.processLoanApplication(loanApplication);
		assertNotNull(decision);
		assertTrue(decision.getApplicantCreditScore()==1);
	}
	
	/**
	 * Test to check another credit check service. 
	 * The credit score is null because the call to the service is not fully implemented
	 */
	
	@Test
	public void company1CreditServiceTest(){
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setAppliedAmount(600);
		ApplicationDecision  decision = loanDecisionEngine.processLoanApplication(loanApplication);
		assertNotNull(decision);
		assertNull(decision.getApplicantCreditScore());
	}
}
