
public class Car extends Machine {
	public void wipeWindShield() {
		System.out.println("Wiping Windshield");
	}
	/*
	 * Good example of inheritance 
	public void start() {
		System.out.println("Car started.");
	}
	*/
	// Right click to go to Override method and select start from Machine
	@Override
	public void start() {
		// TODO Auto-generated method stub
		//super.start();
		System.out.println("Car started.");
	}
	
	public void showInfo() {
		System.out.println("Car name: " + name);
	}
	
}
