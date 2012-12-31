package arraylistcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArrayListDemo
{
	public static void main(String [] args)
	{
		new ArrayListDemo().printArrayListString();
	}
	public void timeUnitTest()
	{
		Lock lock	
	}
	public void printArrayListString()
	{
		List strlist	=	new ArrayList();
		try
		{
			strlist.add("Sridhar R");
			strlist.add(new People());
			System.out.println(strlist);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void arrayListReferencecheck()
	{
		ArrayList<People>	peopleList=	new ArrayList<People>();
		People p1	=	new People();
		People p2	=	new People();
		
		p1.setName("Sridhar");
		p2.setName("Srikanth");
		p1.setPeopleId("12345");
		
		p2.setPeopleId("678910");
		
		peopleList.add(p1);
		//peopleList.add(p2);
		
		System.out.println("PeopleList : " +peopleList);
		
		People p3	=	peopleList.get(0);
		
		p3.setName("Ragunathan");
		p3.setPeopleId("44444444");
		System.out.println("p3 : " +p3);
		System.out.println("PeopleList : " +peopleList.size());
		
		
	//	System.out.println("p1 : " +p1);
	//	System.out.println("p1 : " +p1.equals(p1));
		
		//System.out.println(p1 instanceof People);
		int n	= peopleList.size();
		System.out.println("Size of n : " +n);
		if(n!=0)
		{
			n=n-1;
			System.out.println("Size of n : " +n);
			
		}
		for(int j=0;j<=n;j++)
		{
			System.out.println("TEST" +j);
		}
	}
}
