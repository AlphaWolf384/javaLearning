public class ifLoop {
	public static void main(String[] args) {
		
		int i = 0;
		
		while(true) {
			if(i == 5) {
				break;
			}
			else {
				System.out.println("Loop: " + i);
			}
			
			System.out.println("Running");
			i++;
		}
	}
}
