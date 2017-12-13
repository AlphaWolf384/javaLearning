
public class LoopingThroughTwoDArrays {

	public static void main(String[] args) {
		String[][] text = { 
				{ "dog", "cat", "fish" }, 
				{ "beer", "soda", "pie" } 
				};
		
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.println(text[row][col]);
			}
		}

	}

}
