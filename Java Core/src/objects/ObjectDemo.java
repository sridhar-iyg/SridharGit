package objects;

import java.util.HashMap;

public class ObjectDemo
{

	/**
	 * @author Sridhar.Ragunathan
	 * This program show the scope and the characteristic of objects.
	 * her i am not returning the car object from the two function but the value is still retained.
	 * so the changes are affected to the referenced object.
	 * 
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Car	carObj	=	new Car();
			ModifyObjects objDemo	=new ModifyObjects();
			HashMap<String, Object> testMap	=	new HashMap<String, Object>();
			
			System.out.println("carObj : " + carObj + "\n The hash map is : " +testMap);
			objDemo.modifyObject(carObj,testMap);
			System.out.println("carObj : " + carObj + "\n The hash map is : " +testMap);
			objDemo.modifyCarObject(carObj,testMap);
			System.out.println("carObj : " + carObj + "\n The hash map is : " +testMap);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
