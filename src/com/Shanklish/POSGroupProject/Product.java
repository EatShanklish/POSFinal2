package com.Shanklish.POSGroupProject;


public class Product 
    {
	private String name;
	private String category;
	private String description;
	private int quantity;
	private int price;
	
	
	public Product(String n, String c, String d, int p, int q)
	{
	    name = n;
	    category = c;
	    description = d;
	    price = p;
	    quantity = q;
	}

	
	//-----GETTERS AND SETTERS---------
	
	
	public int getQuantity()
	{
	    return quantity;
	}
	
	public void setQuantity( int quantity )
	{
	    this.quantity = quantity;
	}

	public String getName()
	{
	    return name;
	}
	
	public void setName( String name )
	{
	    this.name = name;
	}
	
	public String getCategory()
	{
	    return category;
	}
	
	public void setCategory( String category )
	{
	    this.category = category;
	}
	
	public String getDescription()
	{
	    return description;
	}
	
	public void setDescription( String description )
	{
	    this.description = description;
	}
	
	public int getPrice()
	{
	    return price;
	}
	
	public void setPrice( int price )
	{
	    this.price = price;
	}
    }
