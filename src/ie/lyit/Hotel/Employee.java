package ie.lyit.Hotel;

public class Employee extends Person implements Payable {
		
	private Date dateOfBirth;
	private Date startDate;
	private float salary;
	private int number;
	
	private static int nextNumber = 1;
	
	public Employee() {
		dateOfBirth = startDate = new Date();
		salary = 0;
		number = nextNumber++;
	}
	
	public Employee(String t, String fN, String sN, String a, String pN, int dOBDay, int dOBMonth, int dOBYear, int sDDay, int sDMonth, int sDYear, int s) {
		super(t, fN, sN, a, pN);
		dateOfBirth = new Date(dOBDay, dOBMonth, dOBYear);
		startDate = new Date(sDDay, sDMonth, sDYear);
		salary = s;
		number = nextNumber++;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return name + " " + address + " " + phoneNumber + " " + dateOfBirth + " " + startDate + " " + salary + " " + number;
	}
	
	public boolean equals(Object obj) {
		Employee eObject;
		if (obj instanceof Employee)
			eObject = (Employee)obj;
		else
			return false;
		
		return (this.name.equals(eObject.name) 
				&& this.address.equals(eObject.address)
				&& this.phoneNumber == eObject.phoneNumber
				&& this.dateOfBirth.equals(eObject.dateOfBirth)
				&& this.startDate.equals(eObject.startDate)
				&& this.salary == eObject.salary
				&& this.number == eObject.number);
	}

	public double calculateWage(double taxPercentage) {
		return (salary / 12) - (salary * (taxPercentage / 100));
	}

	public double incrementSalary(double incrementAmount) {
		double incrementedSalary = salary + incrementAmount;
		if (incrementedSalary > 150000)
			return 150000;
		return incrementedSalary;
	}
}
