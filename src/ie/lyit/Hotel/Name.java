package ie.lyit.Hotel;

import java.io.Serializable;

public class Name implements Serializable{
	private String title;
	private String firstName;
	private String surName;
	
	public Name() {
		title = firstName = surName = null;
	}
	
	public Name(String t, String fN, String sN) {
		title = t;
		firstName = fN;
		surName = sN;
	}
	
	public String toString() {
		return title + " " + firstName + " " + surName;
	}

	@Override
	public boolean equals(Object obj) {
		Name nObject;
		if (obj instanceof Name)
			nObject = (Name)obj;
		else
			return false;
		
		return (this.title.equals(nObject.title) 
				&& this.firstName.equals(nObject.firstName)
				&& this.surName.equals(nObject.surName));
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}

	public void setFirstName(String fN) {
		firstName = fN;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setSurName(String sN) {
		surName = sN;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public boolean isFemale() {
		if (title.equalsIgnoreCase("Miss") || title.equalsIgnoreCase("Ms") || title.equalsIgnoreCase("Mrs"))
			return true;
		
		return false;
	}
	
	

}
