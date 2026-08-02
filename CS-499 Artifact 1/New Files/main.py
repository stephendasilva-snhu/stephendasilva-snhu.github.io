###
# Grazioso Salvare Emotional Support Animal Terminal
# Command-line app for intaking, reserving, training, and listing support animals
# Made by Stephen DaSilva
# Enhancements: Ported into Python while also taking the opportunity to implement modularized code, make the program more efficient,
# create an ID system, add additional functions, and add a cat animal type as a test for its adaptability
# Also recontextualized program as an Emotional Support Animal program and implemented better documentation
###
# Using docstrings to describe functions

import SupportAnimal
from dateutil import parser
from datetime import date
import pycountry

# Each species gets its own dictionary to make it more organized and efficient, the ID is used as the key
dogs = {}
monkeys = {}
cats = {}

# Central dictionary used to simplify iteration
animals_list = {"dog": dogs, "monkey": monkeys, "cat": cats}

# Species or breeds that are acceptable, based on original project guidelines
# presumed to be focused on popularity or compatibility with program
ALLOWED_MONKEY_SPECIES = {"capuchin","guenon","macaque","marmoset","squirrel monkey","tamarin"}
ALLOWED_CAT_SPECIES = {"domestic shorthair","shorthair","american shorthair","domestic longhair","siamese","maine coon","ragdoll","russian blue","bombay"}
ALLOWED_DOG_SPECIES = {"french bulldog","bulldog","golden retriever","german shepherd","dachshund","labrador retriever","poodle","beagle","rottweiler"}

next_id = 1 # Used as global counter for generation to maintain consistency
def generate_id() -> str:
    """Generates a unique ID, increasing the global next_id value for uniqueness.

    Returns:
        str: The generated ID value as a string.
    """
    global next_id
    id_value = next_id
    next_id += 1
    return str(id_value)

# ---- Handles input validation for more complicated data types ----
def get_country(user_input: str) -> str:
    """Obtains country name (standard code, such as US) with fuzzy-searching.

    Args:
        user_input (str): Country name or abbreviation.

    Returns:
        str: Standard 2-letter country code.

    Raises:
        LookupError: If the country cannot be resolved.
    """
    matches = pycountry.countries.search_fuzzy(user_input) # Enables minor errors or typos
    
    return matches[0].alpha_2 # If not found, the error is handled by the caller

def get_date(user_input: str) -> date:
    """Parse a user-provided date, meant to give the correct date output.

    Args:
        user_input (str): The inputted date.

    Returns:
        datetime.date: Determined date object.

    Raises:
        ValueError: If the date cannot be parsed.
        ParserError: If the input format is invalid.
    """
    return parser.parse(user_input).date() # An invalid input is handled by the caller

# ---- Menu functionality ----
def display_menu(header: str, option_list: dict):
    """Displays out a menu with an inputted header and list of selectable options.

    Args:
        header (str): Title displayed at the top of the menu.
        option_list (dict): Mapping of option keys (such as 1, 2, q) to a pair of the option and its function.
    """
    print(30 * '*')
    print(header)
    for num, (option, _) in option_list.items(): # Loops over to print full menu
        print(f"[{num}] {option}")
    print("\nPlease enter a menu selection: ")
    
def run_menu(header: str, options: dict):
    """Runs a menu loop, separated since multiple of the same type of menu is used.
    Assumes q is the key to quit, will exit function.
    Handles basic input validation.

    Args:
        header (str): Title displayed at the top of the menu.
        options (dict): Mapping of option keys (such as 1, 2, q) to a pair of the option and its function.
    """
    while True:
        display_menu(header, options)
        choice = input().strip().lower() # Case insensitive input if needed

        if choice == 'q': # Assumes "quit"
            break

        if choice in options:
            _, function = options[choice]
            if function: # Mitigates error
                function()
        else:
            print("Invalid selection.")

# ---- Main program functions ----
def find_animal():
    """Finds and displays an animal's information based on the input ID.
    Made so all details can be printed regardless of animal species.
    """
    animal_id = input("Enter animal ID: ").strip()

    for species, species_dict in animals_list.items():
        if animal_id in species_dict:
            animal = species_dict[animal_id]

            print("\nAnimal found:\n")
            print(f"{species.capitalize()} (ID {animal.id})")

            # Automatically print all attributes
            for field, value in vars(animal).items():
                if field == "id":
                    continue  # already printed above

                # Makes print more readable to the average user
                label = field.replace("_", " ").title()
                print(f"  {label}: {value}")

            print()
            return

    print("Animal not found.")
    
