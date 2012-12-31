package arraylistcheck;

public class People
{
	private String name		=	null;
	private String peopleId	=	null;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPeopleId()
	{
		return peopleId;
	}
	public void setPeopleId(String peopleId)
	{
		this.peopleId = peopleId;
	}
	@Override
	public String toString()
	{
		return "People [name=" + name + ", peopleId=" + peopleId + "]";
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((peopleId == null) ? 0 : peopleId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (peopleId == null)
		{
			if (other.peopleId != null)
				return false;
		}
		else if (!peopleId.equals(other.peopleId))
			return false;
		return true;
	}
	
	
}
