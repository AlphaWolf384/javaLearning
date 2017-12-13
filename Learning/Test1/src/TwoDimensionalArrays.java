
public class TwoDimensionalArrays {

	public static void main(String[] args) {
		
		String[][] text = { 
				{"dog","cat","fish"},
				{"apple","orange","banana"}
		};
		
		System.out.println(text[1][2]);
		
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.println(text[row][col]);
			}
		}

	}

}
