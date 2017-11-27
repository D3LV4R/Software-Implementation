package ie.lyit.Hotel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Customer extends Person {
	
	private String emailAddress;
	private int number;	
	
	private static int nextNumber = 1;
	
	public Customer() {
		emailAddress = null;
		number = nextNumber++;
	}
	
	public Customer(String t, String fN, String sN, String a, String pN, String eA) {
		super(t, fN, sN, a, pN);
		emailAddress = eA;
		number = nextNumber++;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static void setNextNumber(int nextNumber){
		Customer.nextNumber = nextNumber;
	}
	
	public String toString() {
		return name + " " + address + " " + phoneNumber + " " + emailAddress + " " + number;
	}
	
	public boolean equals(Object obj) {
		Customer cObject;
		if (obj instanceof Customer)
			cObject = (Customer)obj;
		else
			return false;
		
		return (this.name.equals(cObject.name) 
				&& this.address.equals(cObject.address)
				&& this.phoneNumber == cObject.phoneNumber
				&& this.emailAddress.equals(cObject.emailAddress)
				&& this.number == cObject.number);
	}
	
	public void read(){								//user can create a customer with the help of gui
		JTextField t = new JTextField();
		JTextField fN = new JTextField();
		JTextField sN = new JTextField();
		JTextField a = new JTextField();
		JTextField pN = new JTextField();
		JTextField eA = new JTextField();

	    Object[] message = {
	    	"Title:", t,
	    	"Firstname:", fN,
	    	"Surname:", sN,
	    	"Address:", a,
	    	"Phone number:", pN,
	    	"E-Mail:", eA,
	     };
	
	    int option = JOptionPane.showConfirmDialog(null, message, "Enter customer details", JOptionPane.DEFAULT_OPTION);
	
	    if (option == JOptionPane.OK_OPTION){
	    	this.name = new Name(t.getText(), fN.getText(), sN.getText());
	    	this.address = a.getText();
	    	this.phoneNumber = pN.getText();
	    	this.emailAddress = eA.getText();
	    }   
	}
	
}
