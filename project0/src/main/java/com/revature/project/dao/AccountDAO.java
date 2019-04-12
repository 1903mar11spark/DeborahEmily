package com.revature.project.dao;

import java.io.IOException;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.exceptions.AccountNotFoundException;


public interface AccountDAO {
	
	public List<Accounts> getAccounts();
	
	public Accounts getAccountById(int accountId) throws AccountNotFoundException, IOException;//return one account of that user 
	public List<Accounts> getUserAccountsByLogin(String username, int password) throws IOException;//return multiple accounts of that user
	
	//main ones to focus on
	double getCurrentBalance(int accountId) throws AccountNotFoundException; //view Account
	
	//create and update an account by passing in an account
	public void createAccount(Accounts account);
	public void deleteAccount(Accounts account);
	
	//update the account by passing in the accountId and balance to that will be changed and returned
	public void updateAccount(Accounts account);
		
}
