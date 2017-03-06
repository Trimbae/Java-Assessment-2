/*
 * Name: Matthew Trimby
 * Student number: c1525379
 */


public class Animal {

	private String animalName; //defines string to store animals name

	private int totalAnimals; //defines integer to store total number of animals
	private int totalLoanAnimals; //defines integer to store number of animals on loan

	public Animal( String inName, int inTotalNumAnimals ) {
		if(inTotalNumAnimals < 1){
			throw new IllegalArgumentException("Invalid number of animals."); //throws exception if number of animals is less than 1
		}
		this.animalName = inName; //stores animal name argument entered by user
		this.totalAnimals = inTotalNumAnimals; //stores number of animals entered by user
	}

	public String getName() {
		return animalName;
	}

	public int getTotalAnimals() {
		return totalAnimals;
	}

	public int getAvailableAnimals() {
		return totalAnimals - totalLoanAnimals; //subtracts number of loan animals from total number to get the number of available animals
	}

	public void loanAnimal() {
		if( getAvailableAnimals() < 1){
			throw new IllegalStateException("No animals available"); //throws exception if no animals available to loan
		}
		totalLoanAnimals++; //if there are animals available then the number of loan animals is incremented by 1
	}

	public void returnAnimal() {
		if(this.totalLoanAnimals < 1){
			throw new IllegalStateException("No animals on loan."); //throws exception if there are no animals on loan
		}
		totalLoanAnimals--; //decrements number of loan animals by one to indicate an animal has been returned
	}
}


