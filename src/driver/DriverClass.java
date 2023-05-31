package driver;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import BaseClass.Pet;
import Pets.Cat;
import Pets.Dog;
import Pets.Fish;

public class DriverClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Dog dog = new Dog("Buddy", "Lavendor", 5, 100.0, "Big", "Long");
		Dog dog2 = new Dog("Buddy", "Lavendor", 5, 100.0, "Big", "Long");

		addPetToBinaryFile(dog2);

		int input1 = 10;
		do {
			System.out.println("Please select: ");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("0. Exit");
			input1 = input.nextInt();
			switch (input1) {
			case 1:

				break;
			case 2:

				break;

			default:
				System.out.println("Please enter correct value");
				break;
			}

		} while (input1 != 0);

	}

	public static void addPetToBinaryFile(Dog dog) {
		try (FileOutputStream fos = new FileOutputStream("dogs.bin");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(dog.getName());
			oos.writeObject(dog.getBreed());
			oos.writeObject(dog.getCoatColor());
			oos.writeObject(dog.getSize());
			oos.writeObject(dog.getName());
			oos.writeObject(dog.getName());
			oos.flush();
			oos.close();
			System.out.println("Dog added successfully");

		} catch (Exception e) {
			System.out.println("An error occurred while adding Dog" + e.getMessage());
		}
	}

}
