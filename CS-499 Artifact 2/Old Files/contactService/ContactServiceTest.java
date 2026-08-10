/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: These are the unit tests for Contact Service.
 */

package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class ContactServiceTest {

	private ContactService contactService;
	
	// Sets up object for contact service class, and adds a valid contact to list
	// ID should stay zero due to the function using AfterEach
	@BeforeEach
	void setup() {
		contactService = new ContactService();
		contactService.addContact("Stephen", "DaSilva", "0123456789", "123 Address Rd");
	}
	
	@AfterEach
	void resetID() {
		Contact.resetIDGenerator(); // Sets ID back to 0 for next test, handled like this because JUnit 5.0 does not have Order annotations
	}
	
	@Test
	@DisplayName("Contact adds successfully.")
	void testContactServiceAdd() { // Verifies that each variable was initialized correctly
		assertTrue(contactService.getContact("0").getFirstName() == "Stephen");
		assertTrue(contactService.getContact("0").getLastName() == "DaSilva");
		assertTrue(contactService.getContact("0").getPhoneNumber() == "0123456789");
		assertTrue(contactService.getContact("0").getAddress() == "123 Address Rd");
	}
	
	@Test
	@DisplayName("Multiple contacts add successfully.")
	void testContactServiceAddMultiple() { // Verifies that each variable was initialized correctly in multiple contacts
		contactService.addContact("Joe", "Smith", "9876543210", "345 Address Rd");
		contactService.addContact("John", "Doe", "2222222222", "567 Address Rd");
		assertTrue(contactService.getContact("0").getFirstName() == "Stephen");
		assertTrue(contactService.getContact("0").getLastName() == "DaSilva");
		assertTrue(contactService.getContact("0").getPhoneNumber() == "0123456789");
		assertTrue(contactService.getContact("0").getAddress() == "123 Address Rd");
		assertTrue(contactService.getContact("1").getFirstName() == "Joe");
		assertTrue(contactService.getContact("1").getLastName() == "Smith");
		assertTrue(contactService.getContact("1").getPhoneNumber() == "9876543210");
		assertTrue(contactService.getContact("1").getAddress() == "345 Address Rd");
		assertTrue(contactService.getContact("2").getFirstName() == "John");
		assertTrue(contactService.getContact("2").getLastName() == "Doe");
		assertTrue(contactService.getContact("2").getPhoneNumber() == "2222222222");
		assertTrue(contactService.getContact("2").getAddress() == "567 Address Rd");
	}
	
	@Test
	@DisplayName("Test to update first name.")
	void testContactServiceUpdateFirstName() { // Verifies that first name was changed
		contactService.updateContactFirstName("0", "Joe");
		//contactService.displayContactList();
		assertTrue(contactService.getContact("0").getFirstName() == "Joe");
	}
	
	@Test
	@DisplayName("Test to update last name.")
	void testContactServiceUpdateLastName() { // Verifies that last name was changed
		contactService.updateContactLastName("0", "Smith");
		//contactService.displayContactList();
		assertTrue(contactService.getContact("0").getLastName() == "Smith");
	}
	
	@Test
	@DisplayName("Test to update phone number.")
	void testContactServiceUpdatePhoneNumber() { // Verifies that phone number was changed
		contactService.updateContactPhoneNumber("0", "9998887776");
		//contactService.displayContactList();
		assertTrue(contactService.getContact("0").getPhoneNumber() == "9998887776");
	}
	
	@Test
	@DisplayName("Test to update address.")
	void testContactServiceUpdateAddress() { // Verifies that address was changed
		contactService.updateContactAddress("0", "987 New Street");
		//contactService.displayContactList();
		assertTrue(contactService.getContact("0").getAddress() == "987 New Street");
	}

	@Test
	@DisplayName("Test to delete contact.")
	void testContactServiceDelete() { // Verifies that contact is deleted
		contactService.deleteContact("0"); // Deletes contact
		if (contactService.getContact("0") != null) {
			fail("Contact was not deleted.");
		}
		//contactService.displayContactList();
	}
	
	

}
