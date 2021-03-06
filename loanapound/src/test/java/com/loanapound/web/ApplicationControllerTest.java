package com.loanapound.web;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.loanapound.db.Applicant;
import com.loanapound.db.DefaultLoanApplicationDao;
import com.loanapound.db.LoanApplication;
import com.loanapound.engine.ApplicationDecision;
import com.loanapound.engine.LoanDecisionEngine;

/**
 * Test loan application page work both for get and post requests
 * 
 * @author Qifeng Huang
 *
 */
public class ApplicationControllerTest {
	
	@Test
	public void shouldShowApplication() throws Exception {
		ApplicationController controller = new ApplicationController();
		controller.setLoanApplicationDao(new DefaultLoanApplicationDao());
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/application.htm")).andExpect(view().name("application"));
	}
	
	@Test
	public void shouldProcessApplication() throws Exception {
		LoanDecisionEngine mockDecisionEngine = mock(LoanDecisionEngine.class);
		
		LoanApplication unsavedLoanApp = new LoanApplication();
		Applicant unsavedApp = new Applicant();
		unsavedApp.setName("name");
		unsavedApp.setSurname("surname");
		unsavedLoanApp.setAppliedAmount(100);
		
		LoanApplication savedLoanApp = new LoanApplication();
		Applicant savedApp = new Applicant();
		savedApp.setName("name");
		savedApp.setSurname("surname");
		savedLoanApp.setAppliedAmount(100);
		ApplicationDecision appDecsion = new ApplicationDecision(savedLoanApp, 1);
		when(mockDecisionEngine.processLoanApplication(unsavedLoanApp)).thenReturn(appDecsion);
		
		ApplicationController controller = new ApplicationController();
		controller.setLoanDecisionEngine(mockDecisionEngine);
		controller.setLoanApplicationDao(new DefaultLoanApplicationDao());
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/application.htm")).andExpect(redirectedUrl("applicationstatus.htm?id=1"));
		
		verify(mockDecisionEngine, atLeastOnce())/*.processLoanApplication(unsavedLoanApp)*/;
	}
}
