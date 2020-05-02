package ABproject;

/*
* Author: Mohammed Allibalogun
 * Class: Advanced Software Design
 * Class Name: MainProject2.java
 * Course: 656-9040
 * Date: 10/14/2015
 * Description: Make a simple address book application.  It should be able to store Name, 
 * Street, City, State, ZIP and phone number.  You can make any type of interface you would 
 * like to, however a simple text interface is probably the easiest. 
 *  
 * The main features to to:
 * �Add an contact to the address book
 * �Delete a contact from the address book
 * �Update a contact from the address book
 * �Display the address book
 * 
 * AspectJ features: Create an aspect that when the user updates a contact the previous data is written to a file. 
 * Also create an aspect that when the user deletes a contact the contact information is written to a file.
 *  
 * */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

	public class MainProject {
		
		static AddressBook addressBook = new AddressBook();

		static Address address = new Address();
		
		public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		String exit = "X";
		int selectNumber;
		String selectText;


		//this method will add
		presentAddress();



		System.out.println("Welcome to the address book");
		System.out.println("Press X to enter. Press O to exit");
		selectText = scanner.next();



		while(exit.equalsIgnoreCase(selectText)){

			try {
				System.out.println("Press 1 to display address book. Press 2 to delete record. Press 3 to update record. Press 4 to add record.");
			selectNumber = scanner.nextInt();
			addressBook.addressBookLogic(selectNumber);

			} catch (InputMismatchException ie) {
					System.out.println("You didn't select the above option.");
					ie.getStackTrace();
				}
			System.out.println("\n");
			System.out.println("Press X to Continue. Press O to exit");
			selectText = scanner.next();
			}

		System.out.println("You've exit The Address Book Application");

		}

		
		public static AddressBook presentAddress(){
			
			addressBook.addAddressRecord("Lucas Smith", "1239 Northern Ave", "Portsmouth","VA",
					60613, "513-321-2231");
			addressBook.addAddressRecord("James Brown", "4603 Savanna St.", "Washington","D.C.",
					60613, "712-391-7328");
			addressBook.addAddressRecord("Abdul Kassem", "620 John Paul Jones Cirle", "Tampa","FL",
					60613, "910-983-9123");
			addressBook.addAddressRecord("Fatai Akida", "15th Street", "Owings Mill","MD",
					21117, "144-555-8291");
			addressBook.addAddressRecord("Santana Hus", "8901 Wisconsin Ave", "Bethesda","MD",
					20814, "871-123-5921");
			addressBook.addAddressRecord("Michael Wade", "3111 Plaza", "Chicago","IL",
					60613, "821-839-1231");
			
			return addressBook;
		}
	}
