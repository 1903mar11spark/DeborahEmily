package com.revature.project.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.project.util.ConnectionUtil;


public class Driver {

	public static void main(String[] args) {
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connection.properties");
			System.out.println(con);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	//possible call back to access
		
		}

}
