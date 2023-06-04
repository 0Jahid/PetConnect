package Pets;

import java.time.LocalDate;

import BaseClass.Pet;
import InterfaceClass.Grooming;
import InterfaceClass.SoundProducing;
import InterfaceClass.VeterinaryCare;

public class Cat extends Pet implements SoundProducing, Grooming, VeterinaryCare {
	private String furColor;
	private boolean isIndoor;

	// Constructor
	public Cat(String name, String breed, int age, double price, String furColor) {
		super(name, breed, age, price);
		this.furColor = furColor;
		
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
	System.out.println(getName()+" is Meowing");


	}

	@Override
	public void vetCare() {
		LocalDate myObj = LocalDate.now();
		System.out.println("vet care appointment on " + myObj);


	}

	@Override
	public void play() {
		System.out.println(getName()+" is playing");

	}
}
