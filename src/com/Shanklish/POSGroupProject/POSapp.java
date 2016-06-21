package com.Shanklish.POSGroupProject;
import java.util.Scanner;
public class POSapp {
	
	//instantiating objects
	static Scanner scan = new Scanner(System.in);
	//declaring variables
	static boolean shop = false;

	public static void main(String[] args) {
		System.out.println("Hello. Welcome to your neighborhood grocery story\n");
		System.out.println("Here is a list of the current items we have in stock\n");
	//NEEDS TO PRINT FROM FILE THE LIST OF STOCK
		
		
	shop =Validator.getYesNo(scan, "Would you like to make a purchase?\n");
	
	
	
		while (shop){
		
			System.out.println("poo");
			
			
			
			
			
			shop =  Validator.getYesNo(scan, "Would you like to add anything else to your cart?");
		}
		
		
		
		
		
		
		
		
		scan.close();
	}
	
	
	

}
