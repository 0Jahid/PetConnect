package Pets;

import java.time.LocalTime;

import BaseClass.Pet;
import InterfaceClass.Feeding;
import InterfaceClass.SoundProducing;
import InterfaceClass.Swimmable;

public class Fish extends Pet implements Feeding, Swimmable,SoundProducing {
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

	@Override
	public void swim() {
		System.out.println(getName() + " is swimming");

	}

	@Override
	public void feed() {
		LocalTime myObj = LocalTime.now();
		System.out.println(getName() + " fed at " + myObj);

	}

	@Override
	public void play() {
		System.out.println(getName() + " is playing");

	}

	@Override
	public void makeSound() {
		System.out.println("Fish doesn't produce any sound");
		
	}
}
