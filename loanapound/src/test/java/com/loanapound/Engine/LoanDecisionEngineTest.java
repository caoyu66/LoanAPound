package com.loanapound.Engine;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loanapound.LoanAPoundConfig;
import com.loanapound.engine.DefaultCreditServiceImpl;
import com.loanapound.engine.LoanDecisionEngine;

/**
 * Test LoanDecisionEngine is properly wired up with the CreditCheckorFactory and the TefaultCreditServiceImpl
 * 
 * @author Qifeng Huang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=LoanAPoundConfig.class)
public class LoanDecisionEngineTest {
	@Autowired
	private LoanDecisionEngine loanDecisionEngine;
	
	@Autowired
	DefaultCreditServiceImpl defaultCreditSrvImpl;
	
	@Test
	public void decisionEngineShouldNotBeNull() {
		assertNotNull(loanDecisionEngine);
	}
	
	@Test
	public void creditCheckorFactoryShouldNotBeNull() {
		assertNotNull(loanDecisionEngine);
		assertNotNull(loanDecisionEngine.getCreditCheckorFacotory());
	}
	
	@Test
	public void defaultCreditServiceImplShouldNotBeNull() {
		assertNotNull(defaultCreditSrvImpl);
	}
}
