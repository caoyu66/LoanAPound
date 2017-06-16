package com.loanapound.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loanapound.db.Applicant;

@Controller
public class ApplicantController {
	
	
	@RequestMapping(value = "/applicant", method = RequestMethod.GET)
	public String showApplicationForm(Model model) {
		model.addAttribute("applicant", new Applicant());
		return "applicant";
    }

	
	@RequestMapping(value = { "/applicant"}, method = RequestMethod.POST)
	public String processApplication(@Valid @ModelAttribute("applicant") Applicant applicant
			, Errors errors) 
	{
		if(errors.hasErrors()) {
			return "applicant";
		}
		
		
        return "redirect:application.htm";
    }
}
