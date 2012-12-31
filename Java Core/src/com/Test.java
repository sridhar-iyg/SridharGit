package com;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mortbay.log.Log;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import com.acti.cs.dto.AgentDetailDTO;
import com.acti.cs.util.CommonSignUpUtil;
import com.acti.cs.util.VelocityUtil;
import com.acti.reporting.util.EmailUtil;
import com.acti.signup.dto.SignUpDTO;
import com.managementsystem.objects.NewCustomers;
import com.util.ModeUtil;
import common.util.BusinessException;

public class Test
{
	private static final Logger	log	= Logger.getLogger( Test.class.getName() );
	public static void main (String args[])
	{
		try
		{
			
			new Test().getformatedQueriesForSignup();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void sendChatMail(String filename)
	{
		String 			from 								= 	null;
		String 			to 									= 	null;
		String 			subject								= 	null;
		String 			cc 									= 	null;
		VelocityUtil 	v									=	null;
		String		 	messagebody 						= 	null;
		boolean 		flag 								= 	false;
		String 			mode								=	null;
		Hashtable	 	hm									=	null;
		try
		{
			mode											=	new ModeUtil().getMode();
			log.info("The mode of the application is  : " +	mode);
		

			
			hm 												= 	new Hashtable();
			String lUrlString = "http://commondatastorage.googleapis.com/clientaccess/Template/"+filename+".vm";
			log.info("template for clientmail : "+lUrlString);
			
			hm.put("name", "Sridhar");
			hm.put("subaccountnumber", "1234567890");
			
			to		=	"s7r@a-cti.com";
			from	=	"acservices@a-cti.com";
			log.info("The contents of the hash table before sending mail is  : " + hm);

			try
			{
				v 			= new VelocityUtil(new URL(lUrlString), hm);
				messagebody = v.getRenderedText();
				log.info("messagebody : " + messagebody);
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (BusinessException e)
			{
				e.printStackTrace();
			}
			String bcc	=null;	
					

			try
			{
				flag = EmailUtil.sigunUpMail(from, to, bcc, cc, subject, messagebody);
				log.info("flag : " + flag);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		catch (Exception e)
		{
			log.log(java.util.logging.Level.INFO, e.getMessage(), e);
		}
	}
	/*public static void main(String args[])
	{
		try 
		{
			HashMap<String,Object> mailDataMap	=	new HashMap<String,Object>();
			mailDataMap.put("accountNumber", "No Account Number Selected");
			mailDataMap.put("additional_plan", "null,webchat,leadcapture");
			SignUpDTO signupDto	=	new SignUpDTO();
			signupDto.setUniquePin("8MB8N1");
			signupDto.setUserPin("LF45W");
			signupDto.setCompanyName("Media");
			signupDto.setFirstName("test");
			signupDto.setUserEmail("Stephanie@signsbyeinstein.com");
			signupDto.setUserPhone("205-960-7117");
			signupDto.setAddress("3004");
			signupDto.setCity("Hoover");
			signupDto.setState("AL");
			signupDto.setZip("35244");
			signupDto.setServicePlanCharges(199.99);
			signupDto.setDeliveryMethodCharges(0.0);
			signupDto.setAdditionalPlanCost(0.0);
			signupDto.setSetUpCharges(49.99);
			signupDto.setPaymentAmount(249.98);
			signupDto.setTransactionId("VSHA9A67740F");
			
			mailDataMap.put("signupDto" ,signupDto);
			mailDataMap.put("additonalServiceCharges" ,"0");
			mailDataMap.put("ccenabled" ,"true");
			
			
			//SignUpDTO [uniquePin=8MB8N1, userPin=LF45W, companyName=LF45W Media,
			//firstName=Stephanie, lastName=Bonds, userEmail=Stephanie@signsbyeinstein.
			//com, userPhone=205-960-7117, address=3004 Arbor Bend, city=Hoover,
			//state=AL, zip=35244, cardType=Visa, nameOnCard=Stephanie Bonds Einstein 
			//Media, LLC, servicePlanCharges=199.99, deliveryMethodCharges=0.0,
			//additionalPlanCost=0.0, setUpCharges=49.99, paymentAmount=249.98,
			//loginIdExistFlag=false, peopleId=e65801cb-577e-3573-bf68-93348f0e8f73,
			//locationId=e65801cb-577e-3573-bf68-93348f0e8f73, 
			//emailContactMethodId=4eef7cc8-8fdb-49c6-89da-b8559fbefe33, 
			//phoneContactMethodId=202c0fd7-9f8d-4c2f-874f-498b6c3364f4, transactionId=VSHA9A67740F, transactionStatus=true, password=765cd6260d2644ab09b09081103bbbe3, passNew=myvinny1, brandId=5a6e67a6-8bfd-45f5-a774-3462cb0c4e4c,cardNumber=5414,expDate=01/2015]
			new Test().sendMail(mailDataMap);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public void sendMail(HashMap <String,Object>mailDataMap,String fileName)
	{
		String 			additional_plan						=	null;
		String			additonalServiceCharges				=	null;
		String			brand								=	null;
		SignUpDTO 		signupDto							=	null;
		String 			from 								= 	null;
		String 			to 									= 	null;
		String			bcc 								= 	null;
		String 			subject								= 	null;
		String 			cc 									= 	null;
		VelocityUtil 	v									=	null;
		String		 	messagebody 						= 	null;
		String 			accountNumber						=	null;
		boolean 		flag 								= 	false;
		String 			mode								=	null;
		Hashtable	 	hm									=	null;
		ArrayList 		additional_content					=	null;
		ArrayList 		additional_value					=	null;
		ArrayList 		additional_Key						=	null;
		String 			path								=	null;
		try
		{
			mode											=	new ModeUtil().getMode();
			log.info("The mode of the application is  : " +	mode);
			HashMap leadAndSalesPinMap 						= 	new HashMap();
			additional_plan									=	(String)mailDataMap.get("additional_plan");
			additonalServiceCharges							=	(String)mailDataMap.get("additonalServiceCharges");
			brand											=	(String)mailDataMap.get("brand");
			signupDto										=	(SignUpDTO)mailDataMap.get("signupDto");
			accountNumber									=	(String)mailDataMap.get("accountNumber");
			path											=	(String)mailDataMap.get("path");
			
			leadAndSalesPinMap.put("customerUniquePin"	, signupDto.getUniquePin());
			leadAndSalesPinMap.put("salesUniquePin"		, signupDto.getUserPin());
			
			log.info("The additional_plan is  			: " 		+ additional_plan);
			log.info("The servicePlan is  				: " 		+ (String)mailDataMap.get("servicePlan"));
			log.info("The path is  						: " 		+ path);
			log.info("The signupDto is  				: " 		+ signupDto);
			log.info("The additonalServiceCharges is  	: " 		+ additonalServiceCharges);
			log.info("The accountnumber assigned  is    : "			+ accountNumber);

			
			hm 												= 	new Hashtable();
			additional_content 								= 	new ArrayList();
			additional_Key 									= 	new ArrayList();
			additional_value 								= 	new ArrayList();

			Double 	totalAmt					=	 new Double("149.99");
			Double	setupFee					=	 new Double("49.99");
			Double	amountXSetupFee				=	 null;
			if(setupFee!=null && totalAmt < setupFee )
			{
				amountXSetupFee				=	totalAmt	-	setupFee; //Amount exclusive of setup fee.
			}
			else
			{
				amountXSetupFee				=	totalAmt; 
			}
			
			DecimalFormat 	df				=	new DecimalFormat("0.00");
			String			formattedAmount =   df.format(amountXSetupFee); 
			
			log.info("amountXSetupFee : " + amountXSetupFee);
			log.info("formattedAmount : " + formattedAmount);
			

		
			String lUrlString = "http://commondatastorage.googleapis.com/clientaccess/Template/"+fileName+".vm";
			//String lUrlString = getClientMailTemplate(brand);
			log.info("template for clientmail : "+lUrlString);
			log.info("brand name is :"+brand);
			if ( "staging".equalsIgnoreCase(mode) )
			{
				cc = ResourceBundle.getBundle("ApplicationResources").getString("sales_email_forstaging");
				if(brand != null && "answerforce".equalsIgnoreCase(brand))
				{
					subject = "Staging: AnswerForce Online Signup";
				}
				else if(brand != null && "lexreception".equalsIgnoreCase(brand))
				{
					subject = "Staging: LexReception Online Signup";
					from 	= ResourceBundle.getBundle("ApplicationResources").getString("admin_email_lex");
					cc = ResourceBundle.getBundle("ApplicationResources").getString("sales_email_lex");
				}
				else
				{
					subject = "Staging: AnswerConnect Online Signup";
				}
				
				log.info("cc added to sales : id = " + cc);
				log.info("subject : " + subject);
			}
			else if ( "beta".equalsIgnoreCase(mode)||"live".equalsIgnoreCase(mode) )
			{
				cc = ResourceBundle.getBundle("ApplicationResources").getString("sales_email");
				if(brand != null && "answerforce".equalsIgnoreCase(brand))
				{
					subject = "AnswerForce Online Signup";
				}
				else if(brand != null && "lexreception".equalsIgnoreCase(brand))
				{
					subject = "LexReception Online Signup";
					cc = ResourceBundle.getBundle("ApplicationResources").getString("sales_email_lex");
					from 	= ResourceBundle.getBundle("ApplicationResources").getString("admin_email_lex");
				}
				else
				{
					subject = "AnswerConnect Online Signup";
				}
				
				log.info("cc added to sales : id = " + cc);
				log.info("subject : " + subject);

			}
			else
			{
				subject = "AnswerConnect Online Signup --From local";
				log.info("subject : " + subject);
			}

			if (  additional_plan	!=	null )
			{
				String[] contents = additional_plan.split(",");

				
					
						additional_content.add("Operator Delivery  $29.99");
						additional_Key.add("Operator Delivery");								
						additional_value.add("$29.99");
						additional_content.add("Call Patching (120 Minutes) $29.99");
						additional_Key.add("Call Patching (120 Minutes)");
						additional_value.add("$29.99");
						additional_content.add("Call Patching (500 Minutes) $99.50");
						additional_Key.add("Call Patching (500 Minutes)");
						additional_value.add("$99.50");
						additional_content.add("IVR ($49.99)");
						additional_Key.add("IVR");
						additional_value.add("$49.99");
						additional_content.add("The Full Website package  $49.99");
						additional_Key.add("The Full Website package");
						additional_value.add("$49.99");
						
						additional_content.add("Web Chat ( Free )");
						additional_Key.add("Web Chat");	
						additional_value.add("FREE");
						additional_content.add("Web Lead Capture (Free)");
						additional_Key.add("Web Lead Capture");
						additional_value.add("FREE");

				log.info("The Additional Service additional_Key is :" + additional_Key.size());
				log.info("The Additional Service additional_value is :" + additional_value);
				log.info("The Additional Service content is :" + additional_content);
			}
			else
			{
			}
			additional_content.add("No plans have been chosen");
			
			 
			if ( (additonalServiceCharges.equalsIgnoreCase("0")) || (additional_plan == null) )
			{

				additonalServiceCharges = "0.00";
				log.info("Additional plan is null");
			}
			

			log.info("Additional Service Charges is : " + additonalServiceCharges);
			
			hm.put("servicePlan"		, "150 included minutes per month ($149.99)");
			hm.put("additional_content"	, additional_content);
			hm.put("additional_key"		, additional_Key);
			hm.put("additional_value"	, additional_value);
			hm.put("additional_charge"	, additonalServiceCharges);
			hm.put("signUpDto"			, signupDto);
			hm.put("accountNumber"		, "no Accountnumber");
			hm.put("ccenabled", (String)mailDataMap.get("ccenabled"));
			hm.put("withoutsetupcharge"	, formattedAmount);
			log.info("The contents of the hash table before sending mail is  : " + hm);

			try
			{
				v 			= new VelocityUtil(new URL(lUrlString), hm);
				messagebody = v.getRenderedText();
				log.info("messagebody : " + messagebody);
			}
			catch (MalformedURLException e)
			{

				e.printStackTrace();
				new CommonSignUpUtil().sendExceptionMail(e, leadAndSalesPinMap);
			}
			catch (BusinessException e)
			{

				e.printStackTrace();
				new CommonSignUpUtil().sendExceptionMail(e, leadAndSalesPinMap);
			}
			to		=	"s7r@a-cti.com";
			from	=	"acservices@a-cti.com";
			try
			{
				flag = EmailUtil.sigunUpMail(from, to, bcc, cc, subject, messagebody);
				log.info("flag : " + flag);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				new CommonSignUpUtil().sendExceptionMail(e, leadAndSalesPinMap);
			}

		}
		catch (Exception e)
		{
			log.log(java.util.logging.Level.INFO, e.getMessage(), e);
		}
	}
	public void convertToUpper()
	{
		String name="";
		try
		{
			name	=	name.substring(0,1).toUpperCase()+name.substring(1);
			System.out.println("name : " +name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public HashMap addNewAgentMap()
	{
		HashMap			brandhm 	=	null;
		
		try
		{
			brandhm				=	new HashMap();
			brandhm.put("creatorlogin", "addnewuser@test.com");
			brandhm.put("newlogin", "addnewuserchild2@test.com");
			brandhm.put("firstname", "Sridhar");
			brandhm.put("lastname", "Ragunathan");
			brandhm.put("uniquepin", "4FC6N0");
			brandhm.put("password", "5f4dcc3b5aa765d61d8327deb882cf99");
		//	brandhm.put("accountid", "3e0eea34-23eb-4eba-b421-9e17b0a9fe77");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return brandhm;
	}
	
	public HashMap getBrandingMap()
	{
		
		HashMap			agentMap 	=	null;
		try
		{

			agentMap				=	new HashMap();
			agentMap.put("accountnumber", "8005057012");
			//brandhm.put("accountnumber", null);
			agentMap.put("uniquepin", "PQRSTUV");
			agentMap.put("paramTypeKey", "headercolor");
			agentMap.put("paramTypeValue", "#default");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return agentMap;
	}
	
	public HashMap getLoginMap()
	{
		HashMap			detail 	=	null;
		try
		{
			 detail				=	new HashMap();
			 detail.put("username", "test@tegfst.com");
		     detail.put("password", "a3a388aed50d2733881dad0638aa0d97");//get the primary login for the uniquepin
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return detail;
	}
	
	public void getformatedQueriesForSignup()
	{
		try
		{
			HashMap hm			=	null;
			hm		=	new HashMap();
			
			hm.put("uniquepin", "6Y82Z6");
			hm.put("companyname", "Reynolds GMC Subaru ");
			hm.put("firstname", "Grant");
			hm.put("lastname", "");
			hm.put("email", "lgcarpenter44@gmail.com");
		
			hm.put("phone", "540-672-4297");
			hm.put("serviceplan", "149.99");
			hm.put("setupfees", "49.99");
			
			hm.put("setupcharges", "0.00");
			hm.put("paymentamount", "229.97");
			
			hm.put("deliveryfees", "0.0");
			
			
			hm.put("date", "'2012-07-11 09:16:05.097000'"); //dsdate -8
			
			hm.put("password", "ba31000e6596861d0215eeb197d0885c");
			
			hm.put("salespin", "W2WXP");
			
			hm.put("peopleid", "ca19836c-7ae8-4191-b78b-77e86d7ba114");
			
			hm.put("phonecontactmethodid", "c43a4134-f0f9-4f79-9394-360f8c7dc4d2");
			hm.put("emailcontactmethodid", "869c6f8d-ba9d-4605-88a6-c3386dcabd77");
			
			hm.put("cardtype", " ");
			
			hm.put("transactionid", "VTHA9CFB016B");
			hm.put("brandid", "5a6e67a6-8bfd-45f5-a774-3462cb0c4e4c");
			hm.put("contacttypeid", "0c3433f8-b37c-46c3-b88e-9f06e805604e");
			
			
			String contactTableQuery	=	"insert into contactmanagementsystem.contact (uniquepin, contactname, contacttypeid, subgroupid,sourcecode, brandid ,dateadded)" +
					"values('"+hm.get("uniquepin") +"','"+hm.get("companyname") +"','"+hm.get("contacttypeid")+"'," +
					"'{6e8beea7-41c2-4009-a0b6-1f8aaebcd61f}', 'Webchat','"+hm.get("brandid")+"',"+hm.get("date")+")"; 
			
			
			String peopleTableQuery		=	
					"insert into contactmanagementsystem.people(firstname ,lastname,login,passnew,dateadded,activationflag, uniquepin,primarycontactflag,peopleid)"+
					"values('"+hm.get("firstname")+"','"+hm.get("lastname")+"','"+hm.get("email")+"','"+hm.get("password")+"',"+hm.get("date")+",true,'"
							+hm.get("uniquepin")+"',true,'"+hm.get("peopleid")+"')"; 
			
			String contactMethodPhone	=	
					"insert into contactmanagementsystem.contactmethod(contactmethodid,contactmethodtitle, contactmethodaddress, methodtypeid,peopleid,uniquepin,dateadded) " +
					"values('"+hm.get("phonecontactmethodid") +"','Default','"+hm.get("phone")+"','867d8a67-1d8a-4f4b-a33d-b5c9ab94bb4d','"+hm.get("peopleid")+"','"
							+hm.get("uniquepin")+"',"+hm.get("date")+")"; 
			
			String contactMethodMail	=	
					"insert into contactmanagementsystem.contactmethod(contactmethodid,contactmethodtitle, contactmethodaddress, methodtypeid,peopleid,uniquepin,dateadded) " +
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
			
			
			
			
			String queryArray[] 			={contactTableQuery,peopleTableQuery,contactMethodPhone,contactMethodMail,cardTransaction,newCustomerTable,historyTable};
			for(String query : queryArray)
				
			System.out.println( query);
		}
		catch(Exception e)
		{
			
		}
		//return hm;
	}
	
	public void triggerURL()
	{
		try
		{
		URL url = new URL("http://cwa2.live-cms.appspot.com/fetchAccount");
		//	URL url = new URL("http://cache.maharasims2.appspot.com/setData");
		HttpURLConnection con=(HttpURLConnection) url.openConnection();

		con.setDoOutput(true);
		con.setUseCaches(false);
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
	        HashMap detail		=	new Test().getLoginMap();
	       Log.info("detail : " + detail);
	        

	        
	        
	        ObjectMapper mapper = new ObjectMapper();
			Writer strWriter = new StringWriter();
			try 
			{
				mapper.writeValue(strWriter, detail);
			} 
			catch (JsonGenerationException e) 
			{
				e.printStackTrace();
			}
			catch (JsonMappingException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			String str = strWriter.toString();
	        
		OutputStreamWriter out= new OutputStreamWriter(con.getOutputStream());
		//out.write(buf.toString().getBytes());
		out.write(str);
		out.close();
		
		//getting the auth token from the response
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
		 
		StringBuffer line1 = new StringBuffer();
		String line ;
		while ((line = reader.readLine()) != null)
		{
		   line1.append(line);
		   System.out.println("response - "+line);
		}
		System.out.println("response - "+line);
		
		ObjectMapper readmapper = new ObjectMapper();
		ArrayList<AgentDetailDTO> json = new ArrayList();
		try 
		{
			json = readmapper.readValue( line1.toString() , ArrayList.class );
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("response:::"+line1);
		//System.out.println("demo number :::"+json.get("demonumber"));
		//System.out.println("uniquepin :::"+json.get("uniquepin"));
		///con.disconnect()	
		reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
//    detail.put("peopleid","9304dbc1-697e-491c-b598-dfd59d81762a");
//    detail.put("uniquepin", "00116K");
//    detail.put("activationflag", "false");
//    detail.put("login","sridharTest@test.com");
  //  detail.put("username", "p4p@a-cti.com");
  //  detail.put("password", "52561e1e1733e2b3c3f34b09faf8dab3");//get the primary login for the uniquepin
   // detail.put("uniquepin", "75IE87");
    //detail.put("accountnumber", "8009145952");
    /*detail.put("firstname", "Sridhar");
    detail.put("lastname", "test");
    detail.put("newlogin", "sridharTest@test.com");
    detail.put("password", "c21f969b5f03d33d43e04f8f136e7682");*/
    //detail.put("activationflag", "false");
    //detail.put("clientPeopleId");
	
	
	public void testMahaDate()
	{
		String date = "2011-04-11 10:02:26.919652-07";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mmm-DD HH:mm:ss");  
		
		try
		{
			System.out.println("formatter sdfas "+formatter.parse(date));
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		//String strDateString = formatter.format(date);  
		//strDateString+=" "+timeZone.getID();  
		TimeZone timeZone 		= TimeZone.getTimeZone( "UTC" );
		formatter.setTimeZone(timeZone);  
		//formatter.applyPattern("yyyy-mmm-DD HH:mm:ss");  
		  
		try
		{
			Date scheduleTime =  formatter.parse(date);
			System.out.println("scheduleTime"+scheduleTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void testmethd(HashMap newAgentMap)
	{
		 ClientResource cr = new ClientResource("http://sb.pgwebservice.a-cti.com/accountOperation.req");
		  ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, ResourceBundle.getBundle("ApplicationResources").getString("formcreator_userName"),ResourceBundle.getBundle("ApplicationResources").getString("formcreator_password"));
		System.out.println( "yser name"+ResourceBundle.getBundle("ApplicationResources").getString("formcreator_userName"));
		//System.out.println( "yser name"+ResourceBundle.getBundle("ApplicationResources").getString("formcreator_userName"));
		  cr.setChallengeResponse(chr);
		  try
		  {   
		    try
		    {
		    
		    	cr.post(newAgentMap);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		  }
		  catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
	}
	public void makePayment()
	{
		HashMap paymentInfo	=	null;
		try
		{
			paymentInfo	=	new HashMap();
			
			 paymentInfo.put("accountNumber" , "8663958628");
			 urlFetch(paymentInfo);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public HashMap urlFetch(HashMap paramMap)
	{
		String line 			=	null;;
		HashMap responseMap			=	null;
		Long start		=	null;
		try
		{
			//String dataStoreUrl						=	new ModeUtil().getCMSMigrationUrl();
			URL url = new URL("http://cwa2.live-cms.appspot.com/fetchAccount");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestMethod("POST");
			con.setConnectTimeout(60000);
			con.setReadTimeout(70000);
			con.setRequestProperty("Content-Type", "application/json");
		     log.info("paramMap : " + paramMap);
		        
		        ObjectMapper mapper = new ObjectMapper();
				Writer strWriter = new StringWriter();
				try 
				{
					mapper.writeValue(strWriter, paramMap);
				} 
				catch (JsonGenerationException e) 
				{
					e.printStackTrace();
				}
				catch (JsonMappingException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				String str = strWriter.toString();
				log.info("The json string the will be sent to the service is  : " +str);
		        
			OutputStreamWriter out= new OutputStreamWriter(con.getOutputStream());
			//out.write(buf.toString().getBytes());
			String strww="{\"CardNumber\":\"4111111111111111\",\"expMonth\":\"01\",\"postalCode\":\"3\",\"expYear\":\"2013\",\"source\":\"cosu\",\"address\":\"test\",\"NameOnCard\":\"test\",\"defaultaccountnumber\":\"1930001303\",\"amounttopay\":\"33.00\",\"state\":\"test\",\"uniquepin\":\"WY4SOM\",\"city\":\"test\"}";
			out.write(str);
			out.close();
			start	=	System.currentTimeMillis();
			log.info("Time BEFORE sending request : " + start);
			//getting the auth token from the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			 log.info("The tostring of reader is  :  " + reader.toString());
			StringBuffer line1 = new StringBuffer();
			log.info("Time After sending request : " + System.currentTimeMillis());
			log.info("total time  : " + (System.currentTimeMillis()	-	start));
			while ((line = reader.readLine()) != null)
			{
			   line1.append(line);
			   //log.info("The sting buffered inside the while loop is  :   "+line);
			}
			log.info("The buffred final string is ::: "+line1.toString());
			
			ObjectMapper readmapper = new ObjectMapper();
			 responseMap = new HashMap();
			try 
			{
				responseMap = readmapper.readValue( line1.toString() , HashMap.class );
			} 
			catch (JsonParseException e1) 
			{
				e1.printStackTrace();
			} 
			catch (JsonMappingException e1) 
			{
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			log.info("The HashMap is  ::: "+responseMap);
			reader.close();
		} 
		catch (IOException e)
		{
				e.printStackTrace();
		}
		return responseMap;
	}
	
	public void synclioSignup()
	{
		String contact	=		"insert into contactmanagementsystem.contact (uniquepin, contactname, contacttypeid, subgroupid, brandid)" +
						"values('FS0U1N','Habitat for Humanity East Bay','{5914973f-d40a-4a47-8119-6c71ea5ab961}','{6e8beea7-41c2-4009-a0b6-1f8aaebcd61f}'," +
						"'{10161485-1028-4a17-b57e-957dc8d96d58}')";
		System.out.println("");
	}
	public void insertdataINCMS()
	{
		HashMap dataMap	=	null;
		
		try
		{
			dataMap	=	new HashMap(); 
			dataMap.put("uniquepin","4U1PF5");
			dataMap.put("loginmailid","infinitichiro@gmail.com");
			dataMap.put("skillsetid","c2c6c5c5-b76c-4836-b0bb-2b02591638fe");
			dataMap.put("skilllevel","5");
					
			String response	=	new Test().urlFetchPost(dataMap);
			log.info("response : " + response);
		}
		catch(Exception e)
		{
			
		}
	}
	public String urlFetchPost(HashMap paramMap)
	{
		String line 			=	null;;
		Long start		=	null;
		String responseMap	=	null;
		try
		{
			URL url = new URL("http://cs.live-cms.appspot.com/services/data/AssignSkill");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestMethod("POST");
			con.setConnectTimeout(60000);
			con.setReadTimeout(70000);
			con.setRequestProperty("Content-Type", "application/json");
		     log.info("paramMap : " + paramMap);
		        
		        ObjectMapper mapper = new ObjectMapper();
				Writer strWriter = new StringWriter();
				try 
				{
					mapper.writeValue(strWriter, paramMap);
				} 
				catch (JsonGenerationException e) 
				{
					e.printStackTrace();
				}
				catch (JsonMappingException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				String str = strWriter.toString();
				log.info("The json string the will be sent to the service is  : " +str);
		        
			OutputStreamWriter out= new OutputStreamWriter(con.getOutputStream());
			//out.write(buf.toString().getBytes());
			out.write(str);
			out.close();
			start	=	System.currentTimeMillis();
			log.info("Time BEFORE sending request : " + start);
			//getting the auth token from the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			 log.info("The tostring of reader is  :  " + reader.toString());
			StringBuffer line1 = new StringBuffer();
			log.info("Time After sending request : " + System.currentTimeMillis());
			log.info("total time  : " + (System.currentTimeMillis()	-	start));
			while ((line = reader.readLine()) != null)
			{
			   line1.append(line);
			   //log.info("The sting buffered inside the while loop is  :   "+line);
			}
			log.info("The buffred final string is ::: "+line1.toString());
			
			ObjectMapper readmapper = new ObjectMapper();
			
			try 
			{
				responseMap = readmapper.readValue( line1.toString() , String.class );
			} 
			catch (JsonParseException e1) 
			{
				e1.printStackTrace();
			} 
			catch (JsonMappingException e1) 
			{
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			log.info("The HashMap is  ::: "+responseMap);
			reader.close();
		} 
		catch (IOException e)
		{
				e.printStackTrace();
		}
		return responseMap;
	}
}

class Bean
{
	private String a;
	private String b;
	public void setA(String m)
	{
		a= m;
	}
	public String getA()
	{
		return a;
	}
	public void setB(String m)
	{
		b=m;
	}
	public String getB()
	{
		return b;
	}
	
	
}