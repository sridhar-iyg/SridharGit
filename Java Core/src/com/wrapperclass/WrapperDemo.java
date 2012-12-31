package com.wrapperclass;

import java.util.ArrayList;

public class WrapperDemo
{
	public static void main (String args[])
	{
		 ArrayList<Integer> aL=new ArrayList<Integer>();
		   for(int i=100;i<1000;i++)
		   {
		    for(int j=100;j<1000;j++)
		    {
		     int prod = i*j;
		     int count=0;
		     for(int k=2;k<10;k++)
		     {
		     if((prod%k)==0)
		      count++;
		     }
		     if(count==0)
		      aL.add(prod);
		    }
		   }
		   System.out.println("aL"+aL.size()+" "+aL); 
		   
		   System.out.println(" biggest : "+aL.get(aL.size()-1)); 
	}
	
}
