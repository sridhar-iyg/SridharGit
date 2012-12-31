package stringmethods;


public class StringMehtods
{
	public static void main(String args[])
	{
		
		//getFormattedString("8005956532,8005956534,8005956536");

	}
	public static void getFormattedString(String accountNumberJson )
	{
		try
		{
			if(accountNumberJson!=null && !accountNumberJson.trim().isEmpty())
			{
				System.out.println("acNoList : " + accountNumberJson);
				
				accountNumberJson	=	"'"	 +accountNumberJson.replaceAll(",", "','")+"'";
				
				System.out.println(accountNumberJson);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void checkForHashCode()
	{
		String s1	=	"hello";
		String s2	=	"hello";
		String s3	=	"76777676";
		String s4	=	"HELLO";
		System.out.println(s1.hashCode() +" : " +s2.hashCode() + " : " +s3.hashCode() +" : " +s4.hashCode());
	}
	public static void checkForUpperCase()
	{
		String companyName			=	"sridhar company ";
		String modifiedCompanyName	=	"";
		String nameArr[]			=	null;
		try
		{
			if(companyName!=null&& !companyName.isEmpty())
			{
				nameArr	=	companyName.split(" ");
				System.out.println("nameArr : " + nameArr.length);
				for(String str : nameArr)
				{
					System.out.println("str : " + str);
					modifiedCompanyName	=	modifiedCompanyName+" "+str.substring(0,1).toUpperCase()+str.substring(1,str.length());
				}
				System.out.println("modifiedCompanyName : " +modifiedCompanyName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
public static String ltrim(String source) {
    return source.replaceAll("^\\s+", "");
}

/* remove trailing whitespace */
public static String rtrim(String source) {
    return source.replaceAll("\\s", "");
}

/* replace multiple whitespaces between words with single blank */
public static String itrim(String source) {
    return source.replaceAll("\\b\\s{2,}\\b", " ");
}

/* remove all superfluous whitespaces in source string */
public static String trim(String source) {
    return itrim(ltrim(rtrim(source)));
}

public static String lrtrim(String source){
    return ltrim(rtrim(source));
}
public void demo()
{
	
		/*String str="Venkatesh A.    12:14 PM Thank you for contacting us. This is Venkatesh A. . How may I help you?        Venkatesh A.    12:14 PM Venkatesh A. has left. Chat is disconnected";
		
		System.out.println("using Char at : " + str.charAt(2));
		System.out.println("using Char at : " + str.charAt(8));
		System.out.println("Using codePoingAt : "+ str.codePointAt(8) +"for character :" +str.charAt(8));
		
		System.out.println("Using codePoint Before : "+ str.codePointBefore(8) +"for character :" +str.charAt(8));
		System.out.println("Using codePoint count : "+ str.codePointCount(0, 6) +"for character :" +str.charAt(8));
		String replaceStr="<div class=>";
		System.out.println("String replce all " +replaceStr.replaceAll("\\<.*?\\>","")+"dfa");
		*/
		String filteredChat =" Venkatesh A.    12:14 PM Thank you for contacting us. This is Venkatesh A. . How may I help you?        Venkatesh A.    12:14 PM Venkatesh A. has left. Chat is disconnected";
		
		/*filteredChat = filteredChat.replaceAll( "\\<.*?\\>" , "" );
		System.out.println("Filtered of tags :  "+filteredChat );*/
		
		/*filteredChat = filteredChat.replaceAll( "," , " " );
		System.out.println( "Replacing of commas with space" + filteredChat );
		filteredChat = filteredChat.replaceAll( "\n" , "" );
		
		filteredChat = filteredChat.replaceAll( "\b" , "" );
		filteredChat = filteredChat.replaceAll( "\r" , "" );*/
		
		filteredChat = filteredChat.replaceAll( "\\s+" , " " );
		String name	=	"Conversion Suppport".toLowerCase();
		name	=	name.replaceAll("\\s", "");
		System.out.println("name : " + name);
		
		/*System.out.println( "newLine filtered "+filteredChat  );*/
		filteredChat = filteredChat.trim();
		System.out.println("Filtered.trim :: " +filteredChat );
		
		/*filteredChat = filteredChat.replaceAll( "\\b\\s{2,}\\b", " " );
		System.out.println( "Filtering unnecessary space is  : "+filteredChat  );*/
		
		//filteredChat =lrtrim(filteredChat);
		System.out.println("Using the methods is :"+filteredChat );
		/*filteredChat =trim(filteredChat);
		filteredChat =itrim(filteredChat);
		filteredChat =ltrim(filteredChat);
		filteredChat =rtrim(filteredChat);
		System.out.println("Using the methods is :"+filteredChat );*/
	/*	System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
	*/	
}
}

