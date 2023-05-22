package driver;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import BaseClass.Pet;
import Pets.Cat;
import Pets.Dog;
import Pets.Fish;

public class DriverClass {

	public static void main(String[] args) {

		Dog dog = new Dog("Buddy", "Lavendor", 5, 100.0, "Big", "Long");
		Dog dog2 = new Dog("Buddy", "Lavendor", 5, 100.0, "Big", "Long");

		addPetToBinaryFile(dog2);

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
