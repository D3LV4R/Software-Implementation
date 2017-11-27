package ie.lyit.Testers;

import ie.lyit.Hotel.Date;
import java.util.Scanner;

public class DateTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		Date date1 = new Date(12, 5, 2017);
		Date date2 = new Date(12, 5, 2017);
		
		System.out.println(date1);
		
		if (date1.equals(date2))
			System.out.println(date1 + " is the same as " + date2);
		else 
			System.out.println(date1 + " is not the same as " + date2);
		
		date2.setDay(27);
		
		if (date1.equals(date2))
			System.out.println(date1 + " is the same as " + date2);
		else
			System.out.println(date1 + " is not the same as " + date2);
		
		Date myDate1 = new Date();
		Date myDate2 = new Date(28,11,1982);
		
		boolean goodInput = false;
		int day = 32;
		int month = 13;
		int year = -2009;
		
		do {
			try {
				myDate1.setDay(day);
				myDate1.setMonth(month);
				myDate1.setYear(year);
				//Date date3 = new Date(62, 5, 2017);
				goodInput = true;
			} 
			catch (IllegalArgumentException iAE) {
				System.out.println("Exception : " + iAE.toString());
				
				System.out.println("new day");
				day = keyboard.nextInt();
				System.out.println("new month");
				month = keyboard.nextInt();
				System.out.println("new year");
				year = keyboard.nextInt();
			}
		} while (!goodInput);
		
		try {
			Date date3 = new Date(62, 5, 2017);
		} 
		catch (IllegalArgumentException iAE) {
			System.out.println("Exception : " + iAE.toString());
		}

		
	}

}
