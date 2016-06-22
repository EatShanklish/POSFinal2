package com.Shanklish.POSGroupProject;


import java.util.Scanner;
public class Check extends Pay 
{
    
    Scanner scan;
    private  double amt;
    private  int number;
    
    public Check(Scanner s)
    {
        scan = s;
        amt = 0;
        number = 0;
    }
    
    public  void checkPay()
    {   
        Pay.finalTotals();
        
        System.out.println("Enter the check number: ");
        
        int input2 = Validator.getInt(scan);
        
        scan.nextLine();
        
        setCheckNumber(input2);
        
        System.out.println("You're going to send an amount of " + getGrandTotal() + " with check number " + getCheckNumber() + " is this okay? (y/n)");
                    
        String input3 = scan.nextLine();
        
        if (input3.equalsIgnoreCase("y"))
        {
            System.out.println("Check Sent");
        }
        else if (input3.equalsIgnoreCase("n"))
        {
            System.out.println("Check Cancelled");
        }
        else{
        	
        	System.out.println("Please try again");
        	
        }
        
    }
    
    public  void setCheckAmount(double a)
    {
	amt = a;
    }
    
    public  double getCheckAmount()
    {
	return amt;
    }
    public  void setCheckNumber(int n)
    {
	number = n;
    }
    public  int getCheckNumber()
    {
	return number;
    }
}