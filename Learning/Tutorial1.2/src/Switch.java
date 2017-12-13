import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a command: ");
		String text = input.nextLine();

		switch (text) {
		case "start":
			System.out.println("Machine Started");
			break;

		case "stop":
			System.out.println("Machine stopped");
			break;

		default:
			System.out.println("Command is not recognized! Please try again.");
			break;
		}
	}

}
