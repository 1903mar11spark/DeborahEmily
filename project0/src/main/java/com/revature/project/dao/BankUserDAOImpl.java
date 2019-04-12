package com.revature.project.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.beans.BankUser;
import com.revature.project.exceptions.UserNotFoundException;
import com.revature.project.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO {
	public static String x = "/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connections.properties";

	@Override
	public List<BankUser> getUsers() {// done, works
		List<BankUser> users = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
			String sql = "SELECT * FROM BANK_USER ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				int password = rs.getInt("USERPASSWORD");
				BankUser bankUser = new BankUser(userId, username, password);
				users.add(bankUser);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public BankUser getUser(String username, int password) {
		BankUser bu = new BankUser();
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
			String sql = "SELECT USERNAME, USERPASSWORD FROM BANK_USER ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				username = rs.getString("USERNAME");
				password = rs.getInt("USERPASSWORD");
				bu = new BankUser(username, password);
			}
			throw new UserNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
		}
		return bu;
	}

	public boolean getUserByLogin(String username, int password) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
			String sql = "SELECT USERNAME, USERPASSWORD FROM BANK_USER ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateUser(BankUser bu, int newPassword) {// how to check results??
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
			String sql = "{CALL CHANGE_PASSWORD(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, bu.getUsername());
			cs.setInt(2, newPassword);
			cs.execute();
			System.out.println(newPassword);
			throw new UserNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
		}
	}

	@Override
	public boolean createUser(BankUser user) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
			String sql = "INSERT INTO BANK_USER (USERNAME, USERPASSWORD) VALUES (?, ?) ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setDouble(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteUser(int userId) throws UserNotFoundException {
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
			String sql = "DELETE FROM BANK_USER WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
			throw new UserNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	
}

