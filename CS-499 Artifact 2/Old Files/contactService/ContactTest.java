/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: These are the unit tests for Contact class.
 */

package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

	// First test checks that the contact is made correctly when everything is typed as expected.
	// Other tests check if the variable is correctly changed when it is too long, short, or NULL. 
	@Test
	@DisplayName("Contact should be created correctly.")
	void testContact() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd");
		assertTrue(contact.getFirstName().equals("Stephen"));
		assertTrue(contact.getLastName().equals("DaSilva"));
		assertTrue(contact.getPhoneNumber().equals("0987654321"));
		assertTrue(contact.getAddress().equals("123 Address Rd"));
	}
	
	@Test
	@DisplayName("Contact ID cannot have more than 10 characters.")
	void testContactIDWithMoreThanTenCharacters() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd");
		if (contact.getContactID().length() > 10) {
			fail("Contact ID has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters.")
	void testContactFirstNameWithMoreThanTenCharacters() {
		Contact contact = new Contact("Stephendddd", "DaSilva", "0987654321", "123 Address Rd");
		if (contact.getFirstName().length() > 10) {
			fail("Contact First Name has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters.")
	void testContactLastNameWithMoreThanTenCharacters() {
		Contact contact = new Contact("Stephen", "DaSilvaaaaaaa", "0987654321", "123 Address Rd");
		if (contact.getLastName().length() > 10) {
			fail("Contact Last Name has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact Phone Number cannot have more than, or less than 10 characters.")
	void testContactPhoneNumberWithMoreThanTenCharacters() {
		Contact contact = new Contact("Stephen", "DaSilva", "09876543210", "123 Address Rd");
		if (contact.getPhoneNumber().length() != 10) {
			fail("Contact Phone Number does not have 10 characters.");
		}
		Contact contact2 = new Contact("Stephen", "DaSilva", "098765432", "123 Address Rd");
		if (contact2.getPhoneNumber().length() != 10) {
			fail("Contact Phone Number does not have 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact Address cannot have more than 30 characters.")
	void testContactAddressWithMoreThanTenCharacters() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd 101 Very Long Address Street");
		if (contact.getAddress().length() > 30) {
			fail("Contact Address has more than 30 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact First Name cannot be null.")
	void testContactFirstNameWithNull() {
		Contact contact = new Contact(null, "DaSilva", "0987654321", "123 Address Rd");
		if (contact.getFirstName() == null) {
			fail("Contact First Name is null.");
		}
	}
	
	@Test
	@DisplayName("Contact Last Name cannot be null.")
	void testContactLastNameWithNull() {
		Contact contact = new Contact("Stephen", null, "0987654321", "123 Address Rd");
		if (contact.getLastName() == null) {
			fail("Contact Last Name is null.");
		}
	}
	
	@Test
	@DisplayName("Contact Phone Number cannot be null.")
	void testContactPhoneNumberWithNull() {
		Contact contact = new Contact("Stephen", "DaSilva", null, "123 Address Rd");
		if (contact.getPhoneNumber() == null) {
			fail("Contact Phone Number is null.");
		}
	}
	
	@Test
	@DisplayName("Contact Address cannot be null.")
	void testContactAddressWithNull() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", null);
		if (contact.getAddress() == null) {
			fail("Contact Address is null.");
		}
	}
	
	@Test
	@DisplayName("Contact set first name function should behave correctly.")
	void testContactSetFirstName() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd");
		contact.setFirstName("Joe");
		assertTrue(contact.getFirstName().equals("Joe"));
	}
	
	@Test
	@DisplayName("Contact set last name function should behave correctly.")
	void testContactSetLastName() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd");
		contact.setLastName("Smith");
		assertTrue(contact.getLastName().equals("Smith"));
	}
	
	@Test
	@DisplayName("Contact set phone number function should behave correctly.")
	void testContactSetPhoneNumber() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd");
		contact.setPhoneNumber("1212121212");
		assertTrue(contact.getPhoneNumber().equals("1212121212"));
	}
	
	@Test
	@DisplayName("Contact set address function should behave correctly.")
	void testContactSetAddress() {
		Contact contact = new Contact("Stephen", "DaSilva", "0987654321", "123 Address Rd");
		contact.setAddress("321 New Street");
		assertTrue(contact.getAddress().equals("321 New Street"));
	}

}
