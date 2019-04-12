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
import com.revature.project.beans.TransactionHistory;
import com.revature.project.exceptions.AccountNotFoundException;
import com.revature.project.exceptions.OverdraftException;
import com.revature.project.util.ConnectionUtil;

public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

	public static String x = "/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connections.properties";
	
	@Override
	public List<TransactionHistory> getTransactionHistory(int accountId) throws AccountNotFoundException{
		List<TransactionHistory> history = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
			String sql = "SELECT T.TRASANCTION_ID, T.ACCOUNT_ID, T.ACCOUNT_ID FROM TRANSACTION T WHERE T.ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Accounts account = new Accounts();
				accountId = rs.getInt("ACCOUNT_ID");
				account.setAccountId(accountId);
				history.add(new TransactionHistory(account));
			}
			throw new AccountNotFoundException();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateBalanceWithdraw(int accountId, double withdraw) {
		if(withdraw > 0) {
			try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
				String sql = "{call WITHDRAW_SP(?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, accountId);
				cs.setDouble(2, withdraw);
				cs.execute();		
				throw new OverdraftException();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Please enter a positve number.");
		}
	}

	@Override
	public void updateBalanceDeposit(int accountId, double deposit) {
		if(deposit > 0 && deposit < 500) {
			try (Connection con = ConnectionUtil.getConnectionFromFile(x)){
				String sql = "{call DEPOSIT_SP(?,?)}";  
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, accountId);
				cs.setDouble(2, deposit);
				cs.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("Please enter a number greater than 0 or less than 500.");
		}
		
	}

}