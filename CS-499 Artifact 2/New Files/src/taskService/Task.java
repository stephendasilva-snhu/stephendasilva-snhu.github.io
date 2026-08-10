/* Author Name: Stephen DaSilva
 * Revised Task Entity
 * Description: This is the task class. It creates and stores task information.
 * Enhancements: Internal changes, uses proper error handling and more logical validation
 * Includes better documentation.
 */

package taskService;

import java.util.concurrent.atomic.AtomicLong;

public class Task {

    // Main attributes
    private final String taskID;
    private String name;
    private String description;

    // Atomic counter to generate ID
    private static final AtomicLong idGenerator = new AtomicLong();

    // Validation functions, all are meant to validate and/or fix inputs
	// based on the established criteria

    /**
     * Validates and normalizes a task name, restriction is up to 20 characters.
     *
     * @param name the input name
     * @return a trimmed and length‑restricted name
     * @throws IllegalArgumentException if null or empty
     */
    private static String validateName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Task name cannot be null");

        name = name.trim();
        if (name.isEmpty())
            throw new IllegalArgumentException("Task name cannot be empty");

        return name.length() > 20
                ? name.substring(0, 20)
                : name;
    }

    /**
     * Validates and normalizes a task description, restriction is up to 50 characters.
     *
     * @param description the input description
     * @return a trimmed and length‑restricted description
     * @throws IllegalArgumentException if null or empty
     */
    private static String validateDescription(String description) {
        if (description == null)
            throw new IllegalArgumentException("Task description cannot be null");

        description = description.trim();
        if (description.isEmpty())
            throw new IllegalArgumentException("Task description cannot be empty");

        return description.length() > 50
                ? description.substring(0, 50)
                : description;
    }

    /**
     * Creates a new Task with validated name and description.
     *
     * @param name the task name (max 20 characters)
     * @param description the task description (max 50 characters)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Task(String name, String description) {
        this.taskID = String.valueOf(idGenerator.getAndIncrement());
        this.name = validateName(name);
        this.description = validateDescription(description);
    }

    // Setter methods

    /**
     * Updates the task name after validation.
     *
     * @param newName the new task name
     * @throws IllegalArgumentException if invalid
     */
    public void setName(String newName) {
        this.name = validateName(newName);
    }

    /**
     * Updates the task description after validation.
     *
     * @param newDescription the new description
     * @throws IllegalArgumentException if invalid
     */
    public void setDescription(String newDescription) {
        this.description = validateDescription(newDescription);
    }

    // Getter methods

    /** @return the unique task ID */
    public String getTaskID() {
        return taskID;
    }

    /** @return the task name */
    public String getName() {
        return name;
    }

    /** @return the task description */
    public String getDescription() {
        return description;
    }

    // Internal resetter when needed
    public static void resetIDGenerator() {
        idGenerator.set(0);
    }
}
