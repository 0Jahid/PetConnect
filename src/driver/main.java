package driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
				System.out.println("Welcome to admin plane");
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
}
