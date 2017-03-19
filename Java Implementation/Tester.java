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
		ArrayList<Seller> sell = new ArrayList<Seller>();
		HSeller H1 = new HSeller(numCustomers,seat,"H1",t);
		MSeller M1 = new MSeller(numCustomers,seat,"M1",t);
		LSeller L1 = new LSeller(numCustomers,seat,"L1",t);
		Thread t1 = new Thread(H1);
		Thread t2 = new Thread(M1);
		Thread t3 = new Thread(L1);
		
		t1.start();
		t2.start();
		t3.start();
		sell.add(H1);
		sell.add(M1);
		sell.add(L1);
		int sumNumSold = 0;
		int sumTurnedAway = 0;
		for(int i = 0; i<sell.size(); i++){
			sumNumSold += sell.get(i).numTicketsSold;
			sumTurnedAway =+ sell.get(i).turnedAway;
			
		}
		
	
	}
	
}