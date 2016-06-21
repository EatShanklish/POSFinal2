package com.Shanklish.POSGroupProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Pay {
	protected static double subTotal;
	protected static double tax;
	protected static double grandTotal;
	
	


	
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
	public static void writeReciept(Product p) throws IOException
	{
	    String fileName = "emptyText.txt";
	    
	    FileWriter fileWriter = new FileWriter(fileName);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);  	   
	    
	    bufferedWriter.append(p.getName() + "\t" + p.getPrice());
	    bufferedWriter.append("\n");
	    
	    bufferedWriter.close();
	    fileWriter.close();
	}
}

