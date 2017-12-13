import java.util.Scanner;

public class userInput {
	public static void main(String[] args) {
		
		// Create Scanner object
		Scanner input = new Scanner(System.in);
		
		// Output the prompt
		System.out.println("Enter a line of text: ");
		
		// Wait for the user to enter something like string or integer or float or double
		String line = input.nextLine();
		
		//Tell them what they entered
		System.out.println("You entered: " + line);
	}
					
}
