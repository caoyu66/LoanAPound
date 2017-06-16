package com.loanapound.db;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Applicant extends UserAccount {
	private String surname;
	
	private String middleName;
	private String name;
	
	@NotNull
	@Size(min=3, max=16)
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
