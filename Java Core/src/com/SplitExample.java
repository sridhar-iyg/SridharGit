package com;


public class SplitExample
{

	

	
	    public static void main(String[] args)
	    {
	        String data = "1,Diego Maradona,Footballer,Argentina";
	        String[] items = data.split(",");
	        
	        for (String item : items)
	        {
	            System.out.println("item = " + item);
	        }
	        System.out.println("Unicode at the point "+data.codePointAt(1));
	        System.out.println("Unicode at the point "+data.codePointAt(3));
	        System.out.println("Unicode at the point "+data.codePointAt(4));
	        System.out.println("Unicode at the point "+data.codePointAt(5));
	        System.out.println("Unicode at the point "+data.codePointAt(6));
	        System.out.println("Unicode at the point "+data.codePointAt(7));
	        
	    }
	
	
}
