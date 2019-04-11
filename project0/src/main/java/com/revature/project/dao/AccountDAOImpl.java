package com.revature.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.util.ConnectionUtil;
import com.revature.project.exceptions.*;

public class AccountDAOImpl implements AccountDAO {


	@Override //return for superuser
	public List<Accounts> getAccounts() {
		List<Accounts> accounts = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT A.ACCOUNT_ID, A.ACCOUNT_TYPES, A.ACCOUNT_BALANCE, U.USER_ID,U.USERNAME,U.USERPASSWORD FROM ACCOUNTS A"
					+ "INNER JOIN BANK_USER U ON A.USER_ID = U.USER_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				int password = rs.getInt("USERPASSWORD");
				String accountType = rs.getString("ACCOUNT_TYPE");
				accounts.add(new Accounts(new BankUser(userId, username, password), accountType));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return accounts;
	}
	
	
	@Override
	public Accounts getAccountById(int accountId) throws AccountNotFoundException{
		Accounts account = new Accounts();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT A.ACCOUNT_ID, U.USER_ID, U.USERNAME, U.PASSWORD FROM ACCOUNTS A INNER JOIN BANK_USER U ON A.USER_ID = U.USER_ID WHERE A.ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				int password = rs.getInt("USERPASSWORD");
				accountId = rs.getInt("ACCOUNT_ID");
				String accountType = rs.getString("ACCOUNT_TYPE");
				//double accountBalance = rs.getDouble("ACCOUNT_BALANCE");
				account = new Accounts(new BankUser(userId, username, password), accountType);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return account;
		
	}
	@Override 
	public List<Accounts> getUserAccountsByLogin(String username, int password) {
		List<Accounts> accounts = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT A.ACCOUNTS_ID, A.ACCOUNTS_TYPES, A.ACCOUNT_BALANCE, U.USER_ID, FROM ACCOUNTS A"
					+ "INNER JOIN BANK_USER U ON A.USER_ID = U.USER_ID WHERE U.USERNAME=? AND U.USERPASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  username);
			pstmt.setInt(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String accountType = rs.getString("ACCOUNT_TYPE");
				accounts.add(new Accounts(new BankUser(userId, username, password),accountType)); //quesstion
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	//fix here
	@Override
	public void createAccount(BankUser user) {
		Accounts account = new Accounts();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO ACCOUNT (USER_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE) VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getUser().getUserId());
			pstmt.setString(2, account.getAccountType());
			pstmt.setDouble(3, account.getAccountBalance());
			pstmt.executeUpdate();
			//account()
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteAccount(Accounts account) {
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getAccountId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateAccountByWithdraw(Accounts accounts, double withdraw) throws OverdraftException{
		if(withdraw > 0) {
			try (Connection con = ConnectionUtil.getConnection()){
				String sql = "{call SP_WITHDRAW(?,?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, accounts.getAccountId());
				cs.setDouble(2, withdraw);
				cs.registerOutParameter(3, java.sql.Types.DECIMAL);
				cs.execute();
				accounts.setAccountBalance(accounts.getAccountBalance() - cs.getDouble(3)); 				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Please enter a positve number. ");
			//If withdraw is greater than currentBalance
		}
	}
	
	@Override
	public void updateAccountByDeposit(Accounts accounts, double deposit) {
		if(deposit > 0 && deposit < 500) {
			try (Connection con = ConnectionUtil.getConnection()){
				String sql = "{call SP_DEPOSIT(?,?,?)}";  
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, accounts.getAccountId());
				cs.setDouble(2, deposit);
				cs.registerOutParameter(3, java.sql.Types.DECIMAL);
				cs.execute();
				accounts.setAccountBalance(accounts.getAccountBalance() + cs.getDouble(3)); 			
			}catch (SQLException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("Please enter a number greater than 0 or less than 500.");
		}
	}
	
	@Override
	public double getCurrentBalance(int accountId) throws AccountNotFoundException {  
		double accountBalance = 0;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			accountBalance = rs.getDouble("ACCOUNT_BALANCE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountBalance;
	}
}

