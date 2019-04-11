package com.revature.project.project0;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import com.revature.project.*;
import com.revature.project.dao.BankUserDAOImpl;
import com.revature.project.main.Access;

public class Tests {

	private static final Access accessTest = new Access();
	private static final BankUserDAOImpl budTest = new BankUserDAOImpl();
	
	@Test
	public void testGetBalance() {
		
		assertFalse("", accessTest.("admin"));
	}
	
	@Test
	public void testGetUsername() {
		assertEquals("", accessTest.getPassword());
	}
	
	@Test
	public void test() {
		assertFalse();
	}
	
	public void testAnEmptyString() {
		assertEquals("", evaluationService.reverse(""));
	}
}
