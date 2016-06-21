package com.Shanklish.POSGroupProject;
import java.util.Scanner;
	
    public class Credit extends Pay 
    {
	    Scanner scan;
	    private String cardNumber;
	    private String expiration;
	    private String verificationValue;
	    private String input;
	    private String input2;
	    private String input3;
	    
	    public Credit(Scanner scan) 
	    {
	        this.scan = scan;
	        cardNumber = "";
	        expiration = "";
	        verificationValue = "";
	    }
	    
	    public void creditPay() 
	    {
	        finalTotals();
	        
	        System.out.println("Enter your card number: ");
	        input = scan.nextLine();
	        setCardNumber(input);
	        
	        System.out.println("Enter expiration date (MM/YY)");
	        input2 = scan.nextLine();
	        setExpiration(input2);
	        
	        System.out.println("Enter the CVV: ");
	        input3 = scan.nextLine();
	        setExpiration(input3);
	        
	        
	        System.out.println("This card " + getCardNumber() + " has been charged " + grandTotal);
	    }
	    
	    public void setCardNumber(String cardNumber) 
	    {
	        this.cardNumber = cardNumber;
	    }
	    
	    public void setExpiration(String expiration)
	    {
	        this.expiration = expiration;
	    }
	    
	    public void setVerification(String verificationValue) 
	    {
	        this.verificationValue = verificationValue;
	    }
	    
	    public String  getCardNumber() 
	    {
	        cardNumber = "*********" + input.substring(input.length() - 4, input.length());
	        return cardNumber;
	    }
	    
	    public String getExpiration() 
	    {
	        return expiration;
	    }
	    
	    public String getVerification() 
	    {
	        return verificationValue;
	    }
	}
	


	


