import java.util.Scanner;  

class main{  
	
	// Same thing with USBScanner except this is non-GUI format
	 public static void main(String args[]){  
	   Scanner sc=new Scanner(System.in);  
	     
	   System.out.println("Scan: ");  
	   String rollno = sc.nextLine();  
	   System.out.println("Scanned: " + rollno);
	   sc.close();  
	 }  
}  

