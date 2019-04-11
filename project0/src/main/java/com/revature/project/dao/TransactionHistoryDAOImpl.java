package com.revature.project.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.TransactionHistory;
import com.revature.project.exceptions.AccountNotFoundException;
import com.revature.project.util.ConnectionUtil;

public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

	@Override
	public List<TransactionHistory> getTransactionHistory(int accountId) throws AccountNotFoundException {
		List<TransactionHistory> history = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT T.TRASANCTION_ID, T.ACCOUNT_ID FROM TRANSACTION T WHERE T.ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				AccountDAOImpl ad = new AccountDAOImpl();
				Accounts account = ad.getAccountById(accountId);
				history.add(new TransactionHistory(account));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double updateBalanceWithdraw(double withdraw) {
		//callable
		
		return 0;
	}

	@Override
	public double updateBalanceDeposit(double deposit) {
		//callable
		
		return 0;
	}

}
