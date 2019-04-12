package com.revature.project.dao;


import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.util.ConnectionUtil;
import com.revature.project.exceptions.*;

public class AccountDAOImpl implements AccountDAO {

	public static String x = "/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connections.properties";

	@Override
	public void updateAccountByWithdraw(int accountId, double withdraw) throws AccountNotFoundException {
		if(withdraw > 0) {
			try (Connection con = ConnectionUtil.getConnection()){
				String sql = "{call WITHDRAW_SP(?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, accountId);
				cs.setDouble(2, withdraw);
				cs.execute();		
				throw new AccountNotFoundException();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Please enter a positve number.");
		}
	}

	@Override
	public void updateAccountByDeposit(int accountId, double deposit) throws AccountNotFoundException {
		if(deposit > 0 && deposit < 500) {
			try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
				String sql = "{call DEPOSIT_SP(?,?)}";  
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, accountId);
				cs.setDouble(2, deposit);
				cs.execute();
				throw new AccountNotFoundException();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("Please enter a number greater than 0 or less than 500.");
		}
	}
	
	@Override
	public void createAccount(int userId, String accountType) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
			String sql = "INSERT INTO ACCOUNTS (USER_ID, ACCOUNTS_TYPE) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId );
			pstmt.setString(2, accountType );
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Accounts> getAccounts() {
			List<Accounts> a = new ArrayList<>();
			try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
				String sql = "SELECT ACCOUNT_ID, ACCOUNTS_TYPE, ACCOUNT_BALANCE FROM ACCOUNTS";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(sql);
				while (rs.next()) {
					String type = rs.getString("ACCOUNTS_TYPE");
					double balance = rs.getDouble("ACCOUNT_BALANCE");
					int aId = rs.getInt("ACCOUNT_ID");
					a.add(new Accounts(type, balance, aId));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			return a;
	}

	@Override
	public double getCurrentBalance(int accountId) throws AccountNotFoundException {
		double balance = 0;
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
			String sql = "SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				double accountBalance = rs.getDouble("ACCOUNT_BALANCE");
				balance = accountBalance;
			} throw new AccountNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		return balance;
	}


	@Override
	public void deleteAccount(int accountId) throws AccountNotFoundException {
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
			String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			pstmt.executeUpdate();
			throw new AccountNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}		


//	}
//	@Override //NEEDS REMEDIED
//	public List<Accounts> getUserAccountsByLogin(String username, int password) throws IOException {
//		List<Accounts> accounts = new ArrayList<>();
//		try (Connection con = ConnectionUtil.getConnectionFromFile(x);){
//			String sql = "SELECT A.ACCOUNT_ID, A.ACCOUNTS_TYPE, U.USER_ID " + 
//					"FROM ACCOUNTS A " + 
//					"INNER JOIN BANK_USER U " + 
//					"ON A.USER_ID = U.USER_ID " + 
//					"WHERE U.USERNAME=? "+//AND U.USERPASSWORD=? " + 
//					"ORDER BY A.ACCOUNT_ID;";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,  username);
//			//pstmt.setInt(2, password);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				int userId = rs.getInt("USER_ID");
//				String accountType = rs.getString("ACCOUNTS_TYPE");
//				accounts.add(new Accounts(new BankUser(userId, username, password),accountType));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return accounts;
//	}
//	//fix here


