class Robot {
	public void speak(String text) {
		System.out.println(text);
	}
	public void jump(int height) {
		System.out.println("Jumping: " + height);
	}
	public void move(String direction, double distance) {
		System.out.println("Moving " + distance + " miles in direction " + direction);
	}
}
public class MethodParameter {

	public static void main(String[] args) {
		Robot sam = new Robot();
		
		sam.speak("Hi I am Sam!");
		sam.jump(7);
		
		sam.move("West", 12.2);
		
		String greeting = "Hello There.";
		
		sam.speak(greeting);;
		
		int value = 14;
		sam.jump(value);
		
		String newDirection = "North";
		double newDistance = 20;
		
		sam.move(newDirection, newDistance);

	}

}
