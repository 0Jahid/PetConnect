package Pets;

import BaseClass.Pet;

public class Bird extends Pet {
	private String species;
	private boolean canFly;

	// Constructor
	public Bird(String name, String breed, int age, double price, String species, boolean canFly) {
		super(name, breed, age, price);
		this.species = species;
		this.canFly = canFly;
	}

	// Getters and Setters
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public boolean canFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
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

