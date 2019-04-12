package com.revature.project.main;


import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
//import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.project.beans.Accounts;

//import javax.swing.BorderFactory;
//import javax.swing.JPanel;

import com.revature.project.beans.Accounts;
import com.revature.project.beans.BankUser;
import com.revature.project.dao.AccountDAOImpl;
import com.revature.project.dao.BankUserDAO;
import com.revature.project.dao.BankUserDAOImpl;
import com.revature.project.dao.TransactionHistoryDAOImpl;
import com.revature.project.exceptions.UserNotFoundException;



public class Access {
	
	
	
	public static String xFile = "/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connections.properties";
	public static AccountDAOImpl acd = new AccountDAOImpl();
	static TransactionHistoryDAOImpl thd = new TransactionHistoryDAOImpl();
	static BankUserDAOImpl bud = new BankUserDAOImpl();
	static Sections section = new Sections();

	
	public static void main(String[] args)  { 
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		try {
			entry(scan);
		} catch (NumberFormatException | UserNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
		
		//throws UserNotFoundException, NumberFormatException, IOException {
//		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("type here fool");
//		
//		int accountId = Integer.parseInt(sc.readLine());
//		
//		double deposit = Double.parseDouble(sc.readLine());
//		AccountDAOImpl acd = new AccountDAOImpl();
//		
//		acd.updateAccountByDeposit(accountId, deposit);
//		Scanner scan = new Scanner(System.in);
//		int userId = scan.nextInt();
//		String accountType = scan.nextLine();
		
		//acd.deleteAccount(userId);
		
		//acd.createAccount(userId, accountType);
//		scan.close();
		
		
		
		
//		List<Accounts> accountsList = acd.getAccounts();
//		for(Accounts a: accountsList) {
//	
//		System.out.println(a);
//		}
		
//
//		AccountDAOImpl acd = new AccountDAOImpl();
//		int userId = 9999;
//		
//			try {
//				System.out.println(acd.getCurrentBalance(userId));
//			} catch (AccountNotFoundException e) {
//				
//				e.printStackTrace();
//			}
//			

	
	public static void entry(BufferedReader scan) throws UserNotFoundException, NumberFormatException, IOException {
		Sections.firstSection();
		userEntry(scan);
	}
	
	public static void userEntry(BufferedReader scan) throws UserNotFoundException, NumberFormatException, IOException {
		int txt = Integer.parseInt(scan.readLine());
	    switch (txt) {
	    case 1:
	    	userLogin(scan);
	    	break;
	    case 2:
	    	System.out.println("You have selected Manager Login");
	    	//managerLogin(scan);
	    	break;
	    case 3:
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    	//userEntry(scan);
	    	break;
	    default:
	    	System.out.println("Please select either 1, 2, or 3");
	    }
	 
	}

	//User Methods
	public static void userLogin(BufferedReader scan) throws UserNotFoundException, IOException {
		System.out.println("                       USER LOGIN                       ");
		System.out.println("Please Enter Username");
		String user = scan.readLine();
		System.out.println("Please Enter Password");
		int password = Integer.parseInt(scan.readLine());
		if(bud.getUser(user, password) != null){
			userMainMenu(scan);
		};

	}

//	public static void getUserAccounts(BufferedReader sc) throws NumberFormatException, IOException {
//		System.out.println("Please Enter Username and Password");
//		String username = sc.readLine();
//		int password = Integer.parseInt(sc.readLine());
//		if (!username.isEmpty() && password > 0) {
//		acd.getUserAccountsByLogin(username, password);
//		}
//	}
	


	private static void userMainMenu(BufferedReader scan) throws NumberFormatException, IOException {
		Sections.thirdSection();
		int txt = Integer.parseInt(scan.readLine());
	    switch (txt) {
	    case 1://go to savings account
	    	System.out.println("You have selected User Login");
	    	goToSavings();
	    	break;
	    case 2://go to checking account
	    	System.out.println("You have selected Manager Login");
	    	goToChecking();
	    	break;
	    case 3://make a new account
	    	System.out.println("You have selected to make a New Account");
	    	createAccount();
	    	break;
	    case 4: //exit banking application
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    	break;
	    default:
	    	System.out.println("Please select either 1, 2, or 3");
	    }
		
	}
}
//	
//	//User Selected Methods
//	
//	//balance 
//	
//	
//	
//	
//	
	private static void goToSavings() {
		Sections.fourthSection();
		
		System.out.println("YOUR CURRENT BALANCE IS: "+balance);//need to write code for balance
		int txt = scan.nextInt();
	    switch (txt) {
	    case 1://deposit
	    	System.out.println("You have selected to Make a Deposit");
	    	goToSavings();
	    	break;
	    case 2://withdraw
	    	System.out.println("You have selected to Make a Withdrawl");
	    	goToChecking();
	    	break;
	    case 3://transaction history
	    	System.out.println("You have selected to Review Transaction History");
	    	createAccount();
	    	break;
	    case 4: //close account
	    	System.out.println("You have selected to Close an Account");
	    	break;
	    case 5://main menu
	    	System.out.println("You have selected to Return to Main Menu");
	    	userMainMenu(null); //-----------------------------------------------need to redirect with actual param
	    	break;
	    case 6://exit 
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    	break;
	    default:
	    	System.out.println("Please select a number 1 through 4");
	    }
		
	}
//	
//	private static void goToChecking() {
//		Sections.fifthSection();
//		balance = get
//				
//		System.out.println("YOUR CURRENT BALANCE IS: "+balance);//need to write code for balance
//		int txt = scan.nextInt();
//	    switch (txt) {
//	    case 1://deposit
//	    	System.out.println("You have selected to Make a Deposit");
//	    	goToSavings();
//	    	break;
//	    case 2://withdraw
//	    	System.out.println("You have selected to Make a Withdrawl");
//	    	goToChecking();
//	    	break;
//	    case 3://transaction history
//	    	System.out.println("You have selected to Review Transaction History");
//	    	createAccount();
//	    	break;
//	    case 4: //close account
//	    	System.out.println("You have selected to Close an Account");
//	    	break;
//	    case 5://main menu
//	    	System.out.println("You have selected to Return to Main Menu");
//	    	userMainMenu(null); //-----------------------------------------------need to redirect with actual param
//	    	break;
//	    case 6://exit 
//	    	System.out.println("You have selected to Exit the Application. Goodbye!");
//	    	break;
//	    default:
//	    	System.out.println("Please select a number 1 through 4");
//	    }
//	}
//	
//	private static void createAccount() {
//		Sections.sixthSection();
//		int txt = scan.nextInt();
//	    switch (txt) {
//	    case 1://create new savings account
//	    	System.out.println("You have selected to Create a New Savings Account");
//	    	goToSavings();
//	    	break;
//	    case 2://create new checking account
//	    	System.out.println("You have selected to Create a New Checking Account");
//	    	goToChecking();
//	    	break;
//	    case 3://return to main menu
//	    	System.out.println("You have selected to Return to Main Menu");
//	    	userMainMenu(null); //---------------------------------------------------------------another to redirect wiht actual param
//	    	break;
//	    case 4: //exit banking application
//	    	System.out.println("You have selected to Exit the Application. Goodbye!");
//	    	break;
//	    default:
//	    	System.out.println("Please select a number 1 through 4");
//	    }
//	}
//
//	
//	
//	//Manager Methods
//	
//	//getUserAccountsByLogin --Gets account 
//	   
	private static void managerLogin(BufferedReader scan) {
		System.out.println("Please Enter Manager Username");
		String userMan = scan.readLine();
		System.out.println("Please Enter Manager Password");
		String passMan = scan.readLine();
		
		
		Properties prop = new Properties();
		InputStream file = null;
		  
		 
		      
			  file = new FileInputStream("/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connections.properties");
		     
			  prop.load(file);
		     
		      manager = prop.getProperty("Manager");
		      manpass = prop.getProperty("Password");
		  
		      if(userMan.equals(manager) && passMan.contentEquals(manpass)) {
				  
	
		

	
	
	private static void managerMainMenu(BufferedReader scan) {
		Sections.seventhSection();
		int txt = Integer.parseInt(scan.readLine());
	    switch (txt) {
	    case 1: //view user
	    	System.out.println("You have selected to View All User Information");
	    	List<BankUser> aList = bud.getUsers();
	    		for(BankUser b: aList) {
	    			System.out.println(b);
	    		}
	    	System.out.println("ALL INFORMATION LOADED TYPE 0 TO RETURN TO MENU");
	    	int txt1 = Integer.parseInt(scan.readLine());
	    		if (txt1 == 0) {
	    			managerMainMenu(scan);
	    		}
	    	break;
	    case 2: //view accounts
	    	System.out.println("You have selected to View All Account Information");
	    	List<Accounts> accountsList = acd.getAccounts();
	    		for(Accounts a: accountsList) {
	    			System.out.println(a);
	    		}
	    	
	    	System.out.println("ALL INFORMATION LOADED TYPE 0 TO RETURN TO MENU");
	    	int txt2 = Integer.parseInt(scan.readLine());
	    		if (txt2 == 0) {
	    			managerMainMenu(scan);
	    		}
	    case 3: //create user
	    	System.out.println("You have selected to Create a New User");
	    	createNewUser();
	    	break;
	    case 4: //update user
	    	System.out.println("You have selected to Update an Existing User");
	    	updateExistingUser();
	    	break;
	    case 5://delete user
	    	System.out.println("You have selected to Delete an Existing User");
	    	System.out.println("Please Enter User ID");
			int userId = Integer.parseInt(scan.readLine());
			System.out.println("*******ARE YOU SURE YOU WANT TO DELETE THIS USER*******");
			System.out.println("*********************"+userId+"************************");
			System.out.println("***************  1. YES       2. NO  ******************");
			int yn = Integer.parseInt(scan.readLine());
			if (yn == 1) { 
				bud.deleteUser(userId);
				System.out.println("USER HAS BEEN DELETED");
				System.out.println("TYPE 0 TO RETURN TO MENU");
		    	int txt3 = Integer.parseInt(scan.readLine());
		    	if (txt3 == 0) {
		    		managerMainMenu(scan);
		    	}
			}else {
				managerMainMenu(scan);
			}
	    	break;
	    case 6://exit application
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    	break;
	    default:
	    	System.out.println("Please select select a number 1 through 5");
	    }
	    
	}

	// Manager Selected Methods
	
	private static void viewUserInfo() {
		bud.getAllUsers();
	}
	
	private static void createNewUser() {
		System.out.println("Please Enter New Username For User");
		String newUser = scan.nextLine();
		System.out.println("***********IS THIS THE CORRECT USERNAME SELECTED *******");
		System.out.println("*********************"+newUser+"************************");
		System.out.println("***************  1. YES       2. NO  ******************");
		int yn = scan.nextInt();
		if (yn == 1) { 
			
			
			//intiate delete call to BankUser delete
			
		}else {
			managerMainMenu(null);//------------------------------------------verification param
		}
		
	}
	
//	private static void updateExistingUser() {//------------------------------need to create an update method
//		System.out.println("Please Enter User ID");
//		String userId = scan.nextLine();
//		System.out.println("*******ARE YOU SURE YOU WANT TO UPDATE THIS USER*******");
//		System.out.println("*********************"+userId+"************************");
//		System.out.println("***************  1. YES       2. NO  ******************");
//		int yn = scan.nextInt();
//		if (yn == 1) { //intiate delete call to update username/password etc
//			
//		}else {
//			managerMainMenu(null);//------------------------------------------verification param
//		}
//		
//	}
	
	private static void deleteExistingUser(BufferedReader scan) {
		System.out.println("Please Enter User ID");
		int userId = Integer.parseInt(scan.readLine());
		System.out.println("*******ARE YOU SURE YOU WANT TO DELETE THIS USER*******");
		System.out.println("*********************"+userId+"************************");
		System.out.println("***************  1. YES       2. NO  ******************");
		int yn = Integer.parseInt(scan.readLine());
		if (yn == 1) { 
			bud.deleteUser(userId);
			System.out.println("USER HAS BEEN DELETED");
			
			managerMainMenu(scan);
		}else {
			managerMainMenu(scan);
		}
		
	}
}
	
	
