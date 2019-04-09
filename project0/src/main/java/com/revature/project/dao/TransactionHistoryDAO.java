package com.revature.project.dao;

import com.revature.project.beans.Accounts;

public interface TransactionHistoryDAO {
	
	public void getTransactionHistor(Accounts accountId);
	public double updateBalanceWithdraw(double withdraw);
	public double updateBalanceDeposit(double deposit);
	
	

}
