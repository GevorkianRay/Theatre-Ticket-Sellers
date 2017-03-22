import java.util.*;

public class Seller implements Runnable {
	public ArrayList<Customer> listOfCustomers;
	public Timer t;
	public int numTicketsSold;
	public int totalCustomers;
	public int sellingTime;
	public int maxTimeToServe;
	public int minTimeToServe;
	public Seats map;
	public int row;
	public int col;
	public String name;
	public int turnedAway;

	/**
	 * Constructor for the Seller class.
	 * 
	 * @param numCustomers
	 *            - the number of customer in the seller's queue.
	 * @param mapOfSeats
	 *            - the 2D array of seats the sellers will use to sell seats to
	 *            the customer.
	 * @param SellerName
	 *            - the name of the seller.
	 * @param timer
	 *            - the time limit for the seller to know when to stop selling.
	 */
	public Seller(int numCustomers, Seats mapOfSeats, String SellerName, Timer timer) {
		turnedAway = 0;
		name = SellerName;
		t = timer;
		row = 0;
		col = 0;
		map = mapOfSeats;
		totalCustomers = numCustomers;
		numTicketsSold = 0;
		listOfCustomers = new ArrayList<Customer>();
		maxTimeToServe = 0;
		minTimeToServe = 0;
		for (int i = 0; i < numCustomers; i++) {
			listOfCustomers.add(new Customer((int) (Math.random() * 59), SellerName + i));
		}
		Collections.sort(listOfCustomers, new customerArrivalCompare());
		for (int i = 0; i < listOfCustomers.size(); i++) {
			listOfCustomers.get(i).customerName = SellerName + "-" + i;
		}
	}

	/**
	 * Compares the arrival time between customers.
	 */
	static class customerArrivalCompare implements Comparator<Customer> {
		public int compare(Customer c0, Customer c1) {
			return c0.compareTo(c1);
		}
	}

	/**
	 * Allows the seller to start selling within the time limit.
	 */
	public void run() {
		boolean run = true;
		Customer hold = null;
		while (t.getElapsedTime() < 60) {
			int currentTime = t.getElapsedTime();
			if (!listOfCustomers.isEmpty() && !map.soldAllSeats()) {
				Customer current = listOfCustomers.get(0);
				hold = current;
				if (shouldSell(currentTime, current)) {
					// System.out.println(name + " is currently working on sale"
					// + " at time " + currentTime);
					String time = "";
					if (currentTime < 10) {
						time = "00:0" + currentTime;
					} else {
						time = "00:" + currentTime;
					}
					System.out.println("Time: " + time + " Seller: " + name);
					sellTicket(maxTimeToServe, minTimeToServe, current); // work
																			// for
																			// a
																			// time
				}

			}

		}
		
		while(t.getElapsedTime()<67) {
			if(!listOfCustomers.isEmpty() && run) {
				for(int i = 0 ; i < listOfCustomers.size();i++) {
					System.out.println(name + "\t " +listOfCustomers.get(i).customerName + "\t" + t.secondsElapsed);
					run=false;
				}
			}
		}

	}

	/**
	 * Gets the number of customers that will be turned away.
	 * 
	 * @return - the number of customers turned away
	 */
	public int getNumTurned() {
		turnedAway = totalCustomers - numTicketsSold;
		return turnedAway;
	}

	/**
	 * Checks to see is a seat should be sold to the customer based on their
	 * arrival time.
	 * 
	 * @param currentMinute
	 *            - the current time the customer arrives.
	 * @param currentCustomer
	 *            - the name of the customer.
	 * @return - true or false which will determine if the ticket should be sold
	 *         to the customer.
	 */
	public boolean shouldSell(int currentMinute, Customer currentCustomer) {
		if (currentMinute >= currentCustomer.customerArrivalTime) {
			// System.out.println(name + "\t" + listOfCustomers.size());
			if (currentMinute == currentCustomer.customerArrivalTime) {
				System.out.println(currentCustomer.customerName + " arrives.");
			}
			return true;
		}
		return false;
	}

	/**
	 * The action of selling the ticket to the customer
	 * 
	 * @param minimumTime
	 *            - the minimum selling time the seller can take to complete a
	 *            transaction.
	 * @param maximumTime
	 *            - the maximum amount of time the seller can take to complete a
	 *            transaction.
	 * @param customer
	 *            - the customer that the seller is currently serving.
	 */
	public void sellTicket(int minimumTime, int maximumTime, Customer customer) {
		int range = maximumTime - minimumTime + 1;
		sellingTime = minimumTime + (int) ((Math.random() * range));

		int timeToSell = sellingTime + t.secondsElapsed; // creates a random
															// sale time
															// depending on
															// seller type
		System.out.println(t.secondsElapsed);
		System.out.println(name + " is selling in " + timeToSell);
		Integer tTS = new Integer(timeToSell);
		Integer elapsed = new Integer(t.secondsElapsed);
		System.out.println(elapsed.compareTo(tTS) == 0);

	}

	public void checkSeatMap(Customer c) {
		// remove first customer on list
		boolean x = true;
		for (int ro = 0; x; ro++) {
			for (int co = 0; x; co++) {
				if (map.isSold(ro, co)) {
					x = false;
					map.seats[ro][co] = c.customerName;
				}
			}
		}
	}

	public String toString() {
		return name;
	}

	/*
	 * prints customers in list
	 *
	 */
	public void printMyCustomers() {
		Iterator i = listOfCustomers.iterator();
		while (i.hasNext()) {
			Customer current = (Customer) i.next();
			System.out.println(current.customerArrivalTime);
		}
	}
}