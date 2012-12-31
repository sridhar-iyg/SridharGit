package com;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

import com.acti.cs.services.CMSRestServices;

public class TriggerUrlMain
{
	private static final Logger	log	= Logger.getLogger( CMSRestServices.class.getName() );
	private static int count	=	32;
	private static String propName 	=	"accountnumberlist";
	
	
	public static void main (String args[])
	{
		propName = propName	+	String.valueOf(count);
		try
		{
			
			
			while(count<42)
			{
				//read from the file and return the list of account numbers.
				// write a method that gives URL request and gets the response.
				System.out.println("count is  : " + count);
				urlFetch(String.valueOf(count));
				Thread. sleep(30000);//half minite
				count++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String urlFetch(String  key)
	{
		String line 				=	null;;
		HashMap responseMap			=	null;
		StringBuffer line1 = new StringBuffer();
		try
		{
			URL url = new URL("http://beta.webservices.a-cti.com:8080/testmultiplecontact?accountnumberlist=accountnumberlist"+key);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestMethod("GET");
			con.setConnectTimeout(60000);
			con.setReadTimeout(60000);
			con.setRequestProperty("Content-Type", "application/json");
			
			//getting the auth token from the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			
			while ((line = reader.readLine()) != null)
			{
			   line1.append(line);
			}
			
			
			log.info("The buffred final string is ::: "+line1);
			reader.close();
		} 
		catch (IOException e)
		{
			log.log( java.util.logging.Level.SEVERE  , e.getMessage() ,  e );
		}
		return line1.toString();
	}
}
