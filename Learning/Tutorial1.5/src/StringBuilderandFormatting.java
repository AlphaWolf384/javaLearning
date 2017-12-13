
public class StringBuilderandFormatting {

	public static void main(String[] args) {
		
		//Inefficient, Can slow program with more memory
		String info = "";
		
		info += "My name is Bob.";
		info += " ";
		info += "I am a builder.";
		
		System.out.println(info);
		
		//More efficient.
		StringBuilder sb = new StringBuilder("");
		
		sb.append("My name is Sue.");
		sb.append(" ");
		sb.append("I am a lion tamer.");
		
		System.out.println(sb.toString());
		
		StringBuilder s = new StringBuilder();
		
		s.append("My name is Roger.")
		.append(" ")
		.append("I am a skydiver.");
		
		System.out.println(s.toString());

		////	FORMATTING		////
		
		//println can be used as print to not skip line
		System.out.print("Here is some text.\tThat was a tab.\nThat was a new line.");
		System.out.println(" More Text.");
		
		////	Formatting Integers		////
		// %-10d will put 5 first and %10d will add more space character as 5 will go last
		System.out.printf("Total cost %10d; quantity is %d", 5, 120);
		
		for(int i = 0; i < 10 ; i++) {
			// Can add '-' to make left align for numbers
			System.out.printf("%-2d: some text here\n", i);
		}
		
		////	Formatting floating point value		////
		System.out.printf("Total value: %.02f\n", 5.6789);
		System.out.printf("Total value: %-6.1f\n", 3456.456789);
	}

}
