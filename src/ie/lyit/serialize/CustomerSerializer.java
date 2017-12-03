package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.lyit.Hotel.Customer;
import ie.lyit.Hotel.Name;



public class CustomerSerializer implements CustomerSerializerDao {
	ArrayList<Customer> customers;
	List<CustomerSerializer.Memento> undoList;// = new ArrayList<CustomerSerializer.Memento>();
	
	final String FILENAME = "customers.ser";
	
	public CustomerSerializer(){
		customers = new ArrayList<Customer>();			//List of all customers
	}
	
	public List<CustomerSerializer.Memento> GetUndoListFromSave() {
		if (undoList == null){
			undoList = new ArrayList<CustomerSerializer.Memento>();
		}
		return undoList;
	}
														//Start of Memento Pattern 
    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.customers);
    }
 
    public void restoreFromMemento(Memento memento) {
        this.customers = new ArrayList<Customer>();
        for	(int i=0; i<memento.getSavedCustomers().size(); i++){
    		customers.add(memento.getSavedCustomers().get(i));
    	}
        System.out.println("Originator: customers after restoring from Memento: " + customers);
    }
 
    public static class Memento implements Serializable {
        private final ArrayList<Customer> customers;

        public Memento(ArrayList<Customer> customersToSave) {
        	customers = new ArrayList<Customer>();
        	for	(int i=0; i<customersToSave.size(); i++){
        		customers.add(customersToSave.get(i));
        	}
        }
 
        // accessible by outer class only
        private ArrayList<Customer> getSavedCustomers() {
            return customers;
        }
    }													//End of Memento Pattern
	
    
	public void add() {									//add customer to list
		
		Customer customer = new Customer();
		customer.read();
		customers.add(customer);
	}
	
	public void list() {								//print out whole customerlist
		System.out.println("All Customers:");
		for(Customer tmpCustomer:customers)
			System.out.println(tmpCustomer);
	}
	
	public void view(int number){						//print out customer with a specific number
		System.out.println("Customer with the number " + number + ":");
		for(Customer tmpCustomer:customers){
			if (tmpCustomer.getNumber() == number){
				System.out.println(tmpCustomer);
				return;
			}
		}
		System.out.println("No customer found!");
	}
	
	public void editCustomer(int number){				//edit customer with a specific number
		
		for(Customer tmpCustomer:customers){
			if (tmpCustomer.getNumber() == number){

				JTextField t = new JTextField();			//user can see all detils of the customer in a gui and can change them
				JTextField fN = new JTextField();
				JTextField sN = new JTextField();
				JTextField a = new JTextField();
				JTextField pN = new JTextField();
				JTextField eA = new JTextField();
				
				t.setText(tmpCustomer.getName().getTitle());
				fN.setText(tmpCustomer.getName().getFirstName());
				sN.setText(tmpCustomer.getName().getSurName());
				a.setText(tmpCustomer.getAddress());
				pN.setText(tmpCustomer.getPhoneNumber());
				eA.setText(tmpCustomer.getEmailAddress());
				
			    Object[] message = {
			    	"Title:", t,
			    	"Firstname:", fN,
			    	"Surname:", sN,
			    	"Address:", a,
			    	"Phone number:", pN,
			    	"E-Mail:", eA,
			    };
			
			    int option = JOptionPane.showConfirmDialog(null, message, "Change customer details", JOptionPane.DEFAULT_OPTION);
			
			    if (option == JOptionPane.OK_OPTION){
			    	tmpCustomer.setName(new Name(t.getText(), fN.getText(), sN.getText()));
			    	tmpCustomer.setAddress(a.getText());
			    	tmpCustomer.setPhoneNumber(pN.getText());
			    	tmpCustomer.setEmailAddress(eA.getText());
			    }
				
				return;
			}
		}
		System.out.println("No customer found!");
	}
	
	public void deleteCustomer(int number){					//delete customer with a specific number
		
		for(Customer tmpCustomer:customers){
			if (tmpCustomer.getNumber() == number){
				customers.remove(tmpCustomer);
				return;
			}
		}
		System.out.println("No customer found!");
	}
	
	public int getHeighestNumber(){							//returns highest number of all customers
		int heighestNumber = 0;
		for(Customer tmpCustomer:customers){
			if (tmpCustomer.getNumber() > heighestNumber){
				heighestNumber = tmpCustomer.getNumber();
			}
		}
		return heighestNumber;
	}
	
	public void writeRecordsToFile() {						//save
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			os.writeObject(customers);
			os.writeObject(undoList);
			
			os.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store customers.");
		}
		catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
	}
	
	public void readRecordsFromFile() {						//load
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
			ObjectInputStream is = new ObjectInputStream(fileStream);
			customers = (ArrayList<Customer>)is.readObject();
			undoList = (List<CustomerSerializer.Memento>)is.readObject();
			is.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot found file where customers are stored.");
		}
		catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
