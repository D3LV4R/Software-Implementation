package ie.lyit.Hotel;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(){
		day = month = year = 0;
	}
	
	public Date(int d, int m, int y) throws IllegalArgumentException {
		if (d < 1 || d > 31 || m < 1 || m > 12 || y < 1900) {
			throw new IllegalArgumentException("Constructor: incorrect range");
		}
		day = d;
		month = m;
		year = y;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) throws IllegalArgumentException {
		if (day < 1 || day > 31) {
			throw new IllegalArgumentException("setDay: incorrect range");
		}
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) throws IllegalArgumentException {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("setMonth: incorrect range");
		}
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) throws IllegalArgumentException {
		if (year < 1900) {
			throw new IllegalArgumentException("setYear: incorrect range");
		}
		this.year = year;
	}
	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	public boolean equals(Object obj) {
		Date dObject;
		if (obj instanceof Date)
			dObject = (Date)obj;
		else
			return false;
		
		return (this.day == dObject.day 
				&& this.month == dObject.month
				&& this.year == dObject.year);
	}
}
