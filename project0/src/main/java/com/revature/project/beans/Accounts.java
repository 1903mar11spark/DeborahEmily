package com.revature.project.beans;

public class Accounts {
	
	public Accounts() {
		super();
	}
	
	public Accounts(int accountId, String accountType, double accountBalance) {
		AccountId = accountId;
		AccountType = accountType;
		AccountBalance = accountBalance;
	}
	
	protected int AccountId;
	protected String AccountType;
	protected double AccountBalance;
	
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		AccountBalance = accountBalance;
	}
	
	@Override
	public String toString() {
		return "Accounts [AccountId=" + AccountId + ", AccountType=" + AccountType + ", AccountBalance="
				+ AccountBalance + "]";
	}
	
	
	
	
	
	

}
