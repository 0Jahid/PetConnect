package Pets;
import BaseClass.Pet;

public class Fish extends Pet {
	private String species;
	private String waterType;

	// Constructor
	public Fish(String name, String breed, int age, double price, String species, String waterType) {
		super(name, breed, age, price);
		this.species = species;
		this.waterType = waterType;
	}

	// Getters and Setters
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getWaterType() {
		return waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	public void feed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void groom() {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}
}
