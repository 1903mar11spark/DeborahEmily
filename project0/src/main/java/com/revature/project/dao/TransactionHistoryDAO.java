package com.revature.project.dao;

import java.util.List;

import com.revature.project.beans.TransactionHistory;
import com.revature.project.exceptions.AccountNotFoundException;

public interface TransactionHistoryDAO {
	
	
	void updateBalanceDeposit(int accountId, double deposit);

	List<TransactionHistory> getTransactionHistory(int accountId) throws AccountNotFoundException;

	void updateBalanceWithdraw(int accountId, double withdraw);


}
