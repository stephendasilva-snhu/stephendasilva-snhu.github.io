/* Author Name: Stephen DaSilva
 * Revised Contact Entity
 * Description: This is the contact class. It creates and stores contact information.
 * Enhancements: Internal changes, uses proper error handling and more logical validation.
 * Includes better documentation.
 */

package contactService;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {

	// Main attributes
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

	// Atomic counter to generate IDs
    private static final AtomicLong idGenerator = new AtomicLong();

    // Validation functions, all are meant to validate and/or fix inputs
	// based on the established criteria

	/**
     * Validates and normalizes a first name, restriction is up to 10 letters.
     *
     * @param firstName the input first name
     * @return a trimmed and length‑restricted first name
     * @throws IllegalArgumentException if null or empty
     */
    private static String validateFirstName(String firstName) {
        if (firstName == null)
            throw new IllegalArgumentException("First name cannot be null");

        firstName = firstName.trim();
        if (firstName.isEmpty())
            throw new IllegalArgumentException("First name cannot be empty");

        return firstName.length() > 10 ? firstName.substring(0, 10): firstName;
    }

	/**
     * Validates and normalizes a last name, restriction is up to 10 letters.
     *
     * @param lastName the input last name
     * @return a trimmed and length‑restricted last name
     * @throws IllegalArgumentException if null or empty
     */
    private static String validateLastName(String lastName) {
        if (lastName == null)
            throw new IllegalArgumentException("Last name cannot be null");

        lastName = lastName.trim();
        if (lastName.isEmpty())
            throw new IllegalArgumentException("Last name cannot be empty");

        return lastName.length() > 10 ? lastName.substring(0, 10): lastName;
    }

	/**
     * Validates a phone number, restriction is must be exactly 10 digits.
     *
     * @param phoneNumber the input phone number
     * @return the validated phone number
     * @throws IllegalArgumentException if null or not exactly 10 digits
     */
    private static String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null)
            throw new IllegalArgumentException("Phone number cannot be null");

        phoneNumber = phoneNumber.trim();
        if (!phoneNumber.matches("\\d{10}"))
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");

        return phoneNumber;
    }

	/**
     * Validates and normalizes an address, restriction is up to 30 characters.
     *
     * @param address the input address
     * @return a trimmed and length‑restricted address
     * @throws IllegalArgumentException if null or empty
     */
    private static String validateAddress(String address) {
        if (address == null)
            throw new IllegalArgumentException("Address cannot be null");

        address = address.trim();
        if (address.isEmpty())
            throw new IllegalArgumentException("Address cannot be empty");

        return address.length() > 30
                ? address.substring(0, 30)
                : address;
    }

    /**
     * Creates a new Contact with validated fields and a unique ID.
     *
     * @param firstName the first name (max 10 characters)
     * @param lastName the last name (max 10 characters)
     * @param phoneNumber the phone number (10 digits)
     * @param address the address (max 30 characters)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = String.valueOf(idGenerator.getAndIncrement());
        this.firstName = validateFirstName(firstName);
        this.lastName = validateLastName(lastName);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.address = validateAddress(address);
    }

    /**
     * Updates the first name after validation.
     *
     * @param newFirstName the new first name
     * @throws IllegalArgumentException if invalid
     */
    public void setFirstName(String newFirstName) {
        this.firstName = validateFirstName(newFirstName);
    }

    /**
     * Updates the last name after validation.
     *
     * @param newLastName the new last name
     * @throws IllegalArgumentException if invalid
     */
    public void setLastName(String newLastName) {
        this.lastName = validateLastName(newLastName);
    }

    /**
     * Updates the phone number after validation.
     *
     * @param newPhoneNumber the new phone number
     * @throws IllegalArgumentException if invalid
     */
    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = validatePhoneNumber(newPhoneNumber);
    }

    /**
     * Updates the address after validation.
     *
     * @param newAddress the new address
     * @throws IllegalArgumentException if invalid
     */
    public void setAddress(String newAddress) {
        this.address = validateAddress(newAddress);
    }

    // Getter methods

    /** @return the unique contact ID */
    public String getContactID() {
        return contactID;
    }

    /** @return the first name */
    public String getFirstName() {
        return firstName;
    }

    /** @return the last name */
    public String getLastName() {
        return lastName;
    }

    /** @return the phone number */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /** @return the address */
    public String getAddress() {
        return address;
    }

    // Internal resetter when needed
    public static void resetIDGenerator() {
        idGenerator.set(0);
    }
}
