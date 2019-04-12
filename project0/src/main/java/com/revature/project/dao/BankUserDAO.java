package com.revature.project.dao;

//import java.util.HashMap;
import java.util.List;

//import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.exceptions.UserNotFoundException;

public interface BankUserDAO {

	List<BankUser> getUsers();

	BankUser getUser(String username, int password);

	void updateUser(BankUser bu, int newPassword);

	boolean createUser(BankUser user);

	boolean deleteUser(int userId) throws UserNotFoundException;
	

	

}
//public HashMap<Integer, String> getAllUsers();	
//public List<BankUser> getUsers() throws UserNotFoundException;
//public BankUser getUser(String username, int password) throws UserNotFoundException;
//
//public boolean getUserByLogin(String username, int password); //possible use
//
////like bears
//public void updateUser(BankUser user);
//public void createUser(BankUser user);
//public void deleteUser(BankUser user) throws UserNotFoundException;