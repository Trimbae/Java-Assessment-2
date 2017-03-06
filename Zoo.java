/*
 * Name: Matthew Trimby
 * Student number: c1525379
 */


import java.util.*;

public class Zoo {

	private int capacity; //defines an integer to store zoo capacity
    private Vector<Animal> animals; //defines a vector for storing animals

    public Zoo() {
		animals = new Vector<Animal>(); //initialises new animal vector
        this.capacity = -1; //sets capacity to -1 to indicate capacity is infinite
    }

    public Zoo( int inCapacity ) {
		if(inCapacity < 1){
            throw new IllegalArgumentException("Invalid capacity entered."); //throws exception for invalid zoo capacity
        }
        animals = new Vector<Animal>(inCapacity); //initialises new animal vector
        this.capacity = inCapacity; //sets capacity to capacity entered by user

    }
    
    public void addAnimal(Animal inAnimal){
        if(this.capacity == -1 || this.capacity >= inAnimal.getAvailableAnimals() + numberAvailableAnimals()){
            animals.add(inAnimal); //adds new animal if capacity is infinite OR there is room for the number of animals being added
        }
        else{
            throw new IllegalStateException("Zoo at maximum capacity"); //throws exception if number of animals added would go over zoos capacity
        }

    }
    public boolean hasAnimalWithName(String animalName){
        for(int i = 0; i < animals.size(); i++){ //iterates through the animals in the vector
            if(animalName.toLowerCase().equals(animals.get(i).getName().toLowerCase())){
                return true; /*compares lower case versions of name entered by user and name stored in the Animal class,
                              if the names match, returns true*/
            }
        }
        return false; //if no match is found, returns false
    }
    public Animal getAnimalWithName(String animalName){
        for(int i = 0; i < animals.size(); i++){ //iterates through the animals in the vector
            if(animalName.toLowerCase().equals(animals.get(i).getName().toLowerCase())){
                return animals.get(i); //compares names in lower case, if a match is found the Animal is returned
            }
        }
        return null; //if no match is found, returns null
    }
    public int numberAvailableAnimals(){
        int total = 0; //initialises a variable to count total number of animals
        for(int i = 0; i < animals.size(); i++){
            Animal animal = animals.get(i);
            total+= animal.getAvailableAnimals(); //iterates through vector adding the 'available animals' of each animal instance to the total
        }
        return total; //returns the total number of available animals
    }
}


