package equalsandhashcode;

public class Patient
{
	public int id;
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Patient)
		{
			Patient patient 	=	(Patient) obj;
			if(patient.id	==	this.id)
			{
				return true;
			}
		}
		return false;
	}
	public int hashCode()
	{
		return 9*id;
	}
	public static void main(String args[])
	{
		Patient patient	=	 new Patient();
		System.out.println(patient.hashCode() + "" + patient.equals(new Patient()));
	}
}