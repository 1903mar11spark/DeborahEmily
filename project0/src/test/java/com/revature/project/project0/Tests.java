package com.revature.project.project0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import com.revature.project.beans.BankUser;
import com.revature.project.dao.BankUserDAOImpl;

public class Tests {
	
	//private static final Access accessTest = new Access();
	private static final BankUserDAOImpl budTest = new BankUserDAOImpl();
	//private static final AccountDAOImpl auoTest = new AccountDAOImpl();
	
	@Test
	public void testGetUsers() { //get password --bank user dao
		BankUser HarryPotter = new BankUser(2, "hpotter", 222222);
		BankUser HermioneGranger = new BankUser(1, "hgranger", 111111);
		BankUser RonWeasley = new BankUser(3, "rweasley", 333333);
		BankUser DracoMalfoy = new BankUser(4, "dmalfoy", 444444);
		List<BankUser> hpUsers = new ArrayList<>();
		hpUsers.add(HermioneGranger);
		hpUsers.add(HarryPotter);
		hpUsers.add(RonWeasley);
		hpUsers.add(DracoMalfoy);
		Assert.assertEquals(hpUsers, budTest.getUsers());
	}

	@Test
	public void testGetUser() { //get account username -- bank user dao
		final String username = "hpotter";
		final int password = 222222;
		BankUser HarryPotter = new BankUser("hpotter", 222222);
		assertEquals(HarryPotter, budTest.getUser(username, password));
	}	
	@Test
	public void testGetUserByLoginTrue() {
		final String username = "hpotter";
		final int password = 222222;
		assertTrue(budTest.getUserByLogin(username, password));
	}
	@Test
	public void testdeleteUser() {
		final String username = "hpotter";
		final int password = 222222;
		assertTrue(budTest.getUserByLogin(username, password));
	}
}
