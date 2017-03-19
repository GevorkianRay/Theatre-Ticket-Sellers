import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	
	
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Enter # of customers:");// gets the number of customers
		Scanner scan=new Scanner(System.in);		//for each seller
		int numCustomers=scan.nextInt();
		scan.close();
		seats seat=new seats();
		Timer t = new Timer();
		
		HSeller H1 = new HSeller(numCustomers,seat,"H1");
		LSeller L2 = new LSeller(numCustomers,seat,"L2");
		LSeller L3 = new LSeller(numCustomers,seat,"L3");
		LSeller L4 = new LSeller(numCustomers,seat,"L4");
		LSeller L5 = new LSeller(numCustomers,seat,"L5");
		LSeller L6 = new LSeller(numCustomers,seat,"L6");
ArrayList<Customer> Test= new ArrayList<Customer>();
Test.add(new Customer(0,"H11"));

H1.listOfCust=Test;
		
H1.printMyCustomers();
	H1.run();

		
		
	
	
	}
	
}
