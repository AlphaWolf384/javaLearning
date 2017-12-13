package test1;

public class Car {
	
	private String name;
	
	public Car(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void started() {
		System.out.println("Car started!");
	}
}
