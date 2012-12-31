import java.util.ArrayList;


public class InstanceOfDemo
{
	public static void main(String args[])
	{
		ArrayList	tets	=	new ArrayList();
		try
		{
			System.out.println(tets instanceof ArrayList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
