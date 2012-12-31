package equalsdemo;

public class EqualsDemo
{
	public static void main(String args[])
	{
		//new EqualsDemo().primitiveEqualComparison();
		new EqualsDemo().wrapperIntegerDemo();
		new EqualsDemo().wrapperStringDemo();
	}

	public void primitiveEqualComparison()
	{
		int a	=	5;
		int b	=	5;
		try
		{
			System.out.println( a==b);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void wrapperIntegerDemo()
	{
		Integer a	=	5;
		Integer b	=	5;
		
		Integer c	=	new Integer(4);
		Integer d	=	new Integer(4);
		Integer e	=	new Integer(5);
		try
		{
			System.out.println( a);
			System.out.println("a == b  : direct assignement it is a primitive : " + ( a==b));
			System.out.println( "a.equals(b) : Checks for same memory location" + a.equals(b));
			System.out.println( "c == d : New asignement so it is object"+  (c==d) );
			System.out.println( "c.equals(d) : " + c.equals(d));
			System.out.println( "c.compareTo(e) : " + c.compareTo(e));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void wrapperStringDemo()
	{
		String a	=	"Hello";
		String b	=	"World";
		
		String c	=	new String("Hello");
		String d	=	new String("Hello");
		String e	=	new String("World");
		String name="Sridhar";
		try
		{
			System.out.println("STring Compare Demo!!!");
			System.out.println("name : " + name);
			name="yeppi";
			System.out.println("name edited is  : " + name);
			System.out.println( a);
			System.out.println(a+ " =="+ b +" : direct assignement of String) : " + ( a==b));
			System.out.println( a +".equals("+ b +") : " + a.equals(b));
			System.out.println( c+" == "+d+" : New asignement so it is object : Checks for same memory location"+  (c==d) );
			System.out.println( c+".equals("+d+") : " + c.equals(d));
			System.out.println( c+".compareTo("+d+") : " + c.compareTo(d));
			System.out.println( c+".compareTo("+e+") : " + c.compareTo(e));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
