package com.loanapound.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.loanapound.engine.ApplicationDecision;

@Controller
@SessionAttributes("ApplicationDecision")
public class ApplicationStatusController {
	
	@RequestMapping(value = "/applicationstatus", method = RequestMethod.GET)
	public ModelAndView showApplicationStatus(@RequestParam(value = "id", required = true) int id
			, @ModelAttribute("ApplicationDecision") final ApplicationDecision applicationDecision) 
	{
		ModelAndView modelAndView = new ModelAndView("applicationstatus");
        modelAndView.addObject("decision", applicationDecision);
        return modelAndView;
    }
}
