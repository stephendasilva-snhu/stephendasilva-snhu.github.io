/* Author Name: Stephen DaSilva
 * Date: 8-10-2025
 * Course ID: CS 320
 * Description: This is the task service. It maintains a list of tasks and
 * can add or delete tasks, along with updating name and description based on ID
 */

package taskService;

import java.util.ArrayList;

public class TaskService {

	ArrayList<Task> taskList = new ArrayList<Task>();
	
	//Displays full list of tasks to console for error checking. Commented when not needed.
	/*
	public void displayTaskList() {
		for (int counter = 0; counter < taskList.size(); counter++) {
			System.out.println("\t Task ID: " + taskList.get(counter).getTaskID());
			System.out.println("\t Name: " + taskList.get(counter).getName());
			System.out.println("\t Description: " + taskList.get(counter).getDescription());
		}
	}
	*/
	
	// Adds new task and then adds to list
	public void addTask(String name, String description) {
		Task task = new Task(name, description);
		taskList.add(task);
	}
	
	public void deleteTask(String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskID.equals(taskList.get(counter).getTaskID())) {
				taskList.remove(counter);
			}
		}
	}
	
	public void updateTaskName(String taskID, String newName) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskID.equals(taskList.get(counter).getTaskID())) {
				taskList.get(counter).setName(newName);
			}
		}
	}
	
	public void updateTaskDescription(String taskID, String newDescription) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskID.equals(taskList.get(counter).getTaskID())) {
				taskList.get(counter).setDescription(newDescription);
			}
		}
	}
	
	public Task getTask(String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskID.equals(taskList.get(counter).getTaskID())) {
				return taskList.get(counter);
			}
		}
		return null; // Returns null if the id doesn't match with a task
	}

}
