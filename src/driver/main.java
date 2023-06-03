package driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Pets.Cat;
import Pets.Fish;

public class main {
	private static final String FILE_PATH = "users.txt";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
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
					System.out.println("1. Register");
					System.out.println("2. Login");
					System.out.println("3. Exit");
					System.out.print("Enter your choice: ");
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
				break;
			}

		}

	}

	private static void adminLogIn() {
		Scanner input = new Scanner(System.in);
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

		} else {
			System.out.println("Wrong Username or Password");
		}
	}

	private static void registerUser() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Registration:");
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			writer.write(username + "," + password);
			writer.newLine();
			System.out.println("Registration successful!");
		} catch (IOException e) {
			System.out.println("Error occurred during registration.");
		}
	}

	private static void loginUser() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Login:");

		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

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
			} else {
				System.out.println("Invalid username or password.");
			}
		} catch (IOException e) {
			System.out.println("Error occurred during login.");
		}
	}
	public static void addAnimalByAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Animal - Admin");
        System.out.println("Which animal do you want to add?");
        System.out.println("1. Bird");
        System.out.println("2. Dog");
        System.out.println("3. Fish");
        System.out.println("4. Cat");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        Animal animal = null;
        String animalType = "";

        switch (choice) {
            case 1:
                animal = createBird();
                animalType = "Bird";
                break;
            case 2:
                animal = createDog();
                animalType = "Dog";
                break;
            case 3:
                animal = createFish();
                animalType = "Fish";
                break;
            case 4:
                animal = createCat();
                animalType = "Cat";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (animal != null) {
            saveAnimalToFile(animal, animalType);
            System.out.println("The " + animalType + " has been added and saved to the file.");
        } else {
            System.out.println("Failed to create the " + animalType + ".");
        }
    }

    public static Bird createBird() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bird details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline character
        System.out.print("Species: ");
        String species = scanner.nextLine();
        System.out.print("Can fly (true/false): ");
        boolean canFly = scanner.nextBoolean();
        scanner.nextLine(); // Consume the remaining newline character

        return new Bird(name, breed, age, price, species, canFly);
    }

    public static Dog createDog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dog details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline character
        System.out.print("Color: ");
        String color = scanner.nextLine();

        return new Dog(name, breed, age, price, color);
    }

    public static Fish createFish() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fish details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline character
        System.out.print("Color: ");
        String color = scanner.nextLine();

        return new Fish(name, breed, age, price, color);
    }

    public static Cat createCat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cat details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline character
        System.out.print("Color: ");
        String color = scanner.nextLine();

        return new Cat(name, breed, age, price, color);
    }

    public static void saveAnimalToFile(Animal animal, String animalType) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Animal Type: " + animalType);
            writer.newLine();
            writer.write("Name: " + animal.getName());
            writer.newLine();
            writer.write("Breed: " + animal.getBreed());
            writer.newLine();
            writer.write("Age: " + animal.getAge());
            writer.newLine();
            writer.write("Price: " + animal.getPrice());
            writer.newLine();

            if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                writer.write("Species: " + bird.getSpecies());
                writer.newLine();
                writer.write("Can fly: " + bird.canFly());
                writer.newLine();
            } else if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                writer.write("Color: " + dog.getColor());
                writer.newLine();
            } else if (animal instanceof Fish) {
                Fish fish = (Fish) animal;
                writer.write("Color: " + fish.getColor());
                writer.newLine();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                writer.write("Color: " + cat.getColor());
                writer.newLine();
            }

            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
