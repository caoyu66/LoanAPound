package com.loanapound.db;

public interface LoanApplicationDao {
	
	LoanApplication getLoanApplication(long id);
	
	boolean persistLoanApplication(LoanApplication loanApplication);
}
