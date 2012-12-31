package com;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;


public class TestClass 
{
	public static void main(String args[])
	{
		try
		{
			//System.out.println((String)new TestClass().returnNull());
			ArrayList<String> accnumberlist	=	new ArrayList<String>();
			accnumberlist.add("8005763545");
			accnumberlist.add("8009145952");
			accnumberlist.add("8005057011");
			System.out.println("accnumberlist : " + accnumberlist);
			//["8005763540","8009145952","8005057011"]
			ObjectMapper mapper	=	new ObjectMapper();
			Writer writer	=	new StringWriter();
			mapper.writeValue(writer, accnumberlist);
			System.out.println("writer"+writer);
			System.out.println("writer"+writer.toString());
			checkAccountNumberAvailable("8005763540",writer.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public native static  void amethod();
	public String returnNull()
	{
		return null;
	}
	public static String checkAccountNumberAvailable(String accountNumber,String lAvailableAccountNumbers)
	{
		
		//String lAvailableAccountNumbers			=	null;
		String availableAccountNumberStatus		=	"false";
		try
		{
			System.out.println("lAvailableAccountNumbers ::"+lAvailableAccountNumbers+"\n Number need to be checked is  : " + accountNumber);
			if(lAvailableAccountNumbers!=null && lAvailableAccountNumbers.contains(accountNumber))
			{
				System.out.println("AccountNumber still available!!!");
				availableAccountNumberStatus	=	"true";
			}
			else 
			{
				System.out.println("AccountNumber NOT available!!!");
				availableAccountNumberStatus	=	"false";
			}
			
		}
		catch(Exception e)
		{
			availableAccountNumberStatus		=	"false";
			System.out.println("Exception");
			e.printStackTrace();
		}
		return availableAccountNumberStatus;
	}

	/*
	 * ObjectMapper mapper 		= 	new ObjectMapper();
							Writer strWriter 			= 	new StringWriter();
							try
							{
								mapper.writeValue(strWriter, signupDto);
							}
	 */
}
