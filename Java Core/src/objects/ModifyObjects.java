package objects;

import java.util.HashMap;

public class ModifyObjects
{
	public void modifyObject(Car carObj,HashMap<String,Object> hm)
	{
		System.out.println("before updating the object and the hashmap : " + carObj+"\n"+hm);
		carObj.setColor("green");
		carObj.setName("versa");
		carObj.setNumber(12345);
		hm.put("Call 1", "I am created");
	}
	public void modifyCarObject(Car carObj,HashMap<String,Object> hm)
	{
		System.out.println("before updating the object and the hashmap : " + carObj+"\n"+hm);
		carObj.setColor("blue");
		carObj.setName("titan");
		carObj.setNumber(678901);
		hm.put("Call 1", "I am modified");
	}
}
