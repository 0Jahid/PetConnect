package Pets;

import BaseClass.Pet;

public class Cat extends Pet {
	private String furColor;
	private boolean isIndoor;

	// Constructor
	public Cat(String name, String breed, int age, double price, String furColor, boolean isIndoor) {
		super(name, breed, age, price);
		this.furColor = furColor;
		this.isIndoor = isIndoor;
	}

	// Getters and Setters
	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public boolean isIndoor() {
		return isIndoor;
	}

	public void setIndoor(boolean indoor) {
		isIndoor = indoor;
	}

	// Additional methods specific to cats
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
