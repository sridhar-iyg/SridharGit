package varlengthargs;

public class ExceptionDemo
{

	 void trace()
	{
		System.out.println("indise exception dem o");
	}
}
class DER extends ExceptionDemo
{
	
	void trace()
	{
		super.trace();
		System.out.println("indise o");
	}
	public static void main (String args[])
	{
		DER bu= new DER();
		bu.trace();
	}
}
