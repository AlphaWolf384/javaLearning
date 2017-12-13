class Frog {
	//private will keep values inside of class only, not to public class
	private String name;
	private int age;
	
	//Setting up for 'this'
	public void setName(String name) {
		// this will direct the values to setter in public class
		this.name = name; 
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	//Setter
	public void getInfo(String name, int age) {
		setName(name);
		setAge(age);
	}
}

public class SetterandThis {

	public static void main(String[] args) {
			Frog frog1 = new Frog();
			
			frog1.setName("Bertie");
			frog1.setAge(1);
			
			System.out.println(frog1.getName());
	}

}
