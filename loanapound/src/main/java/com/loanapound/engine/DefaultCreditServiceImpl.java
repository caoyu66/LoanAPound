package com.loanapound.engine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loanapound.db.LoanApplication;

/**
 * A default credit check service implemented inside the system, which provide a RSET API for the client to get the credit score for a particular loan application
 * 
 * @author Qifeng Huang
 *
 */

@Controller
public class DefaultCreditServiceImpl {

	@RequestMapping(value = "/getCreditScore", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CreditServiceResponse> getCreditScore(@RequestBody LoanApplication loanApplication){
		if(loanApplication != null){
			return new ResponseEntity<CreditServiceResponse>(new CreditServiceResponse(1, "Credit score is 1"), HttpStatus.OK);
		}else{
			return new ResponseEntity<CreditServiceResponse>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/getScore", method = RequestMethod.GET)
	public ResponseEntity<CreditServiceResponse> getScore(){
		return new ResponseEntity<CreditServiceResponse>(new CreditServiceResponse(1, "Credit score is 1"), HttpStatus.OK);
	}
}
