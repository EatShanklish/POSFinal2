package com.Shanklish.POSGroupProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class angelaTest {

	public static void main(String[] args) throws IOException 
	{
	    Scanner scan = new Scanner(System.in);
	    ArrayList<Product> purchaseList = new ArrayList<Product>();
	    
	    System.out.println("Welcome to the store. Below is the list of our items.");
		
		
			
		
		
	
			    
	
			    Product coke = new Product("Coke", "Beverage", "Can of Coke", 2);
			    purchaseList.add(coke);
			
			    
			
			    Product sprite = new Product("Sprite", "Beverage", "Can of Sprite", 2);
			    purchaseList.add(sprite);
			  
			    
		
			    Product dew = new Product("Mountain Dew", "Beverage", "Can of Dew", 2);
			    purchaseList.add(dew);
			
			    
		
			   System.out.println(purchaseList.get(0).getPrice());
		
	
		
	}

}
