/* Author Name: Stephen DaSilva
 * Revised Apopointment Service
 * Description: This is the appointment service. It maintains a list of appointments and
 * can add or delete appointments based on ID
 * Enhancements: Changed to use HashMap algorithm, functions changed from that and made more concise
 */

package appointmentService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    // Appointments stored through HashMap, uses ID as key.
    private final Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Creates a new Appointment and stores it in the service.
     *
     * @param date the appointment date (must not be in the past)
     * @param description the appointment description
     * @throws IllegalArgumentException if any field is invalid
     */
    public void addAppointment(Date date, String description) {
        Appointment appointment = new Appointment(date, description);
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    /**
     * Deletes an appointment by ID.
     *
     * @param appointmentID the ID of the appointment to delete
     */
    public void deleteAppointment(String appointmentID) {
        appointments.remove(appointmentID);
    }

    /**
     * Retrieves an appointment by ID.
     *
     * @param appointmentID the ID of the appointment
     * @return the matching Appointment, or null if not found
     */
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }

    /**
     * Returns all stored appointments.
     *
     * @return a collection of all appointments in the HashMap
     */
    public Iterable<Appointment> getAllAppointments() {
        return appointments.values();
    }
}