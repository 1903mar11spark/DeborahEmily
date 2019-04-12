package com.revature.project.main;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	    	managerLogin(scan);
	    	break;
	    case 3:
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    	scan.close();
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

	private static void userMainMenu(BufferedReader scan) throws NumberFormatException, IOException {
		Sections.thirdSection();
		int txt = Integer.parseInt(scan.readLine());
	    switch (txt) {
	    case 1://go to savings account
	    	System.out.println("You have selected Savings Account");
	    	//goToSavings(scan);
	    	break;
	    case 2://go to checking account
	    	System.out.println("You have selected Checking Account");
	    	//goToChecking(scan);
	    	break;
	    case 3://make a new account
	    	System.out.println("You have selected to make a New Account");
	    	goCreateAccount(scan);
	    	break;
	    case 4: //exit banking application
	    	System.out.println("You have selected to Exit the Application. Goodbye!");
	    	scan.close();
	    	break;
	    default:
	    	System.out.println("Please select either 1, 2, or 3");
	    }
		
	}

	private static void goCreateAccount(BufferedReader scan) throws NumberFormatException, IOException {
		System.out.println("Please Enter Your UserId");
    	int userId = Integer.parseInt(scan.readLine());
    	System.out.println("Enter Either Savings or Checking Type");
    	String typeId = scan.readLine();
    	if (typeId.equals("Savings") || typeId.equals("Checking")) {
    		acd.createAccount(userId, typeId);
    		System.out.println("New Account Generated");
    		System.out.println("TYPE 0 TO RETURN TO MENU");
	    	int txt1 = Integer.parseInt(scan.readLine());
	    		if (txt1 == 0) {
	    			userMainMenu(scan);
	    		}
    	} else {
    		System.out.println("Invalid Account Type - Try Again");
    		goCreateAccount(scan);
    	}  	
	}
	
//	private static void goToSavings(BufferedReader scan) {
//		Sections.fourthSection();
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
//		
//	}
	
//	private static void goToChecking(BufferedReader scan) {
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
	//Manager Methods
	
//getUserAccountsByLogin --Gets account 
  
	private static void managerLogin(BufferedReader scan) throws IOException {
		System.out.println("Please Enter Manager Username");
		String userMan = scan.readLine();
		System.out.println("Please Enter Manager Password");
		String passMan = scan.readLine();
		
		String x = ("/Users/Em/Desktop/Pro0/DeborahEmily/project0/src/main/java/com/revature/project/main/Connections.properties");
		Properties prop = new Properties();
		InputStream in = new FileInputStream(x);
		prop.load(in);
		     
		String manager = prop.getProperty("Manager");
		String manpass = prop.getProperty("Password");
		  
		if(userMan.equals(manager) && passMan.contentEquals(manpass)) {
		    	  managerMainMenu(scan);
		      } else {
		    	  System.out.println("Invalid Credentials Please Type 0 to Try Again or 1 to Main Menu");
		    	  int back = Integer.parseInt(scan.readLine());
		    	  if(back == 0) {
		    		  managerLogin(scan);
		    	  } else if (back == 1) {
		    		  try {
						userEntry(scan);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (UserNotFoundException e) {
						e.printStackTrace();
					}
		    	  }
		      }
				  
	}
	
	
	private static void managerMainMenu(BufferedReader scan) throws IOException {
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
	    	
	    	
	    	System.out.println("Enter New User Username");
	    	String newUser = scan.readLine();
	    	System.out.println("Enter New User Password");
	    	
	    	int newPass = Integer.parseInt(scan.readLine());
	    	System.out.println("The New User Username and Password are: {"+newUser+ "} {" +newPass+ "}is this correct? 1. Yes or 2. No");
	    	int checking = Integer.parseInt(scan.readLine());
	    	if(checking == 1) {
	    		BankUser bu = new BankUser(newUser, newPass);
	    		bud.createUser(bu);
	    		System.out.println("New User Has Been Created");
	    		System.out.println("Select 1 to Return to Main Menu or 2 to Exit Application");
	    		int out = Integer.parseInt(scan.readLine());
	    		if(out == 1) {
	    			managerMainMenu(scan);
	    		} else if (out == 2) {
	    			System.out.println("You have exited the application -- Goodbye");
	    			scan.close();
	    		}
	    	}else {
	    		managerMainMenu(scan);
	    	}
	    	break;
	    case 4: //update user
	    	System.out.println("You have selected to Update an Existing User");
	    	//updateExistingUser();
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
				try {
					bud.deleteUser(userId);
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
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
	    	scan.close();
	    	break;
	    default:
	    	System.out.println("Please select select a number 1 through 5");
	    }
	    
	}

}
	
	
