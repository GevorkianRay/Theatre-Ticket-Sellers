import java.util.Scanner;

public class Tester {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		int ticketsSold=0;
		
		System.out.println("Enter # of customers:");// gets the number of customers

		Scanner scan=new Scanner(System.in);		//for each seller
		int numCustomers=scan.nextInt();
		scan.close();
		
		seats seat=new seats();
		
		Timer t = new Timer();
		
		while(t.minutesElapsed<60 && ticketsSold<100) {
			
			
		}
	
	}
	
}
