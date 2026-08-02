
public class Monkey extends RescueAnimal {
	
	// Monkey-specific attributes, types set to String to be in line with other data types in RescueAnimal
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;

	// Constructor
	public Monkey(String name, String gender, String age,
		    String weight, String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry,
			String tailLength, String height, String bodyLength, String species) {
		        setName(name);
		        setGender(gender);
		        setAge(age);
		        setWeight(weight);
		        setAcquisitionDate(acquisitionDate);
		        setAcquisitionLocation(acquisitionCountry);
		        setTrainingStatus(trainingStatus);
		        setReserved(reserved);
		        setInServiceCountry(inServiceCountry);
		        setTailLength(tailLength);
		        setHeight(height);
		        setBodyLength(bodyLength);
		        setSpecies(species);
	}
	
	// Accessor Method
    public String getTailLength() {
        return tailLength; // Returns current tail length
    }

    // Mutator Method
    public void setTailLength(String monkeyTailLength) {
        tailLength = monkeyTailLength; // Sets tail length to user input
    }
    
 // Accessor Method
    public String getHeight() {
        return height; // Returns current height
    }

    // Mutator Method
    public void setHeight (String monkeyHeight) {
        height = monkeyHeight; // Sets height to user input
    }
    
 // Accessor Method
    public String getBodyLength() {
        return bodyLength; // Returns current body length
    }

    // Mutator Method
    public void setBodyLength(String monkeyBodyLength) {
        bodyLength = monkeyBodyLength; // Sets body length to user input
    }
    
 // Accessor Method
    public String getSpecies() {
        return species; // Returns current species
    }

    // Mutator Method
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies; // Set species to user input
    }

}
