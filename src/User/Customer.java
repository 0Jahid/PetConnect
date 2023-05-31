package User;

import BaseClass.Pet;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private String password;
	private List<Pet> purchaseHistory;
	private int loyaltyPoints;
	private double balance;

	public Customer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.purchaseHistory = new ArrayList<>();
		this.loyaltyPoints = 0;
		this.balance = 0.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pet> getPurchaseHistory() {
		return purchaseHistory;
	}

	public void addPurchase(Pet item) {
		purchaseHistory.add(item);
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void increaseLoyaltyPoints(int points) {
		loyaltyPoints += points;
	}

	public void decreaseLoyaltyPoints(int points) {
		loyaltyPoints -= points;
	}

	public double getBalance() {
		return balance;
	}

	public void addBalance(double amount) {
		balance += amount;
	}

	public void deductBalance(double amount) {
		balance -= amount;
	}

	public void purchase(Pet pet) {
		double petPrice = pet.getPrice();
		if (balance >= petPrice) {
			purchaseHistory.add(pet);
			balance -= petPrice;
			System.out.println("Purchase successful! Thank you for shopping with us.");
		} else {
			System.out.println("Insufficient balance to make the purchase.");
		}
	}
}
