package com.revature.project.main;

import java.util.Scanner;

public class Access {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to our Banking Applictaion");
		System.out.println("Please Select a Number: 1. User Login | 2. Manager Login");
		Scanner enter = new Scanner(System.in);  
		int txt = enter.nextInt();
	    switch (txt) {
	    case 1:
	    	System.out.println("You have selected User Login");
	    	//userLogin();
	    	break;
	    case 2:
	    	System.out.println("You have selected Manager Login");
	    	//managerLogin();
	    	break;
	    default:
	    	System.out.println("Please select either 1 or 2");
	    	 
	    	
	    }
	   
	   public void userLogin() {
	    System.out.println("Please Enter Username");
	    Scanner user = new Scanner(System.in);
	    String username = user.nextLine();
	    //String a = BankUserDaoImp.getUserName; 
	    switch(username) {
	    	case a://correct username
	    		System.out.println("Welcome" + username);
	    	case b:
	    		System.out.println("Incorrect Password. Please try again or contact Manager");
	    }
		   
	   //}
	    
	    //public void managerLogin() {
	    	
	    //}
	  
		
	}
}
