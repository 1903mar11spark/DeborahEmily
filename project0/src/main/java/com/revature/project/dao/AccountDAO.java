package com.revature.project.dao;

import java.util.HashMap;

import com.revature.project.beans.Accounts;


public interface AccountDAO {
	
	HashMap<Integer, Double> getAccounts();	
	public Accounts getAccountById(int id);
	public void createAccount(Accounts account);
	//public void updateAccount(Accounts account);
	public void deleteAccount(Accounts account);
	
	
	
}
