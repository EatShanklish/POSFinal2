package com.Shanklish.POSGroupProject;
import java.util.Scanner;

public class Cash extends Pay 
{
    
    Scanner scan;
    private double cashReceived;
    private double roundOff;
    private double change;
    
    public Cash(Scanner scan) 
    {
        this.scan = scan;
        cashReceived = 0;
    }
    public void cashPay() 
    {
        finalTotals();
        
       do 
	{ 
                System.out.println("Enter your cash value: ");
                double input = scan.nextDouble();
                setCashReceived(input);
                
                if (getCashReceived() < grandTotal) 
                {
                    change = grandTotal - getCashReceived();
                    roundOff = Math.round(change * 100.0) / 100.0;
                    System.out.println("Not enough money, Try again");
                } 
                
                else if (getCashReceived() >= grandTotal) 
                {
                    change = getCashReceived() - grandTotal;
                    roundOff = Math.round(change * 100.0) / 100.0;
                    
                    System.out.println("Your change is: " + roundOff);
                }
                
                  else if (getCashReceived() == grandTotal) 
                {
                    System.out.println("Your balance is paid in full");
                }
       }while(getCashReceived() < grandTotal);
    }
    
    public double getCashReceived() 
    {
        return cashReceived;
    }
    
    public void setCashReceived(double cashReceived) 
    {
        this.cashReceived = cashReceived;
    }
}