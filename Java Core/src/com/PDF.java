import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;


public class PDF
{
	public static void main(String args[])
	{
		generatePdf();
	}
	public static void generatePdf()
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/Sridhar/Desktop/demo.csv")));
			 String s2="empty";
			 System.out.println(s2+=br.readLine());
			 Document document	=	new Document();
			  
		 
		 
			 document.open();
			 document.add(new Paragraph("First page of the document."+s2));
			 document.close();
			 System.out.println("s2 : " + s2);
			
		}
		catch(Exception e)
		{
			
		}
		
	}

}
