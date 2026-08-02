import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Adds monkey array list
    // Instance variables (if needed)
    private static Scanner scnr = new Scanner(System.in);
    
    private static String[] monkeySpecies = { "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin" }; // monkeySpecies array initialized to be used in input validation
    
    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();
        char userChar = 'a';  // Initializes userChar as 'a' for the incoming loop

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        
        
        while (userChar != 'q') { // Continues running while the user has not quit
        	displayMenu(); // Displays menu
        	userChar = scnr.next().charAt(0); // Obtains character input
        	scnr.nextLine(); // Prepares for next input
        	
        	switch (userChar) { // Switch statement used for possible inputs
        		case '1':
        			intakeNewDog(scnr);
        			break;
        		case '2':
        			intakeNewMonkey(scnr);
        			break;
        		case '3':
        			reserveAnimal(scnr);
        			break;
        		case '4':
        			printAnimals("dog");
        			break;
        		case '5':
        			printAnimals("monkey");
        			break;
        		case '6':
        			printAnimals("available");
        			break;
        		case 'q':
        			break;
        		default: // Triggers if no valid selection has been sent
        			System.out.println("You need to input a valid selection!");
        			break;
        	}
        }
        System.out.println("You have quit the menu, goodbye."); // Prints after quitting menu loop
        
        

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("George", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States", "1.2", "2.6", "1.5", "Guenon");
        Monkey monkey2 = new Monkey("Max", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States", "1.4", "3.5", "2.3", "Capuchin");
        Monkey monkey3 = new Monkey("Zoey", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada", "1.7", "3.8", "2.5", "Macaque");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Adds the code to instantiate a new dog and adds it to the appropriate list, each question is connected to a specific attribute
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the date of acquisition?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Where was the dog acquired?");
        String acquisitionCountry = scanner.nextLine();
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, "intake", false, acquisitionCountry); // Instantiates new dog, assumes acquisition country as service country
        dogList.add(newDog); // Adds to list
        System.out.println("The dog has been added to the system.");
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) { // Makes sure monkey doesn't exist
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            
            System.out.println("What is the monkey's species?");
            String species = scanner.nextLine();
            
            char validInput = 'n'; // Initializes variable to change if species if valid
            while (validInput != 'y') { // Loop to validate species input
	            for(String validSpecies: monkeySpecies) {
	            	if(validSpecies.equalsIgnoreCase(species)) { // If input species is a valid species
	            		validInput = 'y';
	            	}
	            }
	            if (validInput != 'y') {
		            System.out.println("Invalid species: What is the monkey's species?"); // If input species is invalid
		            species = scanner.nextLine();
	            }
            }
            // Asks remaining questions to gather information/attributes
            
            System.out.println("What is the monkey's gender?");
            String gender = scanner.nextLine();
            System.out.println("What is the monkey's age?");
            String age = scanner.nextLine();
            System.out.println("What is the monkey's weight?");
            String weight = scanner.nextLine();
            System.out.println("What is the monkey's tail length?");
            String tailLength = scanner.nextLine();
            System.out.println("What is the monkey's height?");
            String height = scanner.nextLine();
            System.out.println("What is the monkey's body length?");
            String bodyLength = scanner.nextLine();
            System.out.println("What is the date of acquisition?");
            String acquisitionDate = scanner.nextLine();
            System.out.println("Where was the monkey acquired?");
            String acquisitionCountry = scanner.nextLine();
            Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, "intake", false, acquisitionCountry, tailLength, height, bodyLength, species); // Instantiates new monkey
            monkeyList.add(newMonkey); // Adds new monkey to list
            System.out.println("The monkey has been added to the system.");
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("What type of animal are you trying to reserve?");
            String animalType = scanner.nextLine();
            System.out.println("Which country would you like to reserve the animal from?");
            String inServiceCountry = scanner.nextLine();
            while (true) {
	            if (animalType.equalsIgnoreCase("Dog")) { // Looks in dog list
	            	for (Dog dog : dogList) {
	            		if (dog.getInServiceLocation().equals(inServiceCountry)) { // Activates if service country is same as input
	            			if (!dog.getReserved() && dog.getTrainingStatus().equals("in service")) { // Checks if dog is not reserved and is in service
	            				System.out.println("You have reserved a dog in your requested country. Their name is: " + dog.getName());
	            				dog.setReserved(true);
	            				return;
	            			}
	            		}
	            	}
	            	System.out.println("There are no available dogs in your requested country.");
	            	return;
	            }
	            
	            else if (animalType.equalsIgnoreCase("Monkey")) { // Looks in monkey list
	            	for (Monkey monkey : monkeyList) {
		            	if (monkey.getInServiceLocation().equals(inServiceCountry)) { // Activates if service country is same as input
		            		if (!monkey.getReserved() && monkey.getTrainingStatus().equals("in service")) { // Checks if monkey is not reserved and is in service
		            			System.out.println("You have reserved a monkey in your requested country. Their name is: " + monkey.getName());
		            			monkey.setReserved(true);
		            			return;
		            		}
		            	}
		            }
		            System.out.println("There are no available monkeys in your requested country.");
		            return;
	            }
            
	            else { // If type is not monkey or dog
	            	System.out.println("Invalid type of animal, please input a valid type.");
	            	animalType = scanner.nextLine();
	            }
            }

        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listType) {
            if (listType.equals("available")) { // Detects "available" parameter
            	System.out.println("List of available animals:");
            	System.out.println("Available dogs:");
            	// Loop to print dog info
            	for (Dog dog : dogList) {
            		if (!dog.getReserved() && dog.getTrainingStatus().equals("in service")) { // Checks if dog is reserved and in service, prints all info if applicable
            			System.out.println("Dog Name: " + dog.getName() + ", Status: " + dog.getTrainingStatus()
            			+ ", Acquisition Country: " + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
            		}
            	}
            	System.out.println("Available monkeys:");
            	// Loop to print monkey info
            	for (Monkey monkey : monkeyList) {
            		if (!monkey.getReserved() && monkey.getTrainingStatus().equals("in service")) { // Checks if monkey is reserved and in service, prints all info if applicable
            			System.out.println("Monkey Name: " + monkey.getName() + ", Status: " + monkey.getTrainingStatus()
            			+ ", Acquisition Country: " + monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved());
            		}
            	}
            }
            else if (listType.equals("dog")) {
            	System.out.println("List of dogs:");
            	for (Dog dog : dogList) { // Prints all dogs
            		System.out.println("Dog Name: " + dog.getName() + ", Status: " + dog.getTrainingStatus()
        			+ ", Acquisition Country: " + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
            	}
            }
            else if (listType.equals("monkey")) {
            	System.out.println("List of monkeys:");
            	for (Monkey monkey : monkeyList) { // Prints all dogs
            		System.out.println("Monkey Name: " + monkey.getName() + ", Status: " + monkey.getTrainingStatus()
        			+ ", Acquisition Country: " + monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved());
            	}
            }

        }
}

