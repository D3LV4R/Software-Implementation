package ie.lyit.Testers;

import java.util.ArrayList;

import ie.lyit.Hotel.Employee;

public class EmployeeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1 = new Employee("Mr", "Bernd", "Wurst", "Hinterhof 4", "01238543525", 2, 5, 1994, 7, 11, 2016, 10000);
		Employee employee2 = new Employee("Mr", "Hans", "Wurst", "Hinterhof 2", "018965465", 8, 3, 1994, 7, 11, 2016, 14000);
		System.out.println(employee1);
		System.out.println(employee2);
		
		if (employee1.equals(employee2))
			System.out.println(employee1 + " is the same as " + employee2);
		else
			System.out.println(employee1 + " is not the same as " + employee2);
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(new Employee("Ms", "Magret", "Lauch", "Vordertuer 68", "0465318564", 6, 9, 1997, 2, 2, 2001, 11000));
		employees.add(new Employee("Mr", "Ulf", "Wurst", "Hinterhof 4", "01238543525", 2, 5, 1994, 7, 11, 2016, 10000));
		
		if (employeeSearch(employee1, employees))
			System.out.println(employee1 + " found in list");
		else
			System.out.println(employee1 + " not found in list");
	}
	
	private static boolean employeeSearch(Employee employee, ArrayList<Employee> employees) {
		if (employees.contains(employee))
			 return true;
		 
		 return false;
	}

}
