package protectdemo;

public class ProtectedExample
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		c ob=new c();
		p o=new p();
		ob.meth1();
		o.meth();// TODO Auto-generated method stub

	}

}
class gp
{
	static protected int x=10;
}
class p extends gp
{
	void meth()
	{
		System.out.println(x);
	}
}
class c 
{
	void meth1()
	{
		gp o=new gp();
		System.out.println(o.x);
	}
}

