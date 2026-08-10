/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: This is the appointment service. It maintains a list of appointments and
 * can add or delete appointments based on ID
 */

package appointmentService;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {

	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	//Displays full list of appointments to console for error checking.
	/*
	public void displayAppointmentList() {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			System.out.println("\t Appointment ID: " + appointmentList.get(counter).getAppointmentID());
			System.out.println("\t Date: " + appointmentList.get(counter).getAppointmentDate());
			System.out.println("\t Description: " + appointmentList.get(counter).getDescription());
		}
	}
	*/
	
	// Adds new appointment and then adds to list
	public void addAppointment(Date date, String description) {
		Appointment appointment = new Appointment(date, description);
		appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentID.equals(appointmentList.get(counter).getAppointmentID())) {
				appointmentList.remove(counter);
			}
		}
	}
	
	//No update methods as it is not included in requirements
	
	public Appointment getAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentID.equals(appointmentList.get(counter).getAppointmentID())) {
				return appointmentList.get(counter);
			}
		}
		return null; // Returns null if the id doesn't match with a appointment
	}

}
