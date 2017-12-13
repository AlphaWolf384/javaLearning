class Thing {
	// final static cannot be changed as it is final but static is initialized value to float around public
	public final static int LUCKY_NUMBER = 7;
	
	public String name;
	public static String description;
	
	public static int count = 0;
	
	public int id;
	
	public Thing() {
		
		id = count; // Instance value
		count++;
	}
	
	public void showName() {
		System.out.println("Object id: " + id + ", " + description + ": " + name);
	}
	
	public static void showInfo() {
		System.out.println(description);
		// Won't work: System.out.println(name);
	}
}
public class Static {
	public static void main(String[] args) {
		Thing.description = "I am thing";
		
		Thing.showInfo();
		
		System.out.println("Before creating objects, count is: " + Thing.count);
		
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
		
		System.out.println("After creating objects, count is " + Thing.count);
		
		thing1.name = "Bob";
		thing2.name = "Sarah";
		
		thing1.showName();
		thing2.showName();
		
		//Math.PI cannot be changed since it is static constant
		System.out.println(Math.PI);
		
		//LUCKY_NUMBER is final static number so it will display only number as it stated
		System.out.println(Thing.LUCKY_NUMBER);
	}

}
