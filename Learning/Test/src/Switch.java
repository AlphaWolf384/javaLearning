import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {

		int value = 0;
		
		System.out.println("Enter the integer: ");
		Scanner scanner = new Scanner(System.in); 
		value = scanner.nextInt();
		
		switch(value) {

		case 1:
			System.out.println("Got 1!");
		break;
		case 66:
			System.out.println("Got 66!");
		break;
		default:
			System.out.println("Got something else!");
		}

	}

}
