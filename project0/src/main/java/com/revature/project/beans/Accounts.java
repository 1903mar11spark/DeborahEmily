package com.revature.project.beans;

public class Accounts  {

	private int accountId;
	private String accountType;
	private double accountBalance;
	private BankUser user;
	private double overdraftFee;
	

	public Accounts(BankUser user) {
		super();
		this.user = user;
	}
	

	public Accounts() {
		super();
	}
	public Accounts (String accountType, double accountBalance, int accountId) {
		super();
		this.accountType = accountType;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}
	
	public Accounts(BankUser user, String accountType, double accountBalance, int accountId) {
		super();
		this.user = user;
		this.accountType = accountType;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}

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
	public double getOverdraftFee() {
		return overdraftFee;
	}

	public void setOverdraftFee(double overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + "]";
	}

	
}
