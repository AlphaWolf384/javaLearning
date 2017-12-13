import java.util.Scanner;

public class Interactive {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		
		int num = scanner.nextInt();
		
		if (num < 10) {
			System.out.println("This number is too small");
		}
		else {
			System.out.println("This number is big enough");
		}

	}

}
