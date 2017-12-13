package CarPackage;

public class Car {
	
	private String name;
	
	public Car(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void start() {
		System.out.println("Car started!");
	}
}
