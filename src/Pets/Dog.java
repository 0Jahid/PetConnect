package Pets;

import java.time.LocalDate;

import BaseClass.Pet;
import InterfaceClass.Grooming;
import InterfaceClass.SoundProducing;
import InterfaceClass.Training;

public class Dog extends Pet implements SoundProducing, Grooming, Training {
	private String size;
	private String coatColor;

	// Constructor
	public Dog(String name, String breed, int age, double price) {
		super(name, breed, age, price);

	}

	// Getters and Setters
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCoatColor() {
		return coatColor;
	}

	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}

	@Override
	public void feed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void groom() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSound() {
		System.out.println(getName() + " is burking");

	}

	@Override
	public void train() {
		LocalDate temp = LocalDate.now();
		System.out.println(getBreed() + " trained on" + temp);

	}

	@Override
	public void play() {
		System.out.println(getName() + " is playing");

	}

}
