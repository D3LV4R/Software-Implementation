package ie.lyit.Testers;

import ie.lyit.Hotel.Customer;

public class CustomerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer1 = new Customer("Mr", "Max", "Peters", "Firstroad 2", "03541276", "mp@lyit.ie");
		Customer customer2 = new Customer("Mr", "Hans", "Schulz", "Firstroad 1", "03423545", "hs@lyit.ie");
		System.out.println(customer1);
		System.out.println(customer2);
		
		if (customer1.equals(customer2))
			System.out.println(customer1 + " is the same as " + customer2);
		else
			System.out.println(customer1 + " is not the same as " + customer2);
		
		customer1.setPhoneNumber("0216546851");
		System.out.println(customer1);
	}

}
