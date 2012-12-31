package interfaceexample;

public interface ICircle
{

	class Point
	{
		
		private int x;
		private int y;
		
		
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public int getX()
		{
			return x;
		}
		public void setX(int x)
		{
			this.x = x;
		}
		public int getY()
		{
			return y;
		}
		public void setY(int y)
		{
			this.y = y;
		}
		
		
	}
	public Point center	=	new Point(5, 6);
	public void draw();
}

