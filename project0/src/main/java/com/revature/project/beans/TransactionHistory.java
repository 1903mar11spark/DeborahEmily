package com.revature.project.beans;

public class TransactionHistory {
	
	
	
	public TransactionHistory(Accounts account) {
		this.account=account;
	}
	
	private int transactionId;
	private double deposit;
	private double withdraw;
	private Accounts account;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account=account;
	}
	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ ", account=" + account + "]";
	}
	
	
	
	
	

}
