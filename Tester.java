import java.util.ArrayList;
import java.util.Scanner;

public class Tester implements Runnable {

	static ArrayList<Seller> sell = new ArrayList<Seller>();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Enter # of customers:");// gets the number of
													// customers
		Scanner scan = new Scanner(System.in); // for each seller
		int numCustomers = scan.nextInt();
		scan.close();
		Seats seat = new Seats();
		Timer t = new Timer();

		HSeller H1 = new HSeller(numCustomers, seat, "H1", t);
		MSeller M1 = new MSeller(numCustomers, seat, "M1", t);
		MSeller M2 = new MSeller(numCustomers, seat, "M2", t);
		MSeller M3 = new MSeller(numCustomers, seat, "M3", t);
		LSeller L1 = new LSeller(numCustomers, seat, "L1", t);

		LSeller L2 = new LSeller(numCustomers, seat, "L2", t);
		LSeller L3 = new LSeller(numCustomers, seat, "L3", t);
		LSeller L4 = new LSeller(numCustomers, seat, "L4", t);
		LSeller L5 = new LSeller(numCustomers, seat, "L5", t);
		LSeller L6 = new LSeller(numCustomers, seat, "L6", t);
		Thread t1 = new Thread(H1);
		Thread t2 = new Thread(M1);
		Thread t3 = new Thread(M2);
		Thread t4 = new Thread(M3);
		Thread t5 = new Thread(L1);
		Thread t6 = new Thread(L2);
		Thread t7 = new Thread(L3);
		Thread t8 = new Thread(L4);
		Thread t9 = new Thread(L5);
		Thread t10 = new Thread(L6);
		/*
	ArrayList<Customer> ab = new ArrayList<Customer>();				//for testing
	L1.listOfCustomers=ab;
	ab.add(new Customer(58,"H1"));
	ab.add(new Customer(59,"L1"));
	ab.add(new Customer(60,"dsa"));*/
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		sell.add(H1);
		sell.add(M1);
		sell.add(M2);
		sell.add(M3);
		sell.add(L1);
		sell.add(L2);
		sell.add(L3);
		sell.add(L4);
		sell.add(L5);
		sell.add(L6);
		Tester a = new Tester();
		a.run();
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(70000);
			int sumTurnedAway = 0;
			for (int i = 0; i < sell.size(); i++) {
				// System.out.println(sell.get(i).name+"\t"+sell.get(i).listOfCustomers.size());
				sumTurnedAway = sumTurnedAway + sell.get(i).listOfCustomers.size();
				// System.out.println("Turned away:" +sumTurnedAway);
			}

			int sumNumSold = 0;

			for (int i = 0; i < sell.size(); i++) {
				sumNumSold += sell.get(i).numTicketsSold;
				// sumTurnedAway =+ sell.get(i).turnedAway;
			}
			System.out.println("Number of tickets sold total: " + sumNumSold);
			System.out.println("Number of customer turned away: " + sumTurnedAway);
			for(int i = 0; i<sell.size(); i++){
				System.out.println(sell.get(i).name + "\t " + sell.get(i).listOfCustomers.size());
			}

			System.out.println("Final seating chart:");
			sell.get(0).map.toString();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}