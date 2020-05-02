package ABproject;

/* Author: Mohammed Allibalogun
* Class: Advanced Software Design
* Class Name: Address.java
* Course: 656-9040
* Date: 10/14/2015
* 
* Description: The Address class is the object that will be stored in the Address
* book. Whenever a user wants to add a new record to the AddressBook class,
* they will initiliaze this class and add store the values to create an address record 
* 
* */
public class Address {

	private String Name;
	private String Street;
	private String City;
	private String State;
	private int ZipCode;
	private String phoneNumber;
		
	public Address() {
		
	}
	
	
	public Address(String Name, String Street, String City, String State, int ZipCode, String phoneNumber) {
		this.Name = Name;
		this.Street = Street;
		this.City = City;
		this.State = State;
		this.ZipCode = ZipCode;
		this.phoneNumber = phoneNumber;		
	}
	
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getStreet() {
		return Street;
	}


	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public int getZipCode() {
		return ZipCode;
	}


	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		
		return 	getName()+ "       "+getStreet()
				+" "+getCity()
				+", "+getState()
				+" "+getZipCode()
				+" "+getPhoneNumber();
	}
	
	
	
}

