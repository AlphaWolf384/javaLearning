class Person {
	
	//Instance variables (data or "state")
	String name;
	int age;
	
	
	// Classes can contain
	
	/*
	 * 1. Data 
	 * 2. Subroutines (methods)
	 */
	void speak() {
		System.out.println("My name is: " + name);
	}
	/*
	void calculateYearsToRetirement( ) {
		int yearLeft = 65 - age;
		
		System.out.println(yearLeft);
	}
	*/
	int calculateYearsToRetirement() {
		int yearLeft = 65- age;
		
		return yearLeft;
	}
	int getAge() {
		return age;
	}
	String getName() {
		return name;
	}
}

public class GetterandReturn {

	public static void main(String[] args) {
		
		// Create a Person object using the Person class
		Person person1 = new Person();
		person1.name = "Joe";
		person1.age = 25;
		//person1.speak();
		//person1.calculateYearsToRetirement();
		
		int years = person1.calculateYearsToRetirement();
		int age = person1.getAge();
		String name = person1.getName();
		
		System.out.println("Years till retirements: " + years);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

}
