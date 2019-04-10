package com.revature.project.main;


import java.util.Scanner;

//import javax.swing.BorderFactory;
//import javax.swing.JPanel;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;



public class Access { //may need to be final
	
	private static BankUser user;
	private Accounts a;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		BankUser user = new BankUser();
		Accounts a = new Accounts();
		
		Scanner scan = new Scanner(System.in);
		userEntry(scan);
		
	}
	
	private static void userEntry(Scanner scan) {
	

				System.out.println("                                        		           ");
				System.out.println("                                             		       ");
				System.out.println("    	*-------------------------------------------------*");
				System.out.println("        *                        *                        *");
				System.out.println("        *                       * *                       *");
				System.out.println("        *                                                 *");
				System.out.println("        *        Welcome to our Banking Application!      *");
				System.out.println("        *                                                 *");
				System.out.println("        *    	  1. LOGIN TO USER ACCOUNT             	  *");
				System.out.println("        *    	  2. LOGIN TO MANAGER ACCCOUNT            *");
				System.out.println("        *     	  3. EXIT BANKING APPLICATION             *");
				System.out.println("        *                                                 *");
				System.out.println("        *-------------------------------------------------*");
				System.out.println("                     PLEASE INPUT A NUMBER");  
		int txt = scan.nextInt();
		//BankUserDaoImp ud = new UserDaoImp();
	    switch (txt) {
	    case 1:
	    	System.out.println("You have selected User Login");
	    	
	    	break;
	    case 2:
	    	System.out.println("You have selected Manager Login");
	    	//managerLogin();
	    	break;
	    case 3:
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    default:
	    	System.out.println("Please select either 1 or 2");
	    }
	    	 
	
	    }
	  
//	   public static void userLogin(String uLogin) {
//	    System.out.println("Please Enter Username");
//	    Scanner user = new Scanner(System.in);
//	    String username = user.nextLine();
//	    //String a = BankUserDaoImp.getUserName; 
//	    switch(username) {
//	    	case a://correct username
//	    		System.out.println("Welcome" + username);
//	    		//userPassword()
//	    	case b:
//	    		System.out.println("Incorrect Password. Please try again or contact Manager");
//	    }
//		   
//	    public void managerLogin() {
//	    	
//	    }
//	  public static BankUser getUserId() {
//		  return user;
//	  }
		
	
}
