package interfaceexample;


public class Eclipse implements ICircle
{
	
	public Eclipse()
	{
		
	}
	@Override
	public void draw()
	{
		System.out.println("Cicle with center : " + center.getX() +  " : " +center.getY()  );
	}
	public static void main(String args[])
	{
		 Eclipse e 	=	 new Eclipse();
		 e.draw();
	}
	
}
