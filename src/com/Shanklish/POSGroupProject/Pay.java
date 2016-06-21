package com.Shanklish.POSGroupProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pay 
{
	protected static double subTotal;
	protected static double tax;
	protected static double grandTotal;
	public static ArrayList<Product> purchaseList = new ArrayList<Product>();
	
	 public Pay()
	 {  
	        subTotal = 0;
	        tax = 0;
	        grandTotal = 0;
  
	 }
	 
	 public static void finalTotals()
	 {
	     	double sub = Pay.calcSubTotal(purchaseList);
	     	
		double tax = Pay.calcTax(sub);
		
		System.out.println(sub + " is your subtotal");
		
		System.out.println(tax + " is your tax");
		
		System.out.println("Your grand total is: " + Pay.grandTotal(tax, sub));
	    }
	    
	    
	    static public double getTax()
	    {    
	        return tax;
	    }
	    static public double getGrandTotal()
	    {    
	        return grandTotal;
	        
	    }
	    static public double getSubTotal()
	    {
	        
	        return subTotal;
	    }
	
	 public static double calcSubTotal(ArrayList<Product> list)
	 {
		for( int i = 0; i < list.size(); i++) 
			 subTotal += list.get(i).getPrice();
		
		return subTotal;
	}

	
	static public double calcTax(double subTotal)
	{
		tax = subTotal * 0.06;
		return tax;
	}
	
	static public double grandTotal(double tax, double subTotal)
	{	
		grandTotal = tax + subTotal;
		return grandTotal;
	}
	
	
	
	
	//Will print all the items into the console
	public static void viewProducts() throws IOException
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

	
	//Take product object as parameter and add it to the text file
	//( pay.writeReciept(arraylist.get[i]) )
	
	public static void writeReciept(ArrayList<Product> p) throws IOException
	{
	    Files.delete(Paths.get("emptyText.txt"));
	    File file = new File("emptyText.txt");
	    file.createNewFile();
	   
	    FileWriter fileWriter = new FileWriter(file, true);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);  	       
	    
	    for(int i = 0; i < p.size(); i++)
		{
		    bufferedWriter.append((p.get(i).getName() + "\t" + p.get(i).getPrice()));
		    bufferedWriter.append("\n");
		}
	    
	    bufferedWriter.close();
	    fileWriter.close();
	}
	
	// Presents the shop's inventory
	public static void welcomeMenu() throws IOException
	{
	    String purchase=null;
	    Scanner scan = new Scanner(System.in);
	    int amount = 0;
	    
	    String choice = "y";
	    
	    do {
        	    System.out.println("Type the name of the item you would like to purchase");	
        	     purchase = scan.nextLine();
        	    
        	    
        		switch ( purchase )				//TODO - ask how many of certain items
        		    {
        			case "Apples":
        			    Product apple = new Product("Apple", "Fruit", "Bag of Apples", 3);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			     amount = scan.nextInt();
        			     scan.nextLine();
        			    apple.setPrice(amount * apple.getPrice());
        			    
        			    purchaseList.add(apple);
        			    break;
        			    
        			case "Oranges":
        			    Product orange = new Product("Orange", "Fruit", "Bag of Oranges", 5);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    scan.nextLine();
        			    orange.setPrice(amount * orange.getPrice());
        			    
        			    purchaseList.add(orange);
        			    break;
        			    
        			case "Kiwi":
        			    Product kiwi = new Product("Kiwi", "Fruit", "Box of Kiwi", 6);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    scan.nextLine();
        			    kiwi.setPrice(amount * kiwi.getPrice());
        			    
        			    purchaseList.add(kiwi);
        			    break;
        			    
        			case "Bananas":
        			    Product banana = new Product("Banan", "Fruit", "Bunch of Bananas", 5);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  	
        			    scan.nextLine();
        			    banana.setPrice(amount * banana.getPrice());
        			    
        			    purchaseList.add(banana);
        			    break;
        			    
        			case "Ground Beef":
        			    Product beef = new Product("Ground Beef", "Meat", "Pound of Ground Beef", 10);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();
        			    scan.nextLine();
        			    beef.setPrice(amount * beef.getPrice());
        			    
        			    purchaseList.add(beef);
        			    break;
        			    
        			case "Turkey":
        			    Product turkey = new Product("Turkey", "Poultry", "Pound of Turkey", 11);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    turkey.setPrice(amount * turkey.getPrice());
        			    
        			    purchaseList.add(turkey);
        			    break;
        			    
        			case "HotDogs":
        			    Product hotdogs = new Product("Hot Dogs", "Meat", "Pack of Hot Dogs", 6);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    hotdogs.setPrice(amount * hotdogs.getPrice());
        			    
        			    purchaseList.add(hotdogs);
        			    break;
        			    
        			case "Chicken":
        			    Product chicken = new Product("Chicken", "Poultry", "Pound of Chicken", 13);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    chicken.setPrice(amount * chicken.getPrice());
        			    
        			    purchaseList.add(chicken);
        			    break;
        			    
        			case "Pepsi":
        			    Product pepsi = new Product("Pepsi", "Beverage", "Can of Pepsi", 7);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    scan.nextLine();
        			    pepsi.setPrice(amount * pepsi.getPrice());
        			    
        			    purchaseList.add(pepsi);
        			    break;
        			    
        			case "Coke":
        			    Product coke = new Product("Coke", "Beverage", "Can of Coke", 9);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt(); 
        			    scan.nextLine();
        			    coke.setPrice(amount * coke.getPrice());
        			    
        			    purchaseList.add(coke);
        			    break;
        			    
        			case "Sprite":
        			    Product sprite = new Product("Sprite", "Beverage", "Can of Sprite", 2);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  
        			    scan.nextLine();
        			    sprite.setPrice(amount * sprite.getPrice());
        			    
        			    purchaseList.add(sprite);
        			    break;
        			    
        			case "Mountain Dew":
        			    Product dew = new Product("Mountain Dew", "Beverage", "Can of Dew", 2);
        			    
        			    System.out.println("How many " + purchase + " would you like?");
        			    amount = scan.nextInt();  	
        			    scan.nextLine();
        			    dew.setPrice(amount * dew.getPrice());
        			    
        			    purchaseList.add(dew);
        			    break;
        			    
        			default:
        			    break;
        		    }
        			
        			
        			
        		System.out.println("Would you like to make another purchase(Y/N)");
        		 choice = scan.nextLine();
        		
        	} while(choice.equalsIgnoreCase("y"));
		
	Pay.writeReciept(purchaseList); 
	
		
	}
	
	public static void pickPaymentType(Scanner scan)
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