def validate_species(species: str, allowlist: set) -> str:
    """Validate species input based on list.

    Args:
        species (str): Raw species input from the user.
        allowlist (set): The list of acceptable species.

    Returns:
        str: Fixed input if correct.

    Raises:
        ValueError: If the species is not one of the allowed species.
    """
    species = species.strip().lower()

    if species not in allowlist:
        raise ValueError(
            f"Invalid species or breed: '{species}'."
        )

    return species.title()


def intake_animal(animal_type: str):
    """Does the intake process for all animals, inputting universal details and species-specific details.
    Attempted input validation through a try/except block, with the separate get_date and get_country methods used
    to raise errors if needed.
    Args:
        animal_type (str): Type of animal going through intake ("cat", "dog", "monkey")
    """
    print(f"Intaking a new {animal_type}...")
    
    animal = None # Keeps animal from not being bound

    try: # Tries to resolve all user inputs, if there is a type error, will throw error
        name = input("Name: ").strip()
        id = generate_id()
        gender = input("Gender: ").strip()
        age = int(input("Age: ").strip())
        weight = float(input("Weight (lb): ").strip())
        acquisition_date = get_date(input("Date acquired: ").strip())
        acquisition_country = get_country(input("Country acquired from: ").strip()) # Newly intaked animals assumed to be in their acquisition country
        training_status = "intake"
        reserved = False
        in_service_country = acquisition_country

        if animal_type == "dog":
            breed = validate_species(input("Breed: ").strip(), ALLOWED_DOG_SPECIES)
            animal = SupportAnimal.Dog(
                name, id, gender, age, weight,
                acquisition_date, acquisition_country,
                training_status, reserved, in_service_country,
                breed
            )

        elif animal_type == "monkey":
            tail_length = float(input("Tail length (cm): ").strip())
            height = float(input("Height (cm): ").strip())
            body_length = float(input("Body length (cm): ").strip())
            species = validate_species(input("Species: ").strip(), ALLOWED_MONKEY_SPECIES)

            animal = SupportAnimal.Monkey(
                name, id, gender, age, weight,
                acquisition_date, acquisition_country,
                training_status, reserved, in_service_country,
                tail_length, height, body_length, species
            )

        elif animal_type == "cat":
            breed = validate_species(input("Breed: ").strip(), ALLOWED_CAT_SPECIES)
            animal = SupportAnimal.Cat(
                name, id, gender, age, weight,
                acquisition_date, acquisition_country,
                training_status, reserved, in_service_country,
                breed
            )
            
    except ValueError as e:
        print(e)   # Prints error for invalid species
        return
    
    except Exception: # Used for any other error in the intake process.
        print("Invalid input detected. Returning to menu.")
        return

    animals_list[animal_type][id] = animal
    print(f"{animal_type.capitalize()} added.")

def reserve_animal(animal_type: str):
    """Attempt to reserve an animal from a user-chosen country.
    Only animals that are fully trained ('in service') and not already reserved are eligible.
    Will pick the first animal possible, should work for any future species.

    Args:
        animal_type (str): Species to reserve ("cat", "dog", "monkey").
    """
    print(f"Reserving a {animal_type}...")

    in_service_country = get_country(input("Which country would you like to reserve the animal from? "))

    species_dict = animals_list[animal_type]

    for animal in species_dict.values():
        if (animal.in_service_country == in_service_country and
            not animal.reserved and animal.training_status.lower() == "in service"):
            # If in: correct country, not already reserved, fully trained/"in service"
            print(f"You have reserved a {animal_type}. Their name is: {animal.name}")
            animal.reserved = True
            return

    print(f"There are no available {animal_type}s in {in_service_country}.")

# ---- Training process for animals ----

TRAINING_STAGES = ["intake", "phase i", "phase ii", "phase iii", "in service"]

