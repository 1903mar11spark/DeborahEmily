package com.revature.project.dao;

import java.util.List;

import com.revature.project.beans.TransactionHistory;
import com.revature.project.exceptions.AccountNotFoundException;

public interface TransactionHistoryDAO {
	
	public List<TransactionHistory> getTransactionHistory(int accountId) throws AccountNotFoundException;
	public double updateBalanceWithdraw(double withdraw);
	public double updateBalanceDeposit(double deposit);


}
