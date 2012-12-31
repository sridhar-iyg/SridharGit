package downcasting;

public class ZZY extends XTC {
	static int i;

	void trace(ZZY z, char c)
	{
		i += 10;
	}

	void trace(XTC x, int i)
	{
		System.out.println(" in trace method " + i + x.getClass());
		this.i += 20;
		//System.out.println("the value of i is : " +i);
	}

	public static void main(String args[])
	{
		XTC x = new ZZY();
		ZZY z = new ZZY();
		
		System.out.println(x instanceof ZZY);
		System.out.println(z instanceof ZZY);
		
		x.trace(x, 10);
		System.out.println(i);//30
		x.trace((ZZY) x, 'c');
		System.out.println(i);
		z.trace(z,'c');
		System.out.println(i);
		z.trace(z, (char) 99);
		System.out.println(i);
		z.trace(z, 1000);
		System.out.println(i);
	}
}
