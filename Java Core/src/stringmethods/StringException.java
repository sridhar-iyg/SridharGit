package stringmethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class StringException
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		HashMap hm	=	new HashMap();
		hm.put("key1", "10");
		hm.put("key2", null);
		String getKey	=	(String)hm.get("key2");
		System.out.println("getKey :  " + getKey);
		System.out.println("hm.get values : " + hm.get("key1") + "\n " + hm.get("key2"));
		SimpleDateFormat sdf = new SimpleDateFormat( "dd-MMM-yyyy" );
		Date date = new Date();
		System.out.println("date : " +date);
		String paymentdate = (String) ( sdf.format( date ) );
		System.out.println("paymentdate : " +paymentdate);
		System.out.println("c21f969b5f03d33d43e04f8f136e7682".compareTo("c21f969b5f03d33d43e04f8f136e7682"));
		/*DateFormat dateParserForView = new SimpleDateFormat( "h:mm a" );*/
		DateFormat dateParserForView = new SimpleDateFormat( "dd MMM" );
		System.out.println("dateParserForView  : " + dateParserForView.format(date));
		/*String str=null;
		 
		if(str==null)
		{
			System.out.println("it is null");
		}
		else
		{
			System.out.println("not null");
		}*/
		HashMap hma	=	null;
		String vv	=	(String)(hma.get("isstyleexist")) ;
		System.out.println("vv :  " + vv);
	}

}
