/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: These are the unit tests for Appointment class.
 */

package appointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import java.util.Calendar;
import java.util.Date;

class AppointmentTest {

	// First test checks that the appointment is made correctly when everything is typed as expected.
	// Other tests check if the variable is correctly changed when it is too long, NULL, or before current date.
	
	// Sets up a calendar before each test so it can be manipulated and used as the date
	private Calendar calendar;
	@BeforeEach
	void calendarSet() {
		calendar = Calendar.getInstance();
	}
	
	@Test
	@DisplayName("Appointment should be created correctly.")
	void testAppointment() {
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2026 so it is in the future
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, "Meet to do something");
		assertTrue(appointment.getAppointmentDate().equals(newDate));
		assertTrue(appointment.getDescription().equals("Meet to do something"));
	}
	
	@Test
	@DisplayName("Appointment ID cannot have more than 10 characters.")
	void testAppointmentIDWithMoreThanTenCharacters() {
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2026 so it is in the future
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, "Meet to do something");
		if (appointment.getAppointmentID().length() > 10) {
			fail("Appointment ID has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Appointment Description cannot have more than 50 characters.")
	void testAppointmentDescriptionWithMoreThanFiftyCharacters() {
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2026 so it is in the future
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, "Meet to do something and type a lot of characters, way too many for these requirements");
		if (appointment.getDescription().length() > 50) {
			fail("Appointment Description has more than 50 characters.");
		}
	}
	
	@Test
	@DisplayName("Appointment Date cannot be in the past.")
	void testAppointmentDateInPast() {
		calendar.set(Calendar.YEAR, 2024); // Sets date to 2024 so it is in the past
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, "Meet to do something");
		calendar.set(Calendar.YEAR, 9999);
		newDate = calendar.getTime();
		if (appointment.getAppointmentDate().before(new Date())) {
			fail("Appointment Date is in the past.");
		}
	}
	
	@Test
	@DisplayName("Appointment Description cannot be null.")
	void testAppointmentDescriptionWithNull() {
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2024 so it is in the past
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, null);
		if (appointment.getDescription() == null) {
			fail("Appointment Description is null.");
		}
	}
	
	@Test
	@DisplayName("Appointment Date cannot be null.")
	void testAppointmentDateWithNull() {
		Date newDate = null;
		Appointment appointment = new Appointment(newDate, "Meet to do something");
		if (appointment.getAppointmentDate() == null) {
			fail("Appointment Date is null.");
		}
	}
	
	@Test
	@DisplayName("Appointment set date should work correctly.")
	void testAppointmentSetDate() {
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2026 so it is in the future
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, "Meet to do something");
		calendar.set(Calendar.YEAR,  2027);
		Date newerDate = calendar.getTime();
		appointment.setAppointmentDate(newerDate);
		assertTrue(appointment.getAppointmentDate().equals(newerDate));
	}
	
	@Test
	@DisplayName("Appointment set description should work correctly.")
	void testAppointmentSetDescription() {
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2026 so it is in the future
		Date newDate = calendar.getTime();
		Appointment appointment = new Appointment(newDate, "Meet to do something");
		appointment.setDescription("Meet to do something else");
		assertTrue(appointment.getDescription().equals("Meet to do something else"));
	}
	
}