package driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

import BaseClass.Pet;
import Pets.Bird;
import Pets.Cat;
import Pets.Dog;
import Pets.Fish;

public class main {
	private static final String FILE_PATH = "users.txt";
	private static final String PET_FILE_PATH = "pets.txt";
	private static List<Pet> petList = new ArrayList<>();
	private static List<Pet> userCart = new ArrayList<>();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			// showing welcome menu to user and taking input
			System.out.println("Welcome!!!");
			System.out.println("Please select a option ");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("0. Exit");
			int option1 = input.nextInt();
			switch (option1) {
			case 1:
				adminLogIn();
				break;
			case 2:
				while (true) {
					// menu for customer
					System.out.println("-------------PetConnect--------------");
					System.out.println("1. Register");
					System.out.println("2. Login");
					System.out.println("3. Exit");
					System.out.print("Enter your choice: ");
					System.out.println("------------------------------------");
					int choice = input.nextInt();

					switch (choice) {
					case 1:
						registerUser();
						break;
					case 2:
						loginUser();
						break;
					case 3:
						System.out.println("Goodbye!");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice. Please try again.");
						break;
					}
				}
			case 0:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid option");
				break;
			}

		}

	}

	private static void adminLogIn() {
//admin login function
		System.out.println("Welcome to admin plane");
		String AdminUserName = "Admin";
		String AdminPassword = "Admin123";
		String tem1, tem2;
		System.out.println("Enter Your");
		System.out.println("Username: ");
		tem1 = input.next();
		System.out.println("Password: ");
		tem2 = input.next();
		if (tem1 == AdminUserName && tem2 == AdminPassword) {
			System.out.println("Login Successful");
			boolean isAdminLogedIn = true;
			while (isAdminLogedIn) {
				System.out.println("-------------PetConnect--------------");
				System.out.println("1. Add pet to inventory: ");
				System.out.println("2. Delete pet from inventory: ");
				System.out.println("3. Update pet information: ");
				System.out.println("0. Exit");
				System.out.println("Enter a option:  ");
				System.out.println("------------------------------------");
				int adminOption = input.nextInt();
				switch (adminOption) {
				case 1:
					addPet();
					break;
				case 2:
					System.out.println("Not yet available");
				case 3:
					System.out.println("Not yet available");
				case 0:
					isAdminLogedIn = false;
				default:
					break;
				}

			}

		} else {
			System.out.println("Wrong Username or Password");
		}
	}

	private static void registerUser() {

		System.out.println("Registration:");
		System.out.print("Enter username: ");
		String username = input.nextLine();
		System.out.print("Enter password: ");
		String password = input.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			writer.write(username + "," + password);
			writer.newLine();
			System.out.println("Registration successful!");
		} catch (IOException e) {
			System.out.println("Error occurred during registration.");
		}
	}

	private static void loginUser() {

		System.out.println("Login:");

		System.out.print("Enter username: ");
		String username = input.nextLine();

		System.out.print("Enter password: ");
		String password = input.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			boolean isLoggedIn = false;

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
					isLoggedIn = true;
					break;
				}
			}

			if (isLoggedIn) {
				System.out.println("Login successful!");

				while (isLoggedIn) {
					System.out.println("-------------PetConnect--------------");
					System.out.println("1.Show Pet list");
					System.out.println("2.Add to cart");
					System.out.println("3.Checkout");
					System.out.println("0.Exit");
					System.out.println("Please enter a Option: ");
					System.out.println("------------------------------------");
					int temp = input.nextInt();
					switch (temp) {
					case 1:
						viewAvailablePets();
						break;
					case 2:
						addToCart();
						break;
					case 3:
						checkout();
						break;
					case 0:
						isLoggedIn = false;
						break;
					default:
						break;
					}
				}

			} else {
				System.out.println("Invalid username or password.");
			}
		} catch (IOException e) {
			System.out.println("Error occurred during login.");
		}
	}

	public static void addPet() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------PetConnect--------------");
		System.out.println("Add Pet :");
		System.out.println("1. Bird");
		System.out.println("2. Dog");
		System.out.println("3. Fish");
		System.out.println("4. Cat");
		System.out.print("Enter the option you want to add: ");
		System.out.println("------------------------------------");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
		case 1:
			Bird bird = createBird();
			petList.add(bird);
			break;
		case 2:
			Dog dog = createDog();
			petList.add(dog);
			break;
		case 3:
			Fish fish = createFish();
			petList.add(fish);
			break;
		case 4:
			Cat cat = createCat();
			petList.add(cat);
			break;
		default:
			System.out.println("Invalid option. No pet added.");
			return;
		}

		savePetsToFile();

		System.out.println("Pet added successfully!");
	}

	public static Bird createBird() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter breed: ");
		String breed = scanner.nextLine();
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		System.out.print("Enter price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter species: ");
		String species = scanner.nextLine();
		System.out.print("Can fly? (true/false): ");
		boolean canFly = scanner.nextBoolean();
		scanner.nextLine();

		return new Bird(name, breed, age, price, species, canFly);
	}

	public static Dog createDog() {

		System.out.print("Enter name: ");
		String name = input.nextLine();
		System.out.print("Enter breed: ");
		String breed = input.nextLine();
		System.out.print("Enter age: ");
		int age = input.nextInt();
		System.out.print("Enter price: ");
		double price = input.nextDouble();
		input.nextLine();
		System.out.print("Enter color: ");
		String color = input.nextLine();

		return new Dog(name, breed, age, price, color);
	}

	public static Fish createFish() {
		System.out.print("Enter name: ");
		String name = input.nextLine();
		System.out.print("Enter breed: ");
		String breed = input.nextLine();
		System.out.print("Enter age: ");
		int age = input.nextInt();
		System.out.print("Enter price: ");
		double price = input.nextDouble();
		input.nextLine();
		System.out.print("Enter species: ");
		String species = input.nextLine();
		System.out.print("Enter water type: ");
		String waterType = input.nextLine();

		return new Fish(name, breed, age, price, species, waterType);
	}

	public static Cat createCat() {
		System.out.print("Enter name: ");
		String name = input.nextLine();
		System.out.print("Enter breed: ");
		String breed = input.nextLine();
		System.out.print("Enter age: ");
		int age = input.nextInt();
		System.out.print("Enter price: ");
		double price = input.nextDouble();
		input.nextLine();
		System.out.print("Enter color: ");
		String color = input.nextLine();

		return new Cat(name, breed, age, price, color);
	}

	public static void savePetsToFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PET_FILE_PATH))) {
			for (Pet pet : petList) {
				if (pet instanceof Bird) {
					Bird bird = (Bird) pet;
					writer.write("Bird");
					writer.newLine();
					writer.write("Name: " + bird.getName());
					writer.newLine();
					writer.write("Breed: " + bird.getBreed());
					writer.newLine();
					writer.write("Age: " + bird.getAge());
					writer.newLine();
					writer.write("Price: " + bird.getPrice());
					writer.newLine();
					writer.write("Species: " + bird.getSpecies());
					writer.newLine();
					writer.write("Can fly: " + bird.canFly());
					writer.newLine();
				} else if (pet instanceof Dog) {
					Dog dog = (Dog) pet;
					writer.write("Dog");
					writer.newLine();
					writer.write("Name: " + dog.getName());
					writer.newLine();
					writer.write("Breed: " + dog.getBreed());
					writer.newLine();
					writer.write("Age: " + dog.getAge());
					writer.newLine();
					writer.write("Price: " + dog.getPrice());
					writer.newLine();
					writer.write("Color: " + dog.getCoatColor());
					writer.newLine();
				} else if (pet instanceof Fish) {
					Fish fish = (Fish) pet;
					writer.write("Fish");
					writer.newLine();
					writer.write("Name: " + fish.getName());
					writer.newLine();
					writer.write("Breed: " + fish.getBreed());
					writer.newLine();
					writer.write("Age: " + fish.getAge());
					writer.newLine();
					writer.write("Price: " + fish.getPrice());
					writer.newLine();
					writer.write("Water type: " + fish.getWaterType());
					writer.newLine();
				} else if (pet instanceof Cat) {
					Cat cat = (Cat) pet;
					writer.write("Cat");
					writer.newLine();
					writer.write("Name: " + cat.getName());
					writer.newLine();
					writer.write("Breed: " + cat.getBreed());
					writer.newLine();
					writer.write("Age: " + cat.getAge());
					writer.newLine();
					writer.write("Price: " + cat.getPrice());
					writer.newLine();
					writer.write("Color: " + cat.getFurColor());
					writer.newLine();
				}

				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}

	public static void viewAvailablePets() {
		System.out.println("Available Pets:");
		for (Pet pet : petList) {
			System.out.println("------------------------------------");
			System.out.println("Name: " + pet.getName());
			System.out.println("Breed: " + pet.getBreed());
			System.out.println("Age: " + pet.getAge());
			System.out.println("Price: " + pet.getPrice());
			System.out.println("------------------------------------");
		}
	}
	/*
	 * public static void loadPetsFromFile() { try (BufferedReader reader = new
	 * BufferedReader(new FileReader(PET_FILE_PATH))) { String line; Pet pet = null;
	 * 
	 * while ((line = reader.readLine()) != null) { if (line.equals("Bird")) { pet =
	 * new Bird(); } else if (line.equals("Dog")) { pet = new Dog(); } else if
	 * (line.equals("Fish")) { pet = new Fish(); } else if (line.equals("Cat")) {
	 * pet = new Cat(); } else if (line.startsWith("Name: ")) {
	 * pet.setName(line.substring(6)); } else if (line.startsWith("Breed: ")) {
	 * pet.setBreed(line.substring(7)); } else if (line.startsWith("Age: ")) {
	 * pet.setAge(Integer.parseInt(line.substring(5))); } else if
	 * (line.startsWith("Price: ")) {
	 * pet.setPrice(Double.parseDouble(line.substring(7))); } else if
	 * (line.startsWith("Species: ")) { ((Bird) pet).setSpecies(line.substring(9));
	 * } else if (line.startsWith("Can fly: ")) { ((Bird)
	 * pet).setCanFly(Boolean.parseBoolean(line.substring(9))); petList.add(pet); }
	 * } } catch (IOException e) {
	 * System.out.println("An error occurred while reading the file.");
	 * e.printStackTrace(); } }
	 */

	public static void addToCart() {
		System.out.print("Enter the name of the pet you want to add to your cart: ");
		String petName = input.nextLine();

		Pet selectedPet = null;
		for (Pet pet : petList) {
			if (pet.getName().equalsIgnoreCase(petName)) {
				selectedPet = pet;
				break;
			}
		}

		if (selectedPet != null) {
			userCart.add(selectedPet);
			System.out.println("Pet added to your cart successfully!");
		} else {
			System.out.println("Pet not found.");
		}
	}

	public static void checkout() {
		double totalBill = 0.0;

		if (userCart.isEmpty()) {
			System.out.println("Your cart is empty.");
			return;
		}

		System.out.println("Items in Your Cart:");
		for (Pet pet : userCart) {
			System.out.println("Name: " + pet.getName());
			System.out.println("Breed: " + pet.getBreed());
			System.out.println("Age: " + pet.getAge());
			System.out.println("Price: " + pet.getPrice());
			System.out.println("--------------------------");
			totalBill += pet.getPrice();
		}

		System.out.println("Total Bill: $" + totalBill);
	}
}
