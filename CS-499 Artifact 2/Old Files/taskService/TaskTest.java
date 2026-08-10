/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: These are the unit tests for Task class.
 */

package taskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

	// First test checks that the task is made correctly when everything is typed as expected.
	// Other tests check if the variable is correctly changed when it is too long, short, or NULL. 
	@Test
	@DisplayName("Task should be created correctly.")
	void testTask() {
		Task task = new Task("Write Program", "Write the task service program");
		assertTrue(task.getName().equals("Write Program"));
		assertTrue(task.getDescription().equals("Write the task service program"));
	}
	
	@Test
	@DisplayName("Task ID cannot have more than 10 characters.")
	void testTaskIDWithMoreThanTenCharacters() {
		Task task = new Task("Write Program", "Write the task service program");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Task Name cannot have more than 20 characters.")
	void testTaskNameWithMoreThanTwentyCharacters() {
		Task task = new Task("Write Program and Type A Lot of Characters", "Write the task service program");
		if (task.getName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}
	
	@Test
	@DisplayName("Task Description cannot have more than 50 characters.")
	void testTaskDescriptionWithMoreThanFiftyCharacters() {
		Task task = new Task("Write Program", "Write the task service program and type a lot of characters to test program");
		if (task.getDescription().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}
	
	@Test
	@DisplayName("Task Name cannot be null.")
	void testTaskNameWithNull() {
		Task task = new Task(null, "Write the task service program");
		if (task.getName() == null) {
			fail("Task Name is null.");
		}
	}
	
	@Test
	@DisplayName("Task Description cannot be null.")
	void testTaskDescriptionWithNull() {
		Task task = new Task("Write Program", null);
		if (task.getDescription() == null) {
			fail("Task Description is null.");
		}
	}
	
	@Test
	@DisplayName("Task set name function should work correctly.")
	void testTaskSetName() {
		Task task = new Task("Write Program", "Write the task service program");
		task.setName("Delete Program");
		assertTrue(task.getName().equals("Delete Program"));
	}
	
	@Test
	@DisplayName("Task set description function should work correctly.")
	void testTaskSetDescription() {
		Task task = new Task("Write Program", "Write the task service program");
		task.setDescription("Delete the task service program");
		assertTrue(task.getDescription().equals("Delete the task service program"));
	}
}
