/* Author Name: Stephen DaSilva
 * Revised Contact Service
 * Description: This is the contact service. It maintains a list of contacts and
 * can add or delete contacts, along with update first name, last name, phone number, and address for any contact based on ID
 * Enhancements: Changed to use HashMap algorithm, functions changed from that and made more concise
 */

package contactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Ccontacts stored through HashMap, uses ID as key.
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Creates a new Contact and stores it in the service.
     *
     * @param firstName the contact's first name
     * @param lastName the contact's last name
     * @param number the contact's phone number
     * @param address the contact's address
     * @throws IllegalArgumentException if any field is invalid
     */
    public void addContact(String firstName, String lastName, String number, String address) {
        Contact contact = new Contact(firstName, lastName, number, address);
        contacts.put(contact.getContactID(), contact);
    }

    /**
     * Deletes a contact by ID.
     *
     * @param contactID the ID of the contact to delete
     */
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    /**
     * Updates a specific field of a contact based on the input field.
     *
     * @param contactID the ID of the contact to update
     * @param field the field name ("firstname", "lastname", "phonenumber", "address")
     * @param newValue  the new value for the field
     * @throws IllegalArgumentException if the field name is unknown
     */
    public void updateContact(String contactID, String field, String newValue) {
        Contact contact = contacts.get(contactID);
        if (contact == null) return;

        switch (field.toLowerCase()) { // Switch case based on the chosen field
            case "firstname" -> contact.setFirstName(newValue);
            case "lastname" -> contact.setLastName(newValue);
            case "phonenumber" -> contact.setPhoneNumber(newValue);
            case "address" -> contact.setAddress(newValue);
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        }
    }

    /**
     * Retrieves a contact by ID.
     *
     * @param contactID the ID of the contact
     * @return the matching Contact or null if not found
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    /**
     * Returns all stored contacts.
     *
     * @return a collection of all contacts in the HashMap
     */
    public Iterable<Contact> getAllContacts() {
        return contacts.values();
    }
}