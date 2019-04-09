package com.revature.project.dao;

import java.util.HashMap;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;


public interface AccountDAO {
	
	public List<Accounts> getAccounts();	
	public HashMap<Accounts, Double> getUserAccountsByLogin(String username, int password);
	public void createAccount(BankUser user);
	public void updateAccountByWithdraw(Accounts accounts, double withdraw);
	public void updateAccountByDeposit(Accounts accounts, double withdraw);
	public void deleteAccount(Accounts account);
	public double getCurrentBalance(Accounts account);
	
	
	
	
}
