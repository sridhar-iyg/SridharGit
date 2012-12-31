

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.data.Form;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.acti.cs.util.AppCacheManager;
import com.acti.cs.util.CommonUtilities;
import com.acti.helper.SettingsHelperNew;
public class RestLetTest
{
	@Autowired
	protected RestTemplate restTemplate = new RestTemplate();
	private static Logger		log		      = Logger.getLogger( RestLetTest.class.getPackage().getName() );
	public static void main(String[] args) 
	{
		String username	=	"test1238@test.com";
		String password	=	"c21f969b5f03d33d43e04f8f136e7682";
		//new RestLetTest().CallRestlet();
		new RestLetTest().callCMS(username,password);
	}
	public void callCMS(String username,String password)
	{
		ClientResource client 		= 	null;
		HashMap hm 					= 	null;
		String  dataStoreUrl			=	"http://cwa20.stagin-cms.appspot.com";
		System.out.println("dataStoreUrl ::"+dataStoreUrl);
		
		HashMap<String,Object> myLoginMap			=	null;
		String responseData	 						= 	"";
		HashMap<String,Object> lAddNewAgentMap 		= 	null;
		ObjectMapper mapper							=	new ObjectMapper();
		CommonUtilities lCommonUtilities 			= new CommonUtilities();
		lAddNewAgentMap 							= new HashMap<String,Object>();
		try
		{
			
			lAddNewAgentMap.put("username", username);
			lAddNewAgentMap.put("password", password);
			String agentDetailJsonString     	= lCommonUtilities.convertObjectToString(lAddNewAgentMap);
			log.info("agentDetailJsonString  "	+	agentDetailJsonString);
			responseData		= restTemplate.postForObject(dataStoreUrl + "/loginAction" , agentDetailJsonString,String.class);
			myLoginMap 			= mapper.readValue( responseData , HashMap.class );
			log.info( "Sent request to Restlet server!" +responseData);
			log.info("The popMap is  :  " + myLoginMap);
			String lUniquepin 	= (String)myLoginMap.get("lUniquepin");
			log.info("Is login exists value is : "+myLoginMap.get("isLoginExist"));
			String isLoginExists = (String)myLoginMap.get("isLoginExist");
		}
		catch ( ResourceException e )
		{
			log.log( java.util.logging.Level.INFO  , e.getMessage() ,  e );
			e.printStackTrace();
		}
		catch ( Exception e1 )
		{
			log.log( java.util.logging.Level.INFO  , e1.getMessage() ,  e1 );
			e1.printStackTrace();
		}
	}

	public void CallRestlet() 
	{
		
		String lAccountNumber = "8005956534";
		String uniquepin		=	"5KJHX";
		ClientResource client 		= new ClientResource( "http://sridhar.webservices.a-cti.com:8080/BrandingDetailsByAccountNumber" );
		System.out.println("inside callrestlet method");
		try 
		{
			client.post(getLoginRepresentation(uniquepin,lAccountNumber));
			System.out.println("Sent request to Restlet server!");
		} 
		catch (ResourceException e1) 
		{
			System.out.println("Caught ResourceException");
			e1.printStackTrace();
		}
		catch (Exception e1) 
		{
			System.out.println("Caught Exception");
			e1.printStackTrace();
		}
		System.out.println("client.getStatus( after posting request ) :"+ client.getStatus());

		// getting the response
		try
		{
			System.out.println(" After creating objectRepresentation1 ");
			HashMap myLoginMap = null;
			if (client.getStatus().isSuccess()) {
				System.out.println(" if block started"+client);

				//if ( client.getStatus().isSuccess() )
					{

						ObjectRepresentation	lObjectRepresentation = new ObjectRepresentation( client.getResponseEntity() );
						 myLoginMap = (HashMap <String , Object>) lObjectRepresentation.getObject();

						System.out.println( " Number of params in the list :  " + myLoginMap.size() );
						System.out.println( " Login HashMap is : " + myLoginMap );

					}
				
					System.out.println( " Response string : " + myLoginMap );

			}
			System.out.println("After If Block ");
		} catch (Exception e) {
			System.out.println("Caught Exception while handling Response");
			e.printStackTrace();
		}
		
	}

	public static Representation getLoginRepresentation(String uniquepin,String lAccountNumber) 
	{
		
		Form form = new Form();

		form.add("accountnumber", lAccountNumber);
	//	form.add("uniquepin", uniquepin);
	

		return form.getWebRepresentation();
	}
	
}
