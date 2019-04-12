package com.revature.project.main;


//import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.project.beans.Accounts;

//import javax.swing.BorderFactory;
//import javax.swing.JPanel;

//import com.revature.project.beans.Accounts;
//import com.revature.project.beans.BankUser;
import com.revature.project.dao.AccountDAOImpl;
//import com.revature.project.dao.BankUserDAO;
import com.revature.project.dao.BankUserDAOImpl;
import com.revature.project.dao.TransactionHistoryDAOImpl;
import com.revature.project.exceptions.UserNotFoundException;



public class Access {
	
	
	
	public static Scanner scan = new Scanner(System.in);
	//static AccountDAOImpl acd = new AccountDAOImpl();
	static TransactionHistoryDAOImpl thd = new TransactionHistoryDAOImpl();
	static BankUserDAOImpl bud = new BankUserDAOImpl();
	static Sections section = new Sections();
	
//	static ArrayList<BankUser> userList = new ArrayList<User>();
//	static ArrayList<Account> accountList = new ArrayList<Account>();
	
	public static void main(String[] args) throws UserNotFoundException, NumberFormatException, IOException {
//		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//		//String username = sc.readLine();
//		int password = Integer.parseInt(sc.readLine());
		AccountDAOImpl acd = new AccountDAOImpl();
		List<Accounts> accountsList = acd.getAccounts();
		for(Accounts a: accountsList) {
			System.out.println(a);
		}
	}
	
}	
//	public static void entry(BufferedReader sc) throws UserNotFoundException, NumberFormatException, IOException {
//		Sections.firstSection();
//		userEntry(sc);
//	}
//	
//	public static void userEntry(BufferedReader sc) throws UserNotFoundException, NumberFormatException, IOException {
//		int txt = Integer.parseInt(sc.readLine());
//	    switch (txt) {
//	    case 1:
//	    	System.out.println("You have selected User Login");
//	    	getUserAccounts(sc);
//	    	break;
//	    case 2:
//	    	System.out.println("You have selected Manager Login");
//	    	//managerLogin();
//	    	break;
//	    case 3:
//	    	System.out.println("You have selected to Exit the Application. Goodbye!");
//	    	//userEntry(Scanner sc);
//	    	break;
//	    default:
//	    	System.out.println("Please select either 1, 2, or 3");
//	    }
//	 
//	}

	//User Methods
//	public static void userLogin(Scanner sc) throws UserNotFoundException {
//		System.out.println("Please Enter Username");
//		String user = scan.nextLine();
//		System.out.println("Your username is " + user;
//		System.out.println("Please Enter Password");
//		String password = scan.nextLine();
//		//acd.getUserAccountsByLogin(a, password);
//	
//	}
	
//	public static void getUserAccounts(BufferedReader sc) throws NumberFormatException, IOException {
//		System.out.println("Please Enter Username and Password");
//		String username = sc.readLine();
//		int password = Integer.parseInt(sc.readLine());
//		if (!username.isEmpty() && password > 0) {
//		acd.getUserAccountsByLogin(username, password);
//		}
//	}
	
////		if (!(user.isEmpty())) {
////			BankUser confirmUser = bud.getUsername(user);
////				if (confirmUser.getPassword() == password) {
////					
////						System.out.println("Password was correct");
////						userMainMenu(confirmUser);
////					} else {
////						System.out.println("Password was incorrect. Please try again.");
////						userLogin();
////					}
////				} else {
////					System.out.println("Username does not exist - try again or contact manager for account creation.");
////					entry();
////				}
////			} else {
////				System.out.println("Account could not be found");
////				userLogin();
////			}		
//	
//	   
//
//	private static void userMainMenu(BankUser confirmUser) {
//		BankUser
//		Sections.thirdSection();
//		int txt = scan.nextInt();
//	    switch (txt) {
//	    case 1://go to savings account
//	    	System.out.println("You have selected User Login");
//	    	goToSavings();
//	    	break;
//	    case 2://go to checking account
//	    	System.out.println("You have selected Manager Login");
//	    	goToChecking();
//	    	break;
//	    case 3://make a new account
//	    	System.out.println("You have selected to make a New Account");
//	    	createAccount();
//	    	break;
//	    case 4: //exit banking application
//	    	System.out.println("You have selected to Exit the Application. Goodbye!");
//	    	break;
//	    default:
//	    	System.out.println("Please select either 1, 2, or 3");
//	    }
//		
//	}
//	
//	//User Selected Methods
//	
//	//balance 
//	
//	
//	
//	
//	
//	private static void goToSavings() {
//		Sections.fourthSection();
//		balance = getCurrentBalance()
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
//	private static void managerLogin() {
//		System.out.println("Please Enter Username");
//		String username = scan.nextLine();
//		System.out.println("Please Enter Password");
//		String password = scan.nextline();
//		String pass = password.replaceAll("\\W+", "");
//		if (!(username.isEmpty() | pass.isEmpty())) {
//			BankUser confirmMan = bud.getUsername(username);
//				if (confirmMan.getUserId() != 0) {
//					if (confirmMan.getPassword() == pass) {
//						System.out.println("Password was correct. Welcome Manager.");
//						managerMainMenu(confirmMan);
//					} else {
//						System.out.println("Password was incorrect. Please try again.");
//						userLogin();
//					}
//				} else {
//					System.out.println("Username does not exist - try again or contact manager for account creation.");
//					entry();
//				}
//			} else {
//				System.out.println("Account could not be found");
//				userLogin();
//			}		
//	}   
//	
//	private static void managerMainMenu(BankUser confirmMan) {
//		Sections.seventhSection();
//		int txt = scan.nextInt();
//	    switch (txt) {
//	    case 1: //view user
//	    	System.out.println("You have selected to View All User Information");
//	    	viewUserInfo();
//	    	break;
//	    case 2: //create user
//	    	System.out.println("You have selected to Create a New User");
//	    	createNewUser();
//	    	break;
//	    case 3: //update user
//	    	System.out.println("You have selected to Update an Existing User");
//	    	updateExistingUser();
//	    	break;
//	    case 4://delete user
//	    	System.out.println("You have selected to Delete an Existing User");
//	    	deleteExistingUser();
//	    	break;
//	    case 5://exit application
//	    	System.out.println("You have selected to Exit the Application. Goodbye!");
//	    	break;
//	    default:
//	    	System.out.println("Please select select a number 1 through 5");
//	    }
//	    
//	}
//
//	// Manager Selected Methods
//	
//	private static void viewUserInfo() {
//		bud.getAllUsers();
//	}
//	
//	private static void createNewUser() {
//		System.out.println("Please Enter New Username For User");
//		String newUser = scan.nextLine();
//		System.out.println("***********IS THIS THE CORRECT USERNAME SELECTED *******");
//		System.out.println("*********************"+newUser+"************************");
//		System.out.println("***************  1. YES       2. NO  ******************");
//		int yn = scan.nextInt();
//		if (yn == 1) { 
//			
//			
//			//intiate delete call to BankUser delete
//			
//		}else {
//			managerMainMenu(null);//------------------------------------------verification param
//		}
//		
//	}
//	
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
//	
//	private static void deleteExistingUser() {
//		System.out.println("Please Enter User ID");
//		String userId = scan.nextLine();
//		System.out.println("*******ARE YOU SURE YOU WANT TO DELETE THIS USER*******");
//		System.out.println("*********************"+userId+"************************");
//		System.out.println("***************  1. YES       2. NO  ******************");
//		int yn = scan.nextInt();
//		if (yn == 1) { 
//			BankUser deleteUser = bud.get(u);
//			
//		}else {
//			managerMainMenu(null);//------------------------------------------verification param
//		}
//		
//	}
//	
	
