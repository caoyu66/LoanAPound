package com.loanapound.db;

import java.io.Serializable;

public class UserAccount  implements Serializable {
	private long id;
	private String email;
	private String password;
	private AccountAuthority authority = AccountAuthority.ROLE_NONE;
	
	public UserAccount(){}
	
	public UserAccount(long id, String email, String password, AccountAuthority authority){
		this.id = id;
		this.email = email;
		this.password = password;
		this.authority = authority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountAuthority getAuthority() {
		return authority;
	}

	public void setAuthority(AccountAuthority authority) {
		this.authority = authority;
	}
}
