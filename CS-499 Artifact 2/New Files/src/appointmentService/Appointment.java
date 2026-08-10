/* Author Name: Stephen DaSilva
 * Revised Apopointment Entity
 * Description: This is the appointment class. It creates and stores appointment information.
 * Enhancements: Internal changes, uses proper error handling and more logical validation
 * Includes better documentation.
 */

package appointmentService;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {

    // Main attributes
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    // Atomic counter to generate ID
    private static final AtomicLong idGenerator = new AtomicLong();

    // Validation functions, all are meant to validate and/or fix inputs
	// based on the established criteria

    /**
     * Validates an appointment date, restriction is must not be in the past.
     *
     * @param date the date to validate
     * @return the validated date
     * @throws IllegalArgumentException if null or in the past
     */
    private static Date validateDate(Date date) {
        if (date == null)
            throw new IllegalArgumentException("Appointment date cannot be null");

        Date now = new Date();
        if (date.before(now))
            throw new IllegalArgumentException("Appointment date cannot be in the past");

        return date;
    }

    /**
     * Validates and normalizes an appointment description, restriction is maximum 50 characters.
     *
     * @param description the input description
     * @return a trimmed and length‑restricted description
     * @throws IllegalArgumentException if null or empty
     */
    private static String validateDescription(String description) {
        if (description == null)
            throw new IllegalArgumentException("Description cannot be null");

        description = description.trim();
        if (description.isEmpty())
            throw new IllegalArgumentException("Description cannot be empty");

        return description.length() > 50
                ? description.substring(0, 50)
                : description;
    }

    /**
     * Creates a new Appointment with a validated date and description.
     *
     * @param date the appointment date (must not be in the past)
     * @param description the appointment description (max 50 characters)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Appointment(Date date, String description) {
        this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
        this.appointmentDate = validateDate(date);
        this.description = validateDescription(description);
    }

    // Setter methods

    /**
     * Updates the appointment date after validation.
     *
     * @param newDate the new appointment date
     * @throws IllegalArgumentException if invalid
     */
    public void setAppointmentDate(Date newDate) {
        this.appointmentDate = validateDate(newDate);
    }

    /**
     * Updates the appointment description after validation.
     *
     * @param newDescription the new description
     * @throws IllegalArgumentException if invalid
     */
    public void setDescription(String newDescription) {
        this.description = validateDescription(newDescription);
    }

    // Getter methods

    /** @return the unique appointment ID */
    public String getAppointmentID() {
        return appointmentID;
    }

    /** @return the appointment date */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /** @return the appointment description */
    public String getDescription() {
        return description;
    }

    // Internal resetter when needed
    public static void resetIDGenerator() {
        idGenerator.set(0);
    }
}
