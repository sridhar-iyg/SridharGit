package com;



import java.util.HashMap;

public class SignupQueryCreator
{
	public static void main(String args[])
	{
		try
		{
		new SignupQueryCreator().getQueryProcessedWithData();
		}
		catch(Exception e)
		{
			
		}
	}
	public void getQueryProcessedWithData()
	{
		HashMap hm			=	null;
		try
		{
			hm		=	new HashMap();
			
			hm.put("uniquepin", "M8O7Y4");
			hm.put("companyname", "Newsom & Gapasin");
			hm.put("firstname", "Ernesto");
			hm.put("lastname", "Gapasin");
			hm.put("email", "info@militarylawyer-defense.com");
		
			hm.put("phone", "417-631-8086");
			
			
			hm.put("locationid","36ccffdc-1901-46d2-b686-60bdd202f070");
			hm.put("address","5517 N Farmer's Branch Rd");
			hm.put("city","Ozark");
			hm.put("state","Mo");
			hm.put("zip","65721");
			
			
			
			
			hm.put("serviceplan", "99.99");
			hm.put("setupfees", "49.99");
			hm.put("paymentamount", "179.97");
			hm.put("deliveryfees", "29.99");
			
			
			hm.put("date", "'2011-12-29 15:44:35.685000'"); //dsdate -8
			
			hm.put("password", "bbd9f1351bebc3b3627d47bff9ddd17d");
			
			
			hm.put("salespin", "LF45W");
			hm.put("peopleid", "8a75d7ae-4181-3ad1-8f9f-73fa675a806b");
			
			hm.put("phonecontactmethodid", "344f0098-240c-4642-876b-a07806f8e11e");
			hm.put("emailcontactmethodid", "5c20ac01-8d9b-4d58-91f5-2a2f2ca8e8d3");
			//hm.put("cardtype", " ");
			
			hm.put("transactionid", "VSJA9B0EE81C");
			hm.put("brandid", "5a6e67a6-8bfd-45f5-a774-3462cb0c4e4c");
			hm.put("contacttypeid", "0c3433f8-b37c-46c3-b88e-9f06e805604e");
			prepareSignupInsertQuery(hm);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void prepareSignupInsertQuery(HashMap hm)
	{
		try
		{
			String contactTableQuery	=	"insert into contactmanagementsystem.contact (uniquepin, contactname, contacttypeid, subgroupid,sourcecode, brandid ,dateadded)" +
					"values('"+hm.get("uniquepin") +"','"+hm.get("companyname") +"','"+hm.get("contacttypeid")+"'," +
					"'{6e8beea7-41c2-4009-a0b6-1f8aaebcd61f}', 'Answerconnect','"+hm.get("brandid")+"',"+hm.get("date")+")"; 
			
			
			String peopleTableQuery		=	
					"insert into contactmanagementsystem.people(firstname ,lastname,login,passnew,dateadded,activationflag, uniquepin,primarycontactflag,peopleid)"+
					"values('"+hm.get("firstname")+"','"+hm.get("lastname")+"','"+hm.get("email")+"','"+hm.get("password")+"',"+hm.get("date")+",true,'"
							+hm.get("uniquepin")+"',true,'"+hm.get("peopleid")+"')"; 
			
			String contactMethodPhone	=	
					"insert into contactmanagementsystem.contactmethod(contactmethodid,contactmethodtitle, contactmethodaddress, methodtypeid,peopleid,uniquepin,dateadded) " +
					"values('"+hm.get("phonecontactmethodid") +"','Default','"+hm.get("phone")+"','867d8a67-1d8a-4f4b-a33d-b5c9ab94bb4d','"+hm.get("peopleid")+"','"
							+hm.get("uniquepin")+"',"+hm.get("date")+")"; 
			
			String contactMethodMail	="insert into contactmanagementsystem.contactmethod(contactmethodid,contactmethodtitle, contactmethodaddress, methodtypeid,peopleid,uniquepin,dateadded) " +
										"values('"+hm.get("emailcontactmethodid")+"','Default','"+hm.get("email")+"','e8f41ae1-4ff9-40c4-9a35-3c962952e08a','"+hm.get("peopleid")+"','"+hm.get("uniquepin")+"',"+hm.get("date")+")";
			
			
			String cardTransaction		=	
					"insert into customer.cardTransactionDetails(loginusername,firstname,lastname,paymentamount,paymentdate,referencetransactionid,voidtransactionflag)" +
			"values('"+hm.get("email")+"','"+hm.get("firstname")+"','"+hm.get("lastname")+"','"+hm.get("paymentamount")+"',"+hm.get("date")+",'"+hm.get("transactionid")+"',true)"; 
		
			
			String newCustomerTable		=	
				"insert into answerconnect.newcustomers(dateadded,uniquepin, active ,initialdollars, setupfee,deliveryfee,salespersonuniquepin,recurringPayment, recurringtransactionid)" +
										"values("+hm.get("date")+",'"+hm.get("uniquepin")+"',true,'"+hm.get("serviceplan")+
					"','"+hm.get("setupcharges")+"','"+hm.get("deliveryfees")+"','"+hm.get("salespin")+"',false,'"+hm.get("transactionid")+"')"; 
			
			
			String historyTable			=	"insert into historysystem.history(dateadded,uniquepin,comment,historytypeid,userpin)values("+hm.get("date")+",'"+
					hm.get("uniquepin")+"','Marked as a customer','93103e84-4126-4164-a9ec-071e1c73125b','"+hm.get("salespin")+"')";
			
			String location				=	"insert into contactmanagementsystem.location (locationid,uniquepin,peopleid,address,city,state,zip,primarylocationflag)" +
											"values('"+hm.get("locationid")+"','"+hm.get("uniquepin")+"','"+hm.get("peopleid")+"','"+hm.get("address")+"'," +
													"'"+hm.get("city")+"','"+hm.get("state")+"','"+
													hm.get("zip")+"','true')";
			String queryArray[] 			={contactTableQuery,peopleTableQuery,contactMethodPhone,contactMethodMail,cardTransaction,newCustomerTable,historyTable,location};
			for(String query : queryArray)
				
			System.out.println( query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
