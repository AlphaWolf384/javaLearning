import java.util.Scanner;

public class InteractiveProgram {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the integer: ");
		
		int number = scanner.nextInt();
		
		if (number < 10 ) {
			System.out.println("This number is too small.");
		}
		else {
			System.out.println("This number is big enough.");
		}
	}

}
