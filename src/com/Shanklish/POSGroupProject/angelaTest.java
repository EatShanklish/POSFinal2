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
		
		Pay.viewProducts();
		
		System.out.println("Would you like to make a purchase?");	// TODO - wrap in method
		String purchase = scan.nextLine();
		
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
			    Product pepsi = new Product("Pepsi", "Beverage", "Can of Pepsi", 2);
			    purchaseList.add(pepsi);
			    break;
			    
			case "Coke":
			    Product coke = new Product("Coke", "Beverage", "Can of Coke", 2);
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
		
	
		Pay.writeReciept(purchaseList.get(0));
	}

}
