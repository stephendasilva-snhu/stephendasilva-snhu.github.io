/* Author Name: Stephen DaSilva
 * Revised Task Service
 * Description: This is the task service. It maintains a list of tasks and
 * can add or delete tasks, along with updating name and description based on ID
 * Enhancements: Changed to use HashMap algorithm, functions changed from that and made more concise
 */

package taskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    // Tasks stored through HashMap, uses ID as key.
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Creates a new Task and stores it in the service.
     *
     * @param name the task name
     * @param description the task description
     * @throws IllegalArgumentException if any field is invalid
     */
    public void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.put(task.getTaskID(), task);
    }

    /**
     * Deletes a task by ID.
     *
     * @param taskID the ID of the task to delete
     */
    public void deleteTask(String taskID) {
        tasks.remove(taskID);
    }

    /**
     * Updates a specific field of a task based on the input field.
     *
     * @param taskID   the ID of the task to update
     * @param field    the field name ("name", "description")
     * @param newValue the new value for the field or null if not found
     * @throws IllegalArgumentException if the field name is unknown
     */
    public void updateTask(String taskID, String field, String newValue) {
        Task task = tasks.get(taskID);
        if (task == null)
            return;

        switch (field.toLowerCase()) { // Switch case based on the chosen field
            case "name" -> task.setName(newValue);
            case "description" -> task.setDescription(newValue);
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        }
    }

    /**
     * Retrieves a task by ID.
     *
     * @param taskID the ID of the task
     * @return the matching Task, or null if not found
     */
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }

    /**
     * Returns all stored tasks.
     *
     * @return a collection of all tasks in the HashMap
     */
    public Iterable<Task> getAllTasks() {
        return tasks.values();
    }
}