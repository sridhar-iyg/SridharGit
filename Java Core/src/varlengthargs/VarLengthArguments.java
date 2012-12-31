package varlengthargs;

import java.util.HashMap;

public class VarLengthArguments
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		varDemo("hari","sadu");
		varDemo("hari","kumar","kumar");

	}
public static void varDemo(String ... strings )
{
	HashMap<String, Object> hm = new HashMap<String, Object>();
	for (String string : strings)
	{
		hm.put(string, string);
		
	}
	for ( String string : strings)
	{
		System.out.println(hm.get(string));
	}
}
}
