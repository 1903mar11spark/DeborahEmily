package com.revature.project.beans;

public class TransactionHistory {
	
	
	
	public TransactionHistory(int transactionId, double deposit, double withdraw) {
		this.transactionId = transactionId;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}
	
	protected int transactionId;
	protected double deposit;
	protected double withdraw;
	
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
	
	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ "]";
	}
	
	
	
	

}
