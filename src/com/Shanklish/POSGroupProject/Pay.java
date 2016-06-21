package com.Shanklish.POSGroupProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pay {
	protected static double subTotal;
	protected static double tax;
	protected static double grandTotal;
	public static ArrayList<Product> purchaseList = new ArrayList<Product>();


	
	 public static double calcSubTotal(ArrayList<Product> list)
	 {
		for( int i = 0; i < list.size(); i++) 
			 subTotal += list.get(i).getPrice();
		
		return subTotal;
	}

	
	static public double calcTax(double subTotal)
	{
		tax = subTotal * 0.6;
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
	   //find a way to create a new text file every time this method is called
	    
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

	
	public static void decidePaymentType(Scanner scan , String prompt){
		System.out.println(prompt);
		String paymentTypeChoice = scan.nextLine();
		
		switch (paymentTypeChoice.trim().toLowerCase().substring(0, 2)){
		case "cr": Credit.creditPay();
			break;
		case "ch": Check.checkPay();
			break;
		case "ca": Cash.grandTotal(6, 6);
		}
		
	}
	

	// Presents the shop's inventory
	public static void welcomeMenu() throws IOException {
	    String purchase=null;
	    Scanner scan = new Scanner(System.in);
	    
	    String choice = "y";
	    
	    do {
        	    System.out.println("Type the name of the item you would like to purchase");	
        	     purchase = scan.nextLine();
        	    
        	    
        		switch ( purchase )				//TODO - ask how many of certain items
        		    {
        			case "Apples":
        			    Product apple = new Product("Apple", "Fruit", "Bag of Apples", 3);
        			    purchaseList.add(apple);
        			    break;
        			    
        			case "Oranges":
        			    Product orange = new Product("Orange", "Fruit", "Bag of Oranges", 5);
        			    purchaseList.add(orange);
        			    break;
        			    
        			case "Kiwi":
        			    Product kiwi = new Product("Kiwi", "Fruit", "Box of Kiwi", 6);
        			    purchaseList.add(kiwi);
        			    break;
        			    
        			case "Bananas":
        			    Product banana = new Product("Banan", "Fruit", "Bunch of Bananas", 5);
        			    purchaseList.add(banana);
        			    break;
        			    
        			case "Ground Beef":
        			    Product beef = new Product("Ground Beef", "Meat", "Pound of Ground Beef", 10);
        			    purchaseList.add(beef);
        			    break;
        			    
        			case "Turkey":
        			    Product turkey = new Product("Turkey", "Poultry", "Pound of Turkey", 11);
        			    purchaseList.add(turkey);
        			    break;
        			    
        			case "HotDogs":
        			    Product hotdogs = new Product("Hot Dogs", "Meat", "Pack of Hot Dogs", 6);
        			    purchaseList.add(hotdogs);
        			    break;
        			    
        			case "Chicken":
        			    Product chicken = new Product("Chicken", "Poultry", "Pound of Chicken", 13);
        			    purchaseList.add(chicken);
        			    break;
        			    
        			case "Pepsi":
        			    Product pepsi = new Product("Pepsi", "Beverage", "Can of Pepsi", 7);
        			    purchaseList.add(pepsi);
        			    break;
        			    
        			case "Coke":
        			    Product coke = new Product("Coke", "Beverage", "Can of Coke", 9);
        			    purchaseList.add(coke);
        			    break;
        			    
        			case "Sprite":
        			    Product sprite = new Product("Sprite", "Beverage", "Can of Sprite", 2);
        			    purchaseList.add(sprite);
        			    break;
        			    
        			case "Mountain Dew":
        			    Product dew = new Product("Mountain Dew", "Beverage", "Can of Dew", 2);
        			    purchaseList.add(dew);
        			    break;
        			    
        			default:
        			    break;
        		    }
        			
        		System.out.println("Would you like to make another purchase(Y/N)");
        		 choice = scan.nextLine();
        		
        	} while(choice.equalsIgnoreCase("y"));
		   
		
			Pay.writeReciept(purchaseList); //TODO - Keeps rewriting the same line. Need to append on new line
		
		/*PrintWriter writer = new PrintWriter("emptyText.txt");
		    writer.print("");
		    writer.close();*/
		
		
		
		
	}
}

