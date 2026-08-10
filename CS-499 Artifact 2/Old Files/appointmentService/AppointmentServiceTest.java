/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: These are the unit tests for Appointment Service.
 */

package appointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.Date;
import java.util.Calendar;

class AppointmentServiceTest {

	private AppointmentService appointmentService;
	private Calendar calendar;
	private Date newDate;
	
	// Sets up object for appointment service class, and adds a valid appointment to list
	// ID should stay zero due to the function using AfterEach
	@BeforeEach
	void setup() {
		appointmentService = new AppointmentService();
		calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2026); // Sets date to 2026 so it is in the future
		newDate = calendar.getTime();
		appointmentService.addAppointment(newDate, "Meet and do something");
	}
	
	@AfterEach
	void resetID() {
		Appointment.resetIDGenerator(); // Sets ID back to 0 for next test, handled like this because JUnit 5.0 does not have Order annotations
	}
	
	@Test
	@DisplayName("Appointment adds successfully.")
	void testAppointmentServiceAdd() { // Verifies that each variable was set correctly
		assertTrue(appointmentService.getAppointment("0").getAppointmentDate() == newDate);
		assertTrue(appointmentService.getAppointment("0").getDescription() == "Meet and do something");
	}
	
	@Test
	@DisplayName("Multiple appointments add successfully.")
	void testAppointmentServiceAddMultiple() { // Verifies that multiple appointments are added correctly
		assertTrue(appointmentService.getAppointment("0").getAppointmentDate() == newDate);
		assertTrue(appointmentService.getAppointment("0").getDescription() == "Meet and do something");
		calendar.set(2026, 5, 24);
		newDate = calendar.getTime();
		appointmentService.addAppointment(newDate, "Finish program together");
		assertTrue(appointmentService.getAppointment("1").getAppointmentDate() == newDate);
		assertTrue(appointmentService.getAppointment("1").getDescription() == "Finish program together");
		calendar.set(2026, 8, 29);
		newDate = calendar.getTime();
		appointmentService.addAppointment(newDate, "Meet with someone else");
		assertTrue(appointmentService.getAppointment("2").getAppointmentDate() == newDate);
		assertTrue(appointmentService.getAppointment("2").getDescription() == "Meet with someone else");
	}

	@Test
	@DisplayName("Test to delete appointment.")
	void testAppointmentServiceDelete() { // Verifies that appointment is deleted
		appointmentService.deleteAppointment("0"); // Deletes appointment
		if (appointmentService.getAppointment("0") != null) {
			fail("Appointment was not deleted.");
		}
		//appointmentService.displayAppointmentList();
	}
	
	

}
