/* Author Name: Stephen DaSilva
 * Driver Program
 * Description: This is the driver program, it is meant to be a basic program
 * that lets you interface with each service to do its different functions.
 * It is meant to be simple code, as this is not the focus of the enhancement.
 * Shows the time spent for each action to show the benefit of the HashMap algorithm.
 */

package driver;

import appointmentService.AppointmentService;
import contactService.ContactService;
import java.util.Date;
import java.util.Scanner;
import taskService.TaskService;

public class Driver {

    private static final Scanner scanner = new Scanner(System.in);

    // Services to manage entities
    private static final ContactService contactService = new ContactService();
    private static final AppointmentService appointmentService = new AppointmentService();
    private static final TaskService taskService = new TaskService();

    /**
     * Prompts the user for input and returns the trimmed result.
     *
     * @param message the message displayed to the user
     * @return the trimmed user input
     */
    private static String prompt(String message) { // Meant to make inputs easier to deal with
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    /**
     * Calculates and prints the execution time of some action.
     *
     * @param label what the action is
     * @param action the action to time
     */
    private static void runTimer(String label, Runnable action) {
        long start = System.nanoTime(); // Starts timer
        try { // Runs the inputted function(s)
            action.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        // Calculates final time in ms
        long end = System.nanoTime();
        long ns = end - start;
        double ms = ns / 1000000.0;

        System.out.printf("%s completed in %.4f ms%n", label, ms);
    }

    // Menus to be displayed, could be simplified in the future
    /**
     * Displays and handles the Contact Service menu.
     */
    private static void contactMenu() {
        boolean running = true;

        while(running) {
            System.out.println("\n*** CONTACT MENU ***");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Get Contact");
            System.out.println("5. List All Contacts");
            System.out.println("6. Back");

            String choice = prompt("Select option: ");

            switch (choice) {

                case "1" -> { // Add Contact
                    String first = prompt("First name: ");
                    String last = prompt("Last name: ");
                    String phone = prompt("Phone number: ");
                    String address = prompt("Address: ");

                    runTimer("Add Contact", () -> {
                        contactService.addContact(first, last, phone, address);
                    });
                }

                case "2" -> { // Update Contact
                    String id = prompt("Contact ID: ");
                    String field = prompt("Field: ");
                    String value = prompt("New value: ");

                    runTimer("Update Contact", () -> {
                        contactService.updateContact(id, field, value);
                    });
                }

                case "3" -> { // Delete Contact
                    String id = prompt("Contact ID: ");

                    runTimer("Delete Contact", () -> {
                        contactService.deleteContact(id);
                    });
                }

                case "4" -> { // Get Contact by ID
                    String id = prompt("Contact ID: ");

                    runTimer("Get Contact", () -> {
                        var contact = contactService.getContact(id);
                        if (contact == null) System.out.println("Contact not found.");
                        else {
                            System.out.println("ID: " + contact.getContactID());
                            System.out.println("First: " + contact.getFirstName());
                            System.out.println("Last: " + contact.getLastName());
                            System.out.println("Phone: " + contact.getPhoneNumber());
                            System.out.println("Address: " + contact.getAddress());
                        }
                    });
                }

                case "5" -> runTimer("List Contacts", () -> { // List All Contacts
                    for (var contact : contactService.getAllContacts()) {
                        System.out.println(contact.getContactID() + " | " +
                            contact.getFirstName() + " " + contact.getLastName() + " | " +
                            contact.getPhoneNumber() + " | " +
                            contact.getAddress()
                        );
                    }
                });

                case "6" -> running = false; // Exits loop
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Displays and handles the Appointment Service menu.
     */
    private static void appointmentMenu() {
        boolean running = true;

        while(running) {
            System.out.println("\n*** APPOINTMENT MENU ***");
            System.out.println("1. Add Appointment");
            System.out.println("2. Delete Appointment");
            System.out.println("3. Get Appointment");
            System.out.println("4. List Appointments");
            System.out.println("5. Back");

            String choice = prompt("Select option: ");

            switch (choice) {

                case "1" -> { // Add Appointment
                    String desc = prompt("Description: ");
                    String[] dateNums = prompt("Date (yyyy-mm-dd): ").split("-");
                    try {
                        Date date = new Date(
                                Integer.parseInt(dateNums[0]) - 1900,
                                Integer.parseInt(dateNums[1]) - 1,
                                Integer.parseInt(dateNums[2])
                        );

                        runTimer("Add Appointment", () -> {
                        appointmentService.addAppointment(date, desc);
                    });
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Invalid Input");
                    }
                }

                case "2" -> { // Delete Appointment
                    String id = prompt("Appointment ID: ");

                    runTimer("Delete Appointment", () -> {
                        appointmentService.deleteAppointment(id);
                    });
                }

                case "3" -> { // Get Appointment by ID
                    String id = prompt("Appointment ID: ");

                    runTimer("Get Appointment", () -> {
                        var a = appointmentService.getAppointment(id);
                        if (a == null) System.out.println("Appointment not found.");
                        else {
                            System.out.println("ID: " + a.getAppointmentID());
                            System.out.println("Date: " + a.getAppointmentDate());
                            System.out.println("Description: " + a.getDescription());
                        }
                    });
                }

                case "4" -> runTimer("List Appointments", () -> { // List All Appointments
                    for (var appointment : appointmentService.getAllAppointments()) {
                        System.out.println(appointment.getAppointmentID() + " | " +
                            appointment.getAppointmentDate() + " | " +
                            appointment.getDescription()
                        );
                    }
                });

                case "5" -> running = false; // Exits loop
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Displays and handles the Task Service menu.
     */
    private static void taskMenu() {
        boolean running = true;

        while(running) {
            System.out.println("\n*** TASK MENU ***");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Get Task");
            System.out.println("5. List Tasks");
            System.out.println("6. Back");

            String choice = prompt("Select option: ");

            switch (choice) {

                case "1" -> { // Add Task
                    String name = prompt("Name: ");
                    String desc = prompt("Description: ");

                    runTimer("Add Task", () -> {
                        taskService.addTask(name, desc);
                    });
                }

                case "2" -> { // Update Task
                    String id = prompt("Task ID: ");
                    String field = prompt("Field: ");
                    String value = prompt("New value: ");

                    runTimer("Update Task", () -> {
                        taskService.updateTask(id, field, value);
                    });
                }

                case "3" -> { // Delete Task
                    String id = prompt("Task ID: ");

                    runTimer("Delete Task", () -> {
                        taskService.deleteTask(id);
                    });
                }

                case "4" -> { // Get Task by ID
                    String id = prompt("Task ID: ");

                    runTimer("Get Task", () -> {
                        var task = taskService.getTask(id);
                        if (task == null) System.out.println("Task not found.");
                        else {
                            System.out.println("ID: " + task.getTaskID());
                            System.out.println("Name: " + task.getName());
                            System.out.println("Description: " + task.getDescription());
                        }
                    });
                }

                case "5" -> runTimer("List Tasks", () -> { // List All Tasks
                    for (var task : taskService.getAllTasks()) {
                        System.out.println(task.getTaskID() + " | " +
                            task.getName() + " | " +
                            task.getDescription()
                        );
                    }
                });

                case "6" -> running = false; // Exits loop
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Displays and handles the main menu.
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n*** MAIN MENU ***");
            System.out.println("1. Contact Service");
            System.out.println("2. Appointment Service");
            System.out.println("3. Task Service");
            System.out.println("4. Exit");

            String choice = prompt("Select option: ");

            switch (choice) {
                case "1" -> contactMenu();
                case "2" -> appointmentMenu();
                case "3" -> taskMenu();
                case "4" -> running = false; // Exits loop and program
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Program terminated.");
    }
}