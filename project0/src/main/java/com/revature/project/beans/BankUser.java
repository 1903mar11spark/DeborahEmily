package com.revature.project.beans;



public class BankUser {
	
	private int userId;	
	private String username;
	private int password;
	
	public BankUser(int userId) {
		super();
	}
	
	public BankUser() {
		super();
	}
	
	public BankUser(int userId, String username, int password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	
	public BankUser(String username, int password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "BankUser [UserId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
