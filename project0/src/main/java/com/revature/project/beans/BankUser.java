package com.revature.project.beans;



public class BankUser {
	
	public BankUser(int userId, String username, int password) {
		UserId = userId;
		this.username = username;
		this.password = password;
	}
	
	protected int UserId;	
	protected String username;
	protected int password;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
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
		return "BankUser [UserId=" + UserId + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
