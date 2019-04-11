//package com.revature.project.project0;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//
//import org.junit.Test;
//

//import com.revature.project.*;
//import com.revature.project.beans.Accounts;
//import com.revature.project.dao.AccountDAOImpl;
//import com.revature.project.dao.BankUserDAOImpl;
//import com.revature.project.main.Access;
//
//public class Tests {
//
/////Tests on all return data
//
//	private static final Access accessTest = new Access();
//	private static final BankUserDAOImpl budTest = new BankUserDAOImpl();
//	private static final AccountDAOImpl auoTest = new AccountDAOImpl();
//	
//	@Test
//	public void testGetPassword() { //get password --bank user dao
//		final String username = "hpotter";
//		final String password = "1111111";
//		assertEquals(username, budTest.getPassword(password));
//	}
//	
//	@Test
//	public void testGetUsername() { //get account username -- bank user dao
//		final String username = "hpotter";
//		final String password = "1111111";
//		assertEquals(password, budTest.getUsername(username));
//	}
//	
///////////////////////
//	
//	@Test
//	public void testCurrentBalance() { //current password -- account dao
//		final String accountID = "1";
//		final String balance = "300.00";
//		assertEquals(accountID, auoTest.getCurrentBalance(balance)); ///need to remedy this
//	}
//	
//	
//	@Test
//	public void testGetAccountByID() { //test count id -- account dao
//		final String username = "hpotter";
//		final String password = "1111111";
//		assertEquals(username, budTest.getPassword(password));
//	}
//	
//	
//	@Test
//	public void testGetUserAccountsByLogin() { //
//		final String accountID = "1";
//		final String balance = "300.00";
//		assertEquals(accountID, auoTest.getCurrentBalance(balance)); ///need to remedy this
//	}
//
//////////////////////
//	
//}
