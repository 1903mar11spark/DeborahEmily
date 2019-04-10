package com.revature.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.exceptions.UserNotFoundException;
import com.revature.project.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO{
//Look over Exceptions 

	@Override //returning all user from super login
	public HashMap<Integer, String> getAllUsers() {
		HashMap<Integer, String> bankUsers = new HashMap<>();//UserId is int, username is string
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BANK_USER ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				bankUsers.put(userId,username);//??? WANTS PUTALL, DON'T KNOW WHY
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankUsers;
	}

	@Override
	public int getPassword(String username) {
		int password = 0;
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT USER_ID,USERNAME, USERPASSWORD FROM BANK_USER USER=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(2, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				password = rs.getInt("PASSWORD");
				username = rs.getString("USERNAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	@Override
	public void createUser(String username, int password) {
		BankUser user = null;
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO BankUser VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUsername());
			pstmt.setDouble(3, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Accounts> getAccountId(int userId) throws UserNotFoundException{
		List<Accounts> accounts = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT A.ACCOUNT_ID, U.USER_ID, U.USERNAME, U.USERPASSWORD, A.ACCOUNT_TYPE "
					+ "FROM ACCOUNT A INNER JOIN BANK_USER U ON A.USER_ID = U.USER_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				int password = rs.getInt("PASSWORD");
				String accountType = rs.getString("ACCOUNT_TYPE");

				accounts.add(new Accounts(new BankUser(userId, username, password), accountType));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}


	@Override
	public void deleteUser(int userId) throws UserNotFoundException {//callable statement
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM BANKUSER WHERE USER_ID = ?";//ALSO ALL ACCOUNTS W/ USER_ID = ? AND TRANSACTION HISTORY
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//UPDATE USERPASSWORD

}
