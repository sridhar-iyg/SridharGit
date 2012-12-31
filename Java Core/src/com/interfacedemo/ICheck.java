package com.interfacedemo;

interface check 
{
	public void message();
}

public class ICheck implements check
{
	public static void main(String[] args) 
	{
		try 
		{
			check t = new check() 
			{
				public void message()
				{
					System.out.println("Method defined in the interface");
				}
			};
			
			t.message();
			
			new ICheck().message();
		} 
		catch (Exception ex) 
		{
			System.out.println("" + ex.getMessage());
		}
	}

	@Override
	public void message()
	{
		System.out.println("This is a overrided method!!!");
		
	}

}
