# Python Module to handle CRUD operations
# Created/edited by Stephen DaSilva

from pymongo import MongoClient 
from bson.objectid import ObjectId 

class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    def __init__(self, USER, PASS, HOST, PORT, DB, COL): 
        # Initializing the MongoClient. This helps to access the MongoDB 
        # databases and collections.
        # 
        # Default Connection Variables below. No longer hard-wired.
        # 
        # USER = aacuser
        # PASS = SNHU1234
        # HOST = 'localhost' 
        # PORT = 27017 
        # DB = 'aac' 
        # COL = 'animals' 
        # 
        # Initialize Connection 
        # 
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT)) 
        self.database = self.client['%s' % (DB)] 
        self.collection = self.database['%s' % (COL)]
            
    # Create method to implement the C in CRUD. 
    def create(self, data):
        if data is not None:
            result = self.collection.insert_one(data)  # data should be dictionary
            return result.acknowledged # returns boolean, true or false
        else: 
            raise Exception("Nothing to save, because data parameter is empty") 

    # Read method to implement the R in CRUD.
    def read(self, query):
        if query is not None:
            return list(self.collection.find(query)) # returns list, whether it is empty or not
        else:
            raise Exception("Nothing to read, because query parameter is empty")
            
    # Update method to implement the U in CRUD.
    def update(self, query, update_data):
        if query is not None and update_data is not None:
            result = self.collection.update_many(query, {"$set": update_data}) # finds desired documents using query, updates with update_data
            return result.modified_count # returns amount of documents modified
        else:
            raise Exception("Nothing to update, because query or update_data parameter is empty")

    # Delete method to implement the D in CRUD.
    def delete(self, query):
        if query is not None:
            result = self.collection.delete_many(query)
            return result.deleted_count  # returns number of documents deleted
        else:
            raise Exception("Nothing to delete, because query parameter is empty")