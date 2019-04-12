package com.revature.project.dao;

//import java.util.HashMap;
import java.util.List;

//import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.exceptions.UserNotFoundException;

public interface BankUserDAO {
	
	//public HashMap<Integer, String> getAllUsers();	
	public List<BankUser> getUsers() throws UserNotFoundException;
	public BankUser getUser(String username, int password) throws UserNotFoundException;
	
	public boolean getUserByLogin(String username, int password); //possible use
	
	//like bears
	public void updateUser(BankUser user);
	public void createUser(BankUser user);
	public void deleteUser(BankUser user) throws UserNotFoundException;
	

}
