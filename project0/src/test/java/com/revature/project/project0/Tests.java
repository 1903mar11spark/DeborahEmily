package com.revature.project.project0;

import org.junit.Test;
import com.revature.project.*;

public class Tests {

	@Test
	public void testGetUsername() {
		assertEquals("user", warehouse.fetchUser("admin").getUsername());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("employee", warehouse.fetchUser("employee").getPassword());
	}
	
	@Test
	public void test() {
		assertTrue("admin", warehouse.fetchUser("admin").getUsername());
	}
}
