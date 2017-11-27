package ie.lyit.Hotel;

import java.io.Serializable;

public abstract class Person implements Serializable{
	protected Name name;
	protected String address;
	protected String phoneNumber;
	
	public Person() {
		name = new Name();
		address = phoneNumber = null;
	}
	
	public Person(String t, String fN, String sN, String a, String pN) {
		name = new Name(t, fN, sN);
		address = a;
		phoneNumber = pN;
	}
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return name + " " + address + " " + phoneNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person pObject;
		if (obj instanceof Person)
			pObject = (Person)obj;
		else
			return false;
		
		return(name.equals(pObject.name) &&
				address.equals(pObject.address) &&
				phoneNumber.equals(pObject.phoneNumber));
	}
}
