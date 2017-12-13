class Machine {
	private String name;
	private int code;
	
	public Machine() {
		this("Arnie", 0);
		
		System.out.println("Constructor running!");
	}
	
	public Machine(String name) {
		this(name, 0);
		
		System.out.println("Second Constructor running!");
		this.name = name;
	}
	 public Machine(String name, int code) {
		 
		 System.out.println("Third Constructor running!");
		 this.name = name;
		 this.code = code;
	 }
}
public class Constructors {

	public static void main(String[] args) {
		Machine machine1 = new Machine();
		Machine machine2 = new Machine("Bertie");
		Machine machine3 = new Machine("Chalky", 7);
	}

}

/*
More Example of Constructor

App.java

public class App {

	public static void main(String[] args) {

		// Lets create the object

		CoolClassNameHere ccnh = new CoolClassNameHere();

	}

}

CoolClassNameHere.java

public class CoolClassNameHere {

	public CoolClassNameHere(){

		//Print to the screen a message

		System.out.println("Object created, constructor invoked.");

		//Run a method!

		doSomethingUseful();
	}

}

public void doSomethingUseful() {

	System.out.println("Doing something now!");

	//insert more logic here!

	}

}

*/