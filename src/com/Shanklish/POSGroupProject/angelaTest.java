package com.Shanklish.POSGroupProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class angelaTest {

	public static void main(String[] args) throws IOException 
	{
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("Welcome to the store. Below is the list of our items.");
		
	    Pay.viewProducts();
	    Pay.welcomeMenu();
	    Pay.pickPaymentType(scan);
	    
		
		
	}

}
