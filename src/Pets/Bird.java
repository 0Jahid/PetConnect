package Pets;

import java.time.LocalTime;

import BaseClass.Pet;
import InterfaceClass.SoundProducing;

public class Bird extends Pet implements SoundProducing {
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
		LocalTime tem = LocalTime.now();
		System.out.println(getName() + " is fed at " + tem);
	}

	@Override
	public void makeSound() {
		System.out.println(getName() + " is chirping");

	}

	@Override
	public void play() {
		System.out.println(getName() + " is playing ");

	}
}
