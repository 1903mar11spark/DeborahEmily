package com.revature.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.exceptions.UserNotFoundException;
import com.revature.project.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO{

	@Override
	public List<BankUser> getUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankUser getUser(String username, int password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUserByLogin(String username, int password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateUser(BankUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(BankUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(BankUser user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}
//Look over Exceptions 

//	@Override //returning all user from super login
//	public HashMap<Integer, String> getAllUsers() {
//		HashMap<Integer, String> bankUsers = new HashMap<>();//UserId is int, username is string
//		try (Connection con = ConnectionUtil.getConnection()){
//			String sql = "SELECT * FROM BANK_USER ";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				int userId = rs.getInt("USER_ID");
//				String username = rs.getString("USERNAME");
//				bankUsers.put(userId,username);//??? WANTS PUTALL, DON'T KNOW WHY
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bankUsers;
//	}
//
//	@Override
//	public int getPassword(String username) {
//		int password = 0;
//		try (Connection con = ConnectionUtil.getConnection()){
//			String sql = "SELECT USER_ID, USERNAME, USERPASSWORD FROM BANK_USER WHERE USERNAME=?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(2, username);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				password = rs.getInt("PASSWORD");
//				username = rs.getString("USERNAME");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return password;
//	}
//
//	@Override
//	public void createUser(String username, int password) {
//		BankUser user = new BankUser();
//		try (Connection con = ConnectionUtil.getConnection()){
//			String sql = "INSERT INTO BankUser VALUES (?,?,?)";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, user.getUserId());
//			pstmt.setString(2, user.getUsername());
//			pstmt.setDouble(3, user.getPassword());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	@Override
//	public void deleteUser(int userId) throws UserNotFoundException {//callable statement
//		try (Connection con = ConnectionUtil.getConnection()){
//			String sql = "DELETE FROM BANKUSER WHERE USER_ID = ?";//ALSO ALL ACCOUNTS W/ USER_ID = ? AND TRANSACTION HISTORY
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, userId);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public BankUser getUsername(String username) throws UserNotFoundException {
//		BankUser us = new BankUser();
//		String sql = "SELECT USERNAME FROM BANK_USER WHERE USER_NAME = ?";
//		try (Connection con = ConnectionUtil.getConnection()){
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(2, username);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				us.setUsername(rs.getString("USERNAME"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return us;
//	}



}
