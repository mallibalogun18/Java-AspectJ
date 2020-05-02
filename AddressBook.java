package ABproject;

/*
* Author: Mohammed Allibalogun
* Class: Advanced Software Design
* Class Name: AddressBook.java
* Course: 656-9040
* Date: 10/14/2015
* Description: this is a class that will store the logical feutures that
* makes an address book: 
* 
* •Add an contact to the address book
* •Delete a contact from the address book
* •Update a contact from the address book
* •Display the address book 
* 
* */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class AddressBook {

	ArrayList<Address> addresses = new ArrayList<Address>();
	private Scanner input;
	private Scanner input2;

	//Add new record to the address book
	public void addAddressRecord(String name, String street, String city, 
			String state, int zipCode, String phoneNumber){
		
		Address address = new Address(name, street, 
				city, state, zipCode, phoneNumber);
		addresses.add(address);
		
	}

	
	//AddressBook logic method
	public void addressBookLogic(int inputNumber) throws IOException{		
		input = new Scanner(System.in);
		
		switch (inputNumber) {
		case 1:
			displayAddressBook();
			break;
		case 2: 
			System.out.println("Enter name to be deleted");
			String deleteRecord = input.nextLine();
			deleteAddress(deleteRecord);
			break;
		case 3:
			System.out.println("Enter name to be updated");
			String updateRecord = input.nextLine();
			updateAddress(updateRecord);
			break;
		case 4:
			System.out.println("Enter name:");
			String name = input.nextLine();
			System.out.println("Enter stree:");
			String street = input.nextLine();
			System.out.println("Enter city: ");
			String city = input.nextLine();
			System.out.println("Enter state: ");
			String state = input.nextLine();
			System.out.println("Enter zip code: ");
			int zipCode = input.nextInt();
			System.out.println("Enter phone number: ");
			String phoneNumber = input.nextLine();
			addAddressRecord(name, street, city, state, zipCode, phoneNumber);	
			break;
		default:
			break;
		}
		
	}
	
	
	//Method that deletes contact from the address book
	public Address deleteAddress(String name) throws IOException{
		
		Address deletedRecord = new Address();
		
		int oldNum = addresses.size();
		for (int i = 0; i < addresses.size(); i++) {
			if(addresses.get(i).getName().equalsIgnoreCase(name)){
				deletedRecord = addresses.get(i);
				addresses.remove(i);
				File file = new File("deleteRecord.txt");
				FileWriter fileWriter = new FileWriter(file, true);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				printWriter.println("Record Deleted: "+deletedRecord);
				printWriter.close();
				break;
			}
		}
		
		if(oldNum == addresses.size()){
			System.out.println("The name you've entered in not in the address book!");
			System.out.println("No deletion were made!");
		}		
		return deletedRecord;	
	}
	
	
	//update method contacts from the address book
	public Address updateAddress(String name) throws IOException{
		
		Address updatedRecord = new Address();

		input2 = new Scanner(System.in);
		
		for (int i = 0; i < addresses.size(); i++) {
			if ( addresses.get(i).getName().equalsIgnoreCase(name)) {
				updatedRecord = addresses.get(i);
				
				File file = new File("updatedAddress.txt");
				FileWriter fileWriter = new FileWriter(file, true);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				printWriter.println("Record Updated: "+updatedRecord);
				printWriter.close();
				
				System.out.println("Enter 1 to update name, 2 for street,"
						+ " 3 for city, 4 for state, 5 for zip code, 5 for phone number!");
				int selection = input2.nextInt();
				
				switch (selection) {
				case 1:
					System.out.println("Enter name:");
					input2.nextLine();
					String updateName2 = input2.nextLine();
					addresses.get(i).setName(updateName2);
					break;
				case 2:
					System.out.println("Enter street:");
					input2.nextLine();
					String updateStreet = input2.nextLine();
					addresses.get(i).setStreet(updateStreet);
					break;
				case 3:
					System.out.println("Enter city:");
					input2.nextLine();
					String updateCity = input2.nextLine();
					addresses.get(i).setCity(updateCity);
					break;
				case 4:
					System.out.println("Enter state:");
					input2.nextLine();
					String updateState = input2.nextLine();
					addresses.get(i).setState(updateState);
					break;
				case 5:
					System.out.println("Enter zip code:");
					input2.nextInt();
					int updateZipCode = input2.nextInt();
					addresses.get(i).setZipCode(updateZipCode);
					break;
				case 6:
					System.out.println("Enter phone number:");
					input2.nextLine();
					String updatePhoneNum = input2.nextLine();
					addresses.get(i).setPhoneNumber(updatePhoneNum);
					break;
				default:
					break;
				}				
			}
		}
		
		if(updatedRecord.getName() == null){
			System.out.println("The name you've entered is not in the Address Book.");
		}
		return updatedRecord;
	}
	
	public void helloWorld(){
		System.out.println("Hello World");
	}
	
	//return all the address on the address Book
	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	
	//Method Display Address Book
	public void displayAddressBook(){	
		for (int i = 0; i < addresses.size(); i++) {
			System.out.println(addresses.get(i));
		}
	}
	

}
