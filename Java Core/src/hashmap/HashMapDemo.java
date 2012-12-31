package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import arraylistcheck.People;


public class HashMapDemo
{
	public static void main(String args[])
	{
	//	new HashMapDemo().checkReferenceIsAltered();
		new HashMapDemo().testMapOrder();
	}
	public void testMapOrder()
	{
		try
		{
			SortedMap 			titleKeysMap	=	null;
			titleKeysMap	=	new TreeMap();
			//HashMap<Integer,String> map	=	new HashMap<Integer,String>();
			titleKeysMap.put(5, "one");
			titleKeysMap.put(2, "two");
			titleKeysMap.put(3, "three");
			System.out.println(titleKeysMap.keySet());
			Set set	=	titleKeysMap.keySet();
			Iterator	iterator	=	set.iterator();
			while(iterator.hasNext())
			{
				System.out.println(" fdf " +iterator.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void iterateHashMap()
	{
		try
		{
			HashMap<Integer,String> map	=	new HashMap<Integer,String>();
			map.put(1, "one");
			map.put(2, "two");
			map.put(3, "three");
			for(Map.Entry<Integer, String> entry: map.entrySet() )
			{
				System.out.println("entry : " + entry);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkReferenceIsAltered()
	{
		HashMap peopleMap	=	null;
		People 	people		=	null;
		People 	peopleTemp		=	null;
		try
		{
			peopleMap	=	new HashMap();
			people	=	new People();
			people.setName("Sridhar 'R\"\"");
			
			people.setPeopleId("08989898989898989898989");
			
			peopleMap.put("people", people);
			
			System.out.println("The People object Inside the hashmap is  : "+peopleMap.get("people"));
			
			peopleTemp	=	(People)peopleMap.get("people");
			
			peopleTemp.setName(peopleTemp.getName().replace("\"", ""));
			peopleTemp.setName(peopleTemp.getName().replace("\'", ""));
			
			//peopleTemp.getName().replace("\"", "");
			System.out.println("The people object after removing the appostrophe is  : " + peopleMap.get("people"));
			
		}
		catch(Exception e)
		{
			//log.log(java.util.logging.Level.SEVERE ,e.getMessage(),e);
			e.printStackTrace();
			
		}
	}
}
