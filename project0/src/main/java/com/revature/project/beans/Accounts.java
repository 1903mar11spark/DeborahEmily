package com.revature.project.beans;

public class Accounts  {

	public Accounts() {
		super();
	}

	public Accounts(BankUser user, String accountType) {
		super();
		this.user = user;
		this.accountId = accountId;
		this.accountType = accountType;
	}
	

	private int accountId;
	private String accountType;
	private double accountBalance;
	private BankUser user;
	private double overdraftFee;


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
				+ accountBalance + ", user=" + user + ", overdraftFee=" + overdraftFee + "]";
	}

	
}
