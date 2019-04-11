package com.revature.project.dao;

import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.exceptions.AccountNotFoundException;


public interface AccountDAO {
	
	public List<Accounts> getAccounts();
	public Accounts getAccountById(int accountId) throws AccountNotFoundException;//return one account of that user 
	public List<Accounts> getUserAccountsByLogin(String username, int password);//return multiple accounts of that user
	public void createAccount(BankUser user);
	public void updateAccountByWithdraw(Accounts accounts, double withdraw);
	public void updateAccountByDeposit(Accounts accounts, double withdraw);
	public void deleteAccount(Accounts account);
	double getCurrentBalance(int accountId) throws AccountNotFoundException;
	
	
	
	
}
