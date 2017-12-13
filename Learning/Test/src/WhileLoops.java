import java.util.Scanner;

public class WhileLoops {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numResult = 0;

		while(numResult != 5) {
			System.out.println("Enter the integer");
			
			if (scanner.hasNextInt()) {
				numResult = scanner.nextInt();

				if (numResult < 5) {
					System.out.println("Too small!");
				} else if (numResult > 5) {
					System.out.println("Too big!");
				} else {
					System.out.println("Number 5 is found!");
					break;
				}
			}
			else {
				scanner.nextLine();
			}

		}

	}

}
