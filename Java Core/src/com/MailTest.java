package com;



import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Test;
import com.acti.signup.dto.SignUpDTO;

@Controller
public class MailTest
{
	private static final Logger log 	= 	Logger.getLogger(MailTest.class.getName());
	
	@RequestMapping("/testmail")
	public  @ResponseBody  String testmail( HttpServletRequest request)
	 {  
		
		String 			path								=	null;
		String 			servicePlanKey						=	null;
		HashMap<String,Object> mailDataMap	=	null;
		log.info("inside the help contoller");
		try
		{
			
			mailDataMap	=	new HashMap<String,Object>();
			
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
			
			
			mailDataMap.put("serviceplankey"		, "");
			mailDataMap.put("accountNumber", "No Account Number Selected");
			mailDataMap.put("additional_plan", "null,webchat,leadcapture");
			mailDataMap.put("signupDto" ,signupDto);
			mailDataMap.put("additonalServiceCharges" ,"0");
			mailDataMap.put("ccenabled" ,"true");
			
			log.info("The contents of the hash table before sending mail is  : " + mailDataMap);
			new Test().sendMail(mailDataMap,request.getParameter("filename"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return "";
	 }
	@RequestMapping("/testchat")
	public  @ResponseBody  String testchatmail( HttpServletRequest request)
	 {  
		log.info("inside the help contoller");
		try
		{
			new Test().sendChatMail(request.getParameter("filename"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return "";
	 }
	
}
