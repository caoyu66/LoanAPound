package com.loanapound.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.loanapound.db.LoanApplication;
import com.loanapound.db.LoanApplicationDao;
import com.loanapound.engine.ApplicationDecision;
import com.loanapound.engine.LoanDecisionEngine;

@Controller
public class ApplicationController {
	private long applicationId = 0;
	
	@Autowired
	private LoanDecisionEngine loanDecisionEngine;
	
	private LoanApplicationDao loanApplicationDao;
	
	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public ModelAndView showApplicationForm(Model model) {
		ModelAndView modelAndView = new ModelAndView("application");
        modelAndView.addObject("application", new LoanApplication());
        return modelAndView;
    }
	
	@RequestMapping(value = { "/application"}, method = RequestMethod.POST)
	public String processApplication(@Valid LoanApplication loanApplication
			, RedirectAttributes redirectAttributes
			, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()) {
			return "application";
		}
		
		ApplicationDecision appDecision = loanDecisionEngine.processLoanApplication(loanApplication);
		//XXX: test code
		loanApplication.setId(++applicationId);
		redirectAttributes.addFlashAttribute("ApplicationDecision", appDecision);
        return "redirect:applicationstatus.htm?id=" + loanApplication.getId();
    }

	public LoanDecisionEngine getLoanDecisionEngine() {
		return loanDecisionEngine;
	}

	public void setLoanDecisionEngine(LoanDecisionEngine loanDecisionEngine) {
		this.loanDecisionEngine = loanDecisionEngine;
	}

	public LoanApplicationDao getLoanApplicationDao() {
		return loanApplicationDao;
	}

	public void setLoanApplicationDao(LoanApplicationDao loanApplicationDao) {
		this.loanApplicationDao = loanApplicationDao;
	}	
}
