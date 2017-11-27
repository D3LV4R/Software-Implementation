package ie.lyit.Testers;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.lyit.Hotel.Customer;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	private static CustomerSerializer customerSerializer = new CustomerSerializer();			//initialisation of the serializer of the customer
	
	public static void main(String[] args) {
		
		boolean programRuns = true;						//true until the program should end
		customerSerializer.readRecordsFromFile();		//serializer open the .ser file
		
		Customer.setNextNumber(customerSerializer.getHeighestNumber() + 1);			//number for the next customer who will be added
						
		while(programRuns){

			JTextField number = new JTextField();		//user type in a number for what he wants to do
			number.requestFocus();
			
		    Object[] message = {
		    	"1: add Customer | 2: view Customer | 3: edit Customer | 4: delete Customer | 5: list all Customers", number,
		    };
		
		    int option = JOptionPane.showConfirmDialog(null, message, "What do you want to do?", JOptionPane.OK_CANCEL_OPTION);
		
		    if (option == JOptionPane.OK_OPTION){
		    	
		    	int selection = Integer.parseInt(number.getText());		//convertion from text to int (possible error)
		    	
		    	switch(selection){										//method for each option
			    	case 1: addCustomer(); break;
			    	case 2: viewCustomer(); break;
			    	case 3: editCustomer(); break;
			    	case 4: deleteCustomer(); break;
			    	case 5: listAllCustomers(); break;
			    	default: programRuns = false;
		    	}
		    	
		    }   
		    else{
		    	programRuns = false;									//program shall end
		    }

		}

		customerSerializer.writeRecordsToFile();						//serializer saves file
		System.out.println("Program finished");
		
	}
	
	private static void addCustomer(){
		customerSerializer.add();
	}
	
	private static void viewCustomer(){
		int number = getNumberFromUser("see:");							//user has to type in the number of a customer he wants to see
		customerSerializer.view(number);
	}
	
	private static void editCustomer(){
		int number = getNumberFromUser("edit:");
		customerSerializer.editCustomer(number);
	}
	
	private static void deleteCustomer(){
		int number = getNumberFromUser("delete:");
		customerSerializer.deleteCustomer(number);
	}
	
	private static void listAllCustomers(){
		customerSerializer.list();
	}
	
	private static int getNumberFromUser(String purpose){
		JTextField number = new JTextField();
		
	    Object[] message = {
	    	"Number of Customer you want to " + purpose, number,	//user has to type in a number
	    };
	
	    int option = JOptionPane.showConfirmDialog(null, message, "Enter a valid number", JOptionPane.DEFAULT_OPTION);
	
	    if (option == JOptionPane.OK_OPTION){
	    	
	    	return Integer.parseInt(number.getText());		//possible error
	    }
	    else{
	    	System.out.println("never");
	    	return 0;
	    }
	}

}
