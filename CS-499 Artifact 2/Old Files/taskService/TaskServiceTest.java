/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: These are the unit tests for Task Service.
 */

package taskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class TaskServiceTest {

	private TaskService taskService;
	
	// Sets up object for task service class, and adds a valid task to list
	// ID should stay zero due to the function using AfterEach
	@BeforeEach
	void setup() {
		taskService = new TaskService();
		taskService.addTask("Write Program", "Write the task service program");
	}
	
	@AfterEach
	void objectRemoval() {
		Task.resetIDGenerator(); // Sets ID back to 0 for next test, handled like this because JUnit 5.0 does not have Order annotations
	}
	
	@Test
	@DisplayName("Task adds successfully.")
	void testTaskServiceAdd() { // Verifies that each variable was initialized correctly
		assertTrue(taskService.getTask("0").getName() == "Write Program");
		assertTrue(taskService.getTask("0").getDescription() == "Write the task service program");
	}
	
	@Test
	@DisplayName("Multiple tasks add successfully.")
	void testTaskServiceAddMultiple() { // Adds multiple tasks and verifies they are added correctly.
		taskService.addTask("Delete Program", "Delete the task service program");
		taskService.addTask("Update Program", "Update the task service program");
		assertTrue(taskService.getTask("0").getName() == "Write Program");
		assertTrue(taskService.getTask("0").getDescription() == "Write the task service program");
		assertTrue(taskService.getTask("1").getName() == "Delete Program");
		assertTrue(taskService.getTask("1").getDescription() == "Delete the task service program");
		assertTrue(taskService.getTask("2").getName() == "Update Program");
		assertTrue(taskService.getTask("2").getDescription() == "Update the task service program");
	}
	
	// No test for duplicate ID as that is handled by the ID generator
	
	@Test
	@DisplayName("Test to update name.")
	void testTaskServiceUpdateName() { // Verifies that name was changed
		taskService.updateTaskName("0", "Delete Program");
		//taskService.displayTaskList();
		assertTrue(taskService.getTask("0").getName() == "Delete Program");
	}
	
	@Test
	@DisplayName("Test to update description.")
	void testTaskServiceUpdateDescription() { // Verifies that description was changed
		taskService.updateTaskDescription("0", "Write a different program");
		//taskService.displayTaskList();
		assertTrue(taskService.getTask("0").getDescription() == "Write a different program");
	}

	@Test
	@DisplayName("Test to delete task.")
	void testTaskServiceDelete() { // Verifies that task is deleted
		taskService.deleteTask("0"); // Deletes task
		if (taskService.getTask("0") != null) {
			fail("Task was not deleted.");
		}
		//taskService.displayTaskList();
	}
	
	

}
