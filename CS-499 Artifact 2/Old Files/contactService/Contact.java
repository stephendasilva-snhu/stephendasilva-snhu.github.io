/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: This is the contact class. It creates and stores contact information.
 */

package contactService;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private static AtomicLong idGenerator = new AtomicLong();
	
	// Methods for both object creation and setters
	// If a value is invalid, it gets fixed with a placeholder
	// or the first certain number of characters
	private String fixFirstName(String firstName) {
		if(firstName == null) {
			firstName = "NULL";
		}
		else if (firstName.length() > 10) {
			firstName = firstName.substring(0, 10);
		}
		return firstName;
	}
	private String fixLastName(String lastName) {
		if(lastName == null) {
			lastName = "NULL";
		}
		else if (lastName.length() > 10) {
			lastName = lastName.substring(0, 10);
		}
		return lastName;
	}
	private String fixPhoneNumber(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() != 10) {
			phoneNumber = "0000000000";
		}
		return phoneNumber;
	}
	private String fixAddress(String address) {
		if(address == null) {
			address = "NULL";
		}
		else if (address.length() > 30) {
			address = address.substring(0, 30);
		}
		return address;
	}
	
	
	public Contact(String firstName, String lastName, String phoneNumber, String address) {
		// Each value is fixed before being put into the object
		
		this.contactID = String.valueOf(idGenerator.getAndIncrement());
		this.firstName = fixFirstName(firstName);
		this.lastName = fixLastName(lastName);
		this.phoneNumber = fixPhoneNumber(phoneNumber);
		this.address = fixAddress(address);
		
		if (contactID.length() > 10) { // If the ID is longer than 10 characters
			throw new IllegalArgumentException("ID too long");
		}
	}
	
	public void setFirstName(String newFirstName) {
		this.firstName = fixFirstName(newFirstName);
	}
	
	public void setLastName(String newLastName) {
		this.lastName = fixLastName(newLastName);
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = fixPhoneNumber(newPhoneNumber);
	}
	
	public void setAddress(String newAddress) {
		this.address = fixAddress(newAddress);
	}
	
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	// Reset method for JUnit tests
	public static void resetIDGenerator() {
		idGenerator.set(0);
	}

}
