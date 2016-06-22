package com.Shanklish.POSGroupProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pay 
{
	protected static double subTotal;
	protected static double tax;
	protected static double grandTotal;
	protected static int amount = 0;
	    
	public static ArrayList<Product> purchaseList = new ArrayList<Product>();
	
	 public Pay()
	 {  
	        subTotal = 0;
	        tax = 0;
	        grandTotal = 0;
  
	 }
	 
	 public static void finalTotals()			//Prints all calculations to screen
	 {
	     	double sub = Pay.calcSubTotal(purchaseList);
	     	
		double tax = Pay.calcTax(sub);
		
		BigDecimal taxes = new BigDecimal(tax);
		taxes = taxes.setScale(2, RoundingMode.HALF_UP);
		
		 System.out.println("\n");
		
		System.out.println("Reciept: ");
		System.out.println("\n");
		System.out.println("Item" + "\t" + "Quantity" + "\t" + "Price");
		System.out.println("----" + "\t" + "--------" + "\t" + "-----");
		
		for(int i = 0; i < purchaseList.size(); i++)
		    {
			
			System.out.println(purchaseList.get(i).getName() + "\t  " + "x"+ purchaseList.get(i).getQuantity() + "\t         $" + purchaseList.get(i).getPrice());
		    }
		
		System.out.println("\n");
		
		System.out.println("Subtotal: $" + sub );
		
		System.out.println("Sales Tax: $" + taxes);
		
		System.out.println("Grand Total: $" + Pay.grandTotal(tax, sub) + "\n");
		
		
	    }
	    
	    
	     public static double getTax()			//returns Tax
	    {    
	        return tax;
	    }	     public static double getGrandTotal()		//returns Grand Total
	    {    
	        return grandTotal;
	    }
	     public static double getSubTotal()			//returns Sub Total
	    {
	        return subTotal;
	    }
	    
	
	 public static double calcSubTotal(ArrayList<Product> list)	//Calculates Sub Total
	 {
		for( int i = 0; i < list.size(); i++) 
			 subTotal += list.get(i).getPrice();
		
		return subTotal;
	}

	
	static public double calcTax(double subTotal)			//Calculates tax
	{
		tax = subTotal * 0.06;
		
		return tax;
	}
	
	static public double grandTotal(double tax, double subTotal)	//Calculates Grand Total
	{	
		grandTotal = tax + subTotal;
		return grandTotal;
	}
	
	
	
	
	
	public static void viewProducts() throws IOException		//Will print all the items into the console as a menu
	{
	    String fileName = "Groceries.txt";
	    String line = null;
	   
	    
	    FileReader fileReader = new FileReader(fileName);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    
	    while( (line = bufferedReader.readLine()) != null)
		{
		    System.out.println(line);
		}
	    
	    bufferedReader.close();
	    fileReader.close();
	}

	
	
	
	
	public static void writeReciept(ArrayList<Product> p) throws IOException	//Writes itemsPurchased, all calculations etc to a text file.
	{
	    Files.delete(Paths.get("emptyText.txt"));
	    File file = new File("emptyText.txt");
	    file.createNewFile();
	   
	    FileWriter fileWriter = new FileWriter(file, true);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
	    
	    bufferedWriter.append("Grand Circus General Store " + "\n");
	    bufferedWriter.append("-------------------------" + "\n");
	    bufferedWriter.append("Product" + "\t \t" + "Quantity" + "\t\t" + "Price" + "\n");
	    
	    for(int i = 0; i < p.size(); i++)
		{
		    bufferedWriter.append("\n");
		    bufferedWriter.append((p.get(i).getName() + "\t \t" +  p.get(i).getQuantity() + "\t\t"+p.get(i).getPrice()));
		    bufferedWriter.append("\n");	    
		}
	    
	    bufferedWriter.append("===================================" + "\n");
	    bufferedWriter.append("\n");
	    bufferedWriter.append("" + Pay.calcSubTotal(purchaseList) + " is your total");
	    bufferedWriter.append("\n");
	    bufferedWriter.append("" + Pay.calcTax(subTotal) + " is your sales tax");
	    bufferedWriter.append("\n");
	    bufferedWriter.append("" + Pay.grandTotal(tax, subTotal) + " is your Grand Total");
	    bufferedWriter.append("\n");
	   
	    
	    bufferedWriter.close();
	    fileWriter.close();
	}
	
	
	public static void welcomeMenu() throws IOException		// Presents the shop's inventory and processes purchases
	{
	    
	    String purchase=null;
	    Scanner scan = new Scanner(System.in);
	    
	    String choice = "y";
	    
	    do {
		    System.out.println("\n");
        	    System.out.println("What can I get ya? ( use item name )");	
        	     purchase = scan.nextLine().toLowerCase();
        	    
        	    
        		switch ( purchase )				
        		    {
        			case "apples":
        			     Product apple = new Product("Apple", "Fruit", "Bag of Apples", 3, 1);
        			    
        			     System.out.println("\n");
        			     
        			     System.out.println("How many " + purchase + " would you like?");
        			     amount = scan.nextInt();
        			     
        			     apple.setQuantity(amount);
        			     
        			     scan.nextLine();
        			     
        			     apple.setPrice(amount * apple.getPrice());
        			    
        			    purchaseList.add(apple);
        			    break;
        			    
        			case "oranges":
        			    Product orange = new Product("Orange", "Fruit", "Bag of Oranges", 5, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    
        			    orange.setQuantity(amount);
        			    
        			    scan.nextLine();
        			    
        			    orange.setPrice(amount * orange.getPrice());
        			    
        			    purchaseList.add(orange);
        			    break;
        			    
        			case "kiwi":
        			    Product kiwi = new Product("Kiwi", "Fruit", "Box of Kiwi", 6, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    
        			    kiwi.setQuantity(amount);
        			    
        			    scan.nextLine();
        			    
        			    kiwi.setPrice(amount * kiwi.getPrice());
        			    
        			    purchaseList.add(kiwi);
        			    break;
        			    
        			case "bananas":
        			    Product banana = new Product("Banana", "Fruit", "Bunch of Bananas", 5, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  	
        			    
        			    banana.setQuantity(amount);
        			    
        			    scan.nextLine();
        			    
        			    banana.setPrice(amount * banana.getPrice());
        			    
        			    purchaseList.add(banana);
        			    break;
        			    
        			case "ground beef":
        			    Product beef = new Product("GroundBeef", "Meat", "Pound of Ground Beef", 10, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many pounds of " + purchase + " would you like?");
        			    amount = scan.nextInt();
        			    scan.nextLine();
        			    
        			    beef.setQuantity(amount);
        			    
        			    beef.setPrice(amount * beef.getPrice());
        			    
        			    purchaseList.add(beef);
        			    break;
        			    
        			case "turkey":
        			    Product turkey = new Product("Turkey", "Poultry", "Pound of Turkey", 11, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many pounds of " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    
        			    turkey.setQuantity(amount);
        			    
        			    turkey.setPrice(amount * turkey.getPrice());
        			    
        			    purchaseList.add(turkey);
        			    break;
        			    
        			case "hotdogs":
        			    Product hotdogs = new Product("Hot Dogs", "Meat", "Pack of Hot Dogs", 6, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many packs of " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    
        			    hotdogs.setQuantity(amount);
        			    
        			    hotdogs.setPrice(amount * hotdogs.getPrice());
        			    
        			    purchaseList.add(hotdogs);
        			    break;
        			    
        			case "chicken":
        			    Product chicken = new Product("Chicken", "Poultry", "Pound of Chicken", 13, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many pounds of " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    
        			    chicken.setQuantity(amount);
        			    
        			    chicken.setPrice(amount * chicken.getPrice());
        			    
        			    purchaseList.add(chicken);
        			    break;
        			    
        			case "pepsi":
        			    Product pepsi = new Product("Pepsi", "Beverage", "Can of Pepsi", 7, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many cans of " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    scan.nextLine();
        			    
        			    pepsi.setQuantity(amount);
        			    
        			    pepsi.setPrice(amount * pepsi.getPrice());
        			    
        			    purchaseList.add(pepsi);
        			    break;
        			    
        			case "coke":
        			    Product coke = new Product("Coke", "Beverage", "Can of Coke", 9, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many cans of " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    scan.nextLine();
        			    
        			    coke.setQuantity(amount);
        			    
        			    coke.setPrice(amount * coke.getPrice());
        			    
        			    purchaseList.add(coke);
        			    break;
        			    
        			case "sprite":
        			    Product sprite = new Product("Sprite", "Beverage", "Can of Sprite", 2, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many cans of " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    
        			    sprite.setQuantity(amount);
        			    
        			    sprite.setPrice(amount * sprite.getPrice());
        			    
        			    purchaseList.add(sprite);
        			    break;
        			    
        			case "mountain dew":
        			    Product dew = new Product("MountainDew", "Beverage", "Can of Dew", 2, 1);
        			    
        			    System.out.println("\n");
        			    
        			    System.out.println("How many cans of " + purchase + " would you like?");
        			    amount = scan.nextInt();  	
        			    scan.nextLine();
        			    
        			    dew.setQuantity(1);
        			    
        			    dew.setPrice(amount * dew.getPrice());
        			    
        			    purchaseList.add(dew);
        			    break;
        			    
        			default:
        			    break;
        		    }
        			
        		System.out.println("\n");
        		System.out.println("Anything else?(Y/N)");		//Controls the loop
        		choice = scan.nextLine();
        		
        	} while(choice.equalsIgnoreCase("y"));
		
	Pay.writeReciept(purchaseList); 						//Calls the method to write to external text file
	
		
	}
	
	
	
	public static void pickPaymentType(Scanner scan)				//Allows user to pick payment type and launches appropriate methods.
	{
        	System.out.println("How you would like to pay? (Credit, Check or Cash)");
        	String choice = scan.nextLine();
		
		switch (choice.trim().toLowerCase().substring(0, 2)) 
		{
		
        		case "ca": 
        		    Cash cash = new Cash(scan);
        	            cash.cashPay();
        	            break;
        	            
        		case "cr": 
        		    Credit credit = new Credit(scan);
            		    credit.creditPay();
            		    break;
            		
        		case "ch":
        		    Check check = new Check(scan);
            		    check.checkPay();
            		    break;
            		    
        		default: 
            	    	   System.err.println("...there has been an error.");
		
		}
		
	}
}

