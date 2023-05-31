package BaseClass;

abstract public class Pet {
	private String name;
	private String breed;
	private int age;
	private double price;

	// Constructor
	public Pet(String name, String breed, int age, double price) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.price = price;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	abstract public void feed();

	abstract public void play();
}
