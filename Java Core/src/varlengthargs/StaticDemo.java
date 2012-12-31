package varlengthargs;

public class StaticDemo
{
	public static void main(String[] args)
	{
		StaticDemo1 dm = new StaticDemo1();
		dm.democheck(20);
		dm.dd();
	}
}

class StaticDemo1
{
	static int i = 100;
	int c=1000;
	int a=2000;
	void democheck(int i )
	{
	/*	System.out.println("the value of i is : " + this.i ) ;
		this.i+=10;
		System.out.println("the value of i is : " + i ) ;
	*/	c=40;
		int a=3000;
		System.out.println("c is "+c);	
		System.out.println("a is "+this.a);
	}
	
	void dd()
	{
	System.out.println("c is "+c);
	System.out.println("a is "+a);
	}
	
}
