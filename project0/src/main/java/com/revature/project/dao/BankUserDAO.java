package com.revature.project.dao;

import java.util.HashMap;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;

public interface BankUserDAO {
	
	public HashMap<Integer, String> getAllUsers();	
	public int getPassword( String username);
	public void createUser(String username, int password);
	public List<Accounts> getAccountId(int userId);
	public void deleteUser(int userId);

}
