
public class printTest {

	public static void main(String[] args) {
		int myNumber = 45;
		short myShort = 456;
		long myLong = 4567;
		
		double myDouble = 4.5678;
		float myFloat = 321.4f;
		
		char myChar = 'G';
		boolean myBoolean = true;
		
		byte myByte = 127;
		
		System.out.println(myNumber);
		System.out.println(myShort);
		System.out.println(myLong);
		System.out.println(myDouble);
		System.out.println(myFloat);
		System.out.println(myChar);
		System.out.println(myBoolean);
		System.out.println(myByte);
		System.out.println();
		System.out.println(Byte.MAX_VALUE);
		
		myNumber = (int)myLong;
		System.out.println(myNumber);
		
		myDouble = myNumber;
		System.out.println(myDouble);
		
		myNumber = (int)myFloat;
		System.out.println(myNumber);
		
		//The following won't work as we expect it to!!
		//128 is too big for byte.
		myByte = (byte)128;
		System.out.println(myByte);
		
	}

}
