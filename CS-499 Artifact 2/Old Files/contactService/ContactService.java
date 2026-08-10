/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: This is the contact service. It maintains a list of contacts and
 * can add or delete contacts, along with update first name, last name, phone number, and address for any contact based on ID
 */

package contactService;

import java.util.ArrayList;

public class ContactService {

	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	//Displays full list of contacts to console for error checking.
	/*
	public void displayContactList() {
		for (int counter = 0; counter < contactList.size(); counter++) {
			System.out.println("\t Contact ID: " + contactList.get(counter).getContactID());
			System.out.println("\t First Name: " + contactList.get(counter).getFirstName());
			System.out.println("\t Last Name: " + contactList.get(counter).getLastName());
			System.out.println("\t Phone Number: " + contactList.get(counter).getPhoneNumber());
			System.out.println("\t Address: " + contactList.get(counter).getAddress());
		}
	}
	*/
	
	// Adds new contact and then adds to list
	public void addContact(String firstName, String lastName, String number, String address) {
		Contact contact = new Contact(firstName, lastName, number, address);
		contactList.add(contact);
	}
	
	public void deleteContact(String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactID.equals(contactList.get(counter).getContactID())) {
				contactList.remove(counter);
			}
		}
	}
	
	public void updateContactFirstName(String contactID, String newFirstName) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactID.equals(contactList.get(counter).getContactID())) {
				contactList.get(counter).setFirstName(newFirstName);
			}
		}
	}
	
	public void updateContactLastName(String contactID, String newLastName) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactID.equals(contactList.get(counter).getContactID())) {
				contactList.get(counter).setLastName(newLastName);
			}
		}
	}
	
	public void updateContactPhoneNumber(String contactID, String newPhoneNumber) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactID.equals(contactList.get(counter).getContactID())) {
				contactList.get(counter).setPhoneNumber(newPhoneNumber);
			}
		}
	}
	
	public void updateContactAddress(String contactID, String newAddress) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactID.equals(contactList.get(counter).getContactID())) {
				contactList.get(counter).setAddress(newAddress);
			}
		}
	}
	
	public Contact getContact(String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactID.equals(contactList.get(counter).getContactID())) {
				return contactList.get(counter);
			}
		}
		return null; // Returns null if the id doesn't match with a contact
	}



}
