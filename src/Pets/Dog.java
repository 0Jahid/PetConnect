package Pets;

import BaseClass.Pet;

public class Dog extends Pet {
	private String size;
	private String coatColor;

	// Constructor
	public Dog(String name, String breed, int age, double price, String size, String coatColor) {
		super(name, breed, age, price);
		this.size = size;
		this.coatColor = coatColor;
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
	public void play() {
		// TODO Auto-generated method stub

	}

}
