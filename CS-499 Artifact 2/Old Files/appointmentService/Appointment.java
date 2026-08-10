/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: This is the appointment class. It creates and stores appointment information.
 */

package appointmentService;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;
import java.util.Calendar;

public class Appointment {
	
	private final String appointmentID;
	private Date appointmentDate;
	private String description;
	private Calendar calendar;
	private static AtomicLong idGenerator = new AtomicLong();
	
	// Methods for both object creation and setters
	// If a value is invalid, it gets fixed with a placeholder
	// or the first certain number of characters
	private Date fixDate(Date date) {
		if(date == null || date.before(new Date())){ // Checks if date is null or before current date
			calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, 9999);
			date = calendar.getTime(); // Changes year to 9999 as a placeholder
		}
		return date;
	}
	private String fixDescription(String description) {
		if(description == null) {
			description = "NULL";
		}
		else if (description.length() > 50) {
			description = description.substring(0, 50);
		}
		return description;
	}
	
	
	public Appointment(Date date, String description) {
		// Each value is fixed before being put into the object
		
		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
		this.appointmentDate = fixDate(date);
		this.description = fixDescription(description);
		
		if (appointmentID.length() > 10) { // If the ID is longer than 10 characters
			throw new IllegalArgumentException("ID too long");
		}
	}
	
	// Implemented set methods even though it is not used by the appointment service
	// Not stated that the date and description should not be updatable in general
	
	public void setAppointmentDate(Date newDate) {
		this.appointmentDate = fixDate(newDate);
	}
	
	public void setDescription(String newDescription) {
		this.description = fixDescription(newDescription);
	}
	
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	// Reset method for JUnit tests
	public static void resetIDGenerator() {
		idGenerator.set(0);
	}

}
