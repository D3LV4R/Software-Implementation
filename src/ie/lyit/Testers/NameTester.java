package ie.lyit.Testers;

import java.util.ArrayList;

import ie.lyit.Hotel.Name;

public class NameTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Name> persons = new ArrayList<Name>();
	
		persons.add(new Name("Mr", "Bob", "Simpson"));
		persons.add(new Name("Ms", "Matilda", "Simpson"));
		persons.add(new Name("Mrs", "Lena", "Nuke"));
		
		if (persons.get(0).equals(persons.get(1)))
			System.out.println(persons.get(0) + " is the same as " + persons.get(1));
		else
			System.out.println(persons.get(0) + " is not the same as " + persons.get(1));
		
		if (persons.get(0).isFemale())
			System.out.println(persons.get(0) + " is female");
		else
			System.out.println(persons.get(0) + " is male");
		
		persons.trimToSize();
		
		System.out.println("List:");
		for (Name tempName:persons)
			System.out.println(" " + tempName);
		
		if (nameSearch(persons.get(0), persons))
			System.out.println(persons.get(0) + " found in list");
		else
			System.out.println(persons.get(0) + " not found in list");
	}
	
	 private static boolean nameSearch(Name name, ArrayList<Name> persons){
		 if (persons.contains(name))
			 return true;
		 
		 return false;
	 }

}
