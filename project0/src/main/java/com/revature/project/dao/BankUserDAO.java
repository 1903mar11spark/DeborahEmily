package com.revature.project.dao;

import java.util.HashMap;

public interface BankUserDAO {
	
	HashMap<String, Integer> getAccounts();
	
	public int getPassword(String username);
	public void createUser(String username, int password);
	//public int createPassword(int password);
	public void getBankUserbyNameAndPassword();

}
