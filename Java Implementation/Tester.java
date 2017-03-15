
import java.util.Scanner;

public class Tester {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Enter # of customers:");// gets the number of customers
		Scanner scan=new Scanner(System.in);		//for each seller
		int numCustomers=scan.nextInt();
		scan.close();
		
		seats seat=new seats();
		
		
		double startTime=System.currentTimeMillis();
		Thread.sleep(5000);
		double elapsed = System.currentTimeMillis();
		float seconds = (float) ((elapsed - startTime) / 1000F);
		System.out.println(Float.toString(seconds) + " seconds.");
	
	}
	
}
