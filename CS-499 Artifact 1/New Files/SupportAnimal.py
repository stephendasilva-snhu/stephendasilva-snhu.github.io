###
# Emotional Support Animal Classes
# Made for the Grazioso Salvare Terminal
# By Stephen DaSilva
# Enhancements: Ported to Python, added an ID attribute and added a Cat class
###

class SupportAnimal:
    """Parent class for support animals. Features all shared attributes.
    
    Attributes:
    name: Animal's name.
    id: Unique identifier assigned at intake.
    gender: Animal's gender.
    age: Animal's age in years.
    weight: Animal's weight in pounds.
    acquisition_date: Date the animal was acquired.
    acquisition_country: Country code for where the animal was acquired.
    training_status: Current training stage ("intake", "phase i", etc.).
    reserved: Whether the animal has been reserved.
    in_service_country: Country where the animal is currently in service.
    """
    def __init__(self,
                name=None, id=None,
                gender=None, age=None, weight=None,
                acquisition_date=None, acquisition_country=None,
                training_status="intake", reserved=False,
                in_service_country=None):
        self.name = name
        self.id = id
        self.gender = gender
        self.age = age
        self.weight = weight
        self.acquisition_date = acquisition_date
        self.acquisition_country = acquisition_country
        self.training_status = training_status
        self.reserved = reserved
        self.in_service_country = in_service_country


class Dog(SupportAnimal):
    """Dog child class.
    
    Attributes:
    breed: Dog's breed.
    """
    def __init__(self, name=None, id=None,
                gender=None, age=None, weight=None,
                acquisition_date=None, acquisition_country=None,
                training_status="intake", reserved=False,
                in_service_country=None, breed=None):
        super().__init__(name, id, gender, age, weight, acquisition_date, acquisition_country, training_status, reserved, in_service_country)
        self.breed = breed

class Monkey(SupportAnimal):
    """Monkey child class.
    
    Attributes:
    tail_length: Tail length in centimeters.
    height: Height in centimeters.
    body_length: Body length in centimeters.
    species: Monkey species (Capuchin, Guenon, etc.).
    """
    def __init__(self, name=None, id=None,
                gender=None, age=None, weight=None,
                acquisition_date=None, acquisition_country=None,
                training_status="intake", reserved=False,
                in_service_country=None, tail_length=None,
                height=None, body_length=None, species=None
                ):
        super().__init__(name, id, gender, age, weight, acquisition_date, acquisition_country, training_status, reserved, in_service_country)
        self.tail_length = tail_length
        self.height = height
        self.body_length = body_length
        self.species=species

class Cat(SupportAnimal):
    """Cat child class.    
    
    Attributes:
    breed: Cat's breed.
    """
    def __init__(self, name=None, id=None,
                gender=None, age=None, weight=None,
                acquisition_date=None, acquisition_country=None,
                training_status="intake", reserved=False,
                in_service_country=None,
                breed=None
                ):
        super().__init__(name, id, gender, age, weight, acquisition_date, acquisition_country, training_status, reserved, in_service_country)
        self.breed = breed