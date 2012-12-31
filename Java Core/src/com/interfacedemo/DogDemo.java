package com.interfacedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * @author sridhar.ragunathan
 * This demo  explains of over riding the comparator interface and comparable interface
 * It makes u understand  the sort and the over ride sort method.
 * 
 * Task printing the list of dogs based on the age order.
 * REF : http://www.tutorialspoint.com/java/java_using_comparator.htm
 *
 */
public class DogDemo
{
	public static void main(String args[])
	{
		// Takes a list o Dog objects
		List<Dog> list = new ArrayList<Dog>();

		list.add(new Dog("Shaggy", 3));
		list.add(new Dog("Lacy", 2));
		list.add(new Dog("Roger", 10));
		list.add(new Dog("Tommy", 4));
		list.add(new Dog("Tammy", 1));
		
		Collections.sort(list);// Sorts the array list

		for (Dog a : list)
		{
			// printing the sorted list of names
			System.out.print(a.getDogName() + ", ");
		}

		// Sorts the array list using comparator
		Collections.sort(list, new Dog());
		
		System.out.println(" ");
		for (Dog a : list)
		{
			// printing the sorted list of ages
			System.out.println(a.getDogName() + "  : " +a.getDogAge() + ", ");
		}
	}
}

class Dog implements Comparator<Dog>, Comparable<Dog>
{
	private String	name;
	private int		age;

	Dog()
	{
	}

	Dog(String n, int a)
	{
		name = n;
		age = a;
	}

	public String getDogName()
	{
		return name;
	}

	public int getDogAge()
	{
		return age;
	}

	// Overriding the compareTo method
	public int compareTo(Dog d)
	{
		return (this.name).compareTo(d.name);
	}

	// Overriding the compare method to sort the age
	public int compare(Dog d, Dog d1)
	{
		return d.age - d1.age;
	}
}
