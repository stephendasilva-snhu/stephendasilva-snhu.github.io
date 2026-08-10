/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: This is the task class. It creates and stores task information.
 */

package taskService;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	
	private final String taskID;
	private String name;
	private String description;
	private static AtomicLong idGenerator = new AtomicLong();
	
	// Methods for both object creation and setters
	// If a value is invalid, it gets fixed with a placeholder
	// or the first certain number of characters
	private String fixName(String name) {
		if(name == null) {
			name = "NULL";
		}
		else if (name.length() > 20) {
			name = name.substring(0, 20);
		}
		
		return name;
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
	
	
	public Task(String name, String description) {
		// Each value is fixed before being put into the object
		
		this.taskID = String.valueOf(idGenerator.getAndIncrement());
		this.name = fixName(name);
		this.description = fixDescription(description);
		
		if (taskID.length() > 10) { // If the ID is longer than 10 characters
			throw new IllegalArgumentException("ID too long");
		}
	}
	
	public void setName(String newName) {
		this.name = fixName(newName);
	}
	
	public void setDescription(String newDescription) {
		this.description = fixDescription(newDescription);
	}
	
	public String getTaskID() {
		return this.taskID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	// Reset method for JUnit tests
	public static void resetIDGenerator() {
		idGenerator.set(0);
	}

}
