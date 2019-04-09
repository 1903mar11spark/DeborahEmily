package com.revature.project.beans;

public class Accounts  {

	public Accounts() {
		super();
	}

	public Accounts(BankUser user, int accountId, String accountType) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
	}
	/*
	public Accounts(int userId, String username, int password) {
		super(userId, username, password);
		// TODO Auto-generated constructor stub
	}*/

	private int accountId;
	private String accountType;
	private double accountBalance;
	private BankUser user;


	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public BankUser getUser() {
		return user;
	}
	public void setUser(BankUser user) {
		this.user=user;
	}

	@Override
	public String toString() {
		return "Accounts [AccountId=" + accountId + ", AccountType=" + accountType + ", AccountBalance="
				+ accountBalance + "]";
	}




}
