package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class AccountNumberAssociation 
{

	public static void main(String[] args) 
	{
		StringBuffer response = new StringBuffer();
		try
		{
			  URL url = new URL("http://staging-formcreator.appspot.com/answerconnect/buildAccount.req?accountNumber=8005057011&uniquePin=0S262V&templateAccountNumber=1003712630");
			  HttpURLConnection con=(HttpURLConnection) url.openConnection();
			  con.setDoOutput(true);
			  con.setUseCaches(false);
			  con.setConnectTimeout(30000);
			  con.setRequestMethod("GET");
			  con.setRequestProperty("Content-Type", "application/json");
			  OutputStreamWriter out= new OutputStreamWriter(con.getOutputStream());
			  out.close();
			    
			  String responseline ;
			  
			   BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			   while ((responseline = reader.readLine()) != null) 
			   {
				   response.append(responseline);
			   }
			   System.out.println("REsponse is  : " + response.toString());
		}
		catch (Exception e)
		{
				 System.out.println( e.getMessage());
			   e.printStackTrace();
		}
	}

}
