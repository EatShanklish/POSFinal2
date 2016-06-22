package com.Shanklish.POSGroupProject;

import java.io.IOException;
import java.util.Scanner;

public class angelaTest 
{

	public static void main(String[] args) throws IOException 
	{
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("\n");
	    System.out.println("\t\tGRAND GENERAL STORE\t\t");
	    System.out.println("\t\t=================== " + "\n");
		
	    Pay.viewProducts();
	    Pay.welcomeMenu();
	    Pay.pickPaymentType(scan);
	    
		
		
	}

}