def train_animal():
    """Moves animal to next training stage, has a specific order from "intake" (when initially added) to "in service".
    Only animals that are "in service" can be reserved later.
    """
    animal_id = input("Enter animal ID: ")

    # Find the animal in any species dictionary
    for type_dict in animals_list.values():
        animal = type_dict.get(animal_id)
        if animal:
            current = animal.training_status.lower()
            index = TRAINING_STAGES.index(current)

            # Already at final stage
            if index == len(TRAINING_STAGES) - 1:
                print(f"{animal.name} is already fully trained (in service).")
                return

            # Advance to next stage
            new_status = TRAINING_STAGES[index + 1]
            animal.training_status = new_status

            print(f"{animal.name} has advanced to: {new_status}")
            return

    print("Animal not found.")
    
# ---- Printing animal details ----
def print_individual(animal: SupportAnimal.SupportAnimal, animal_type: str):
    """Prints a short summary of animal details, used for lists.

    Args:
        animal (SupportAnimal): The animal instance.
        animal_type (str): Type of animal ("cat", "dog", "monkey")
    """
    print(f"{animal_type.capitalize()} Name: {animal.name}, "
          f"ID: {animal.id}, "
          f"Status: {animal.training_status}, "
          f"Acquisition Country: {animal.acquisition_country}, "
          f"Reserved: {animal.reserved}")

def print_animal(list_type):
    """Print animals based on list type:
    - "all" prints every animal
    - "reserved" prints only reserved animals
    - can also print a specific animal type
    Made to adapt to future types of animals

    Args:
        list_type (str): Type of list requested.
    """
    print(f"\n*** {list_type.upper()} ***")

    # Print all animals
    if list_type == "all":
        found = False # Tracks if any animal is present
        for species, species_dict in animals_list.items():
            for animal in species_dict.values():
                found = True
                print_individual(animal, species)
                
        if not found:
            print("No animals in list, use the intake function.")
        return

    # Print reserved animals
    if list_type == "reserved":
        found = False # Tracks if any reserved animals are present
        for species, species_dict in animals_list.items():
            for animal in species_dict.values():
                if animal.reserved:
                    print_individual(animal, species)
                    found = True
        if not found:
            print("No reserved animals found.")
        return

    # Print animals by type (dog, monkey, cat)
    species_dict = animals_list.get(list_type)
    if not species_dict:
        print("No animals found.")
        return
    
    for animal in species_dict.values():
        print_individual(animal, list_type)

    return

# ---- Options for each menu ----
# Uses lambda so functions can be sent back with the arguments

INTAKE_OPTIONS = { # Used for intake animal menu
    "1": ("Intake monkey", lambda: intake_animal("monkey")),
    "2": ("Intake dog", lambda: intake_animal("dog")),
    "3": ("Intake cat", lambda: intake_animal("cat")),
    "q": ("Go back", None)
}

RESERVE_OPTIONS = { # Used for reserve animal menu, will ask which type of animal to reserve
    "1": ("Monkey", lambda: reserve_animal("monkey")),
    "2": ("Dog", lambda: reserve_animal("dog")),
    "3": ("Cat", lambda: reserve_animal("cat")),
    "q": ("Go back", None)
}

PRINT_OPTIONS = { # Used for print animal menu
    "1": ("Print list of all animals", lambda: print_animal("all")),
    "2": ("Print list of monkeys", lambda: print_animal("monkey")),
    "3": ("Print list of dogs", lambda: print_animal("dog")),
    "4": ("Print list of cats", lambda: print_animal("cat")),
    "5": ("Print list of reserved animals", lambda: print_animal("reserved")),
    "q": ("Go back", None)
}

MENU_OPTIONS = { # Used for main menu
    "1": ("Intake a new animal", lambda: run_menu("Intake Animal Menu", INTAKE_OPTIONS)),
    "2": ("Reserve an animal by species", lambda: run_menu("What type of animal are you trying to reserve?", RESERVE_OPTIONS)),
    "3": ("Train an animal from ID", lambda: train_animal()),
    "4": ("Print an animal list", lambda: run_menu("Print Animal Menu", PRINT_OPTIONS)),
    "5": ("Find a specific animal from ID", lambda: find_animal()),
    "q": ("Quit application", None)
}
    
def main():
    """Starting point for program, just has main menu run and prints "Goodbye" when exiting.
    """
    header = "Grazioso Salvare Support Animal Terminal"
    run_menu(header, MENU_OPTIONS)
    
    print("Goodbye")
    return 0

if __name__ == "__main__":
    main()