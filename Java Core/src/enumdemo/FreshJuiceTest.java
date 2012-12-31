package enumdemo;



class FreshJuice
{
	enum FreshJuiceSize
	{
		SIZE, MEDUIM, LARGE
	}

	FreshJuiceSize	size;
}

public class FreshJuiceTest
{
	public static void main(String args[])
	{
		FreshJuice juice = new FreshJuice();
		juice.size = FreshJuice.FreshJuiceSize.MEDUIM;
		System.out.println("juice.size : " +juice.size);
		System.out.println(FreshJuice.FreshJuiceSize.MEDUIM);
	}
}