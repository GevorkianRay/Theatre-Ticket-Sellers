/**
 * M Seller is a type of Seller. It sells within a specific set of rows and
 * takes a medium amount of time.
 */
public class MSeller extends Seller {
	/**
	 * Constructor for the M Seller.
	 * 
	 * @param numberOfCustomers
	 *            - the maximum number of customers to serve.
	 * @param seats
	 *            - the seats that the M seller can serve.
	 * @param sellerName
	 *            - the name of the current M Seller.
	 * @param timer
	 *            - the timer to track the M seller.
	 */
	public MSeller(int numberOfCustomers, Seats seats, String sellerName, Timer timer) {
		super(numberOfCustomers, seats, sellerName, timer);
		maxTimeToServe = 4;
		minTimeToServe = 2;
		row = 5;
	}

	/**
	 * Method to sell a ticket to the given customer.
	 * 
	 * @param minServeTime
	 *            - the minimum time to serve a customer.
	 * @param maxServeTime
	 *            - the maximum time to serve a customer.
	 * @param customer
	 *            - the customer to sell a ticket to.
	 */
	public void sellTicket(int minServeTime, int maxServeTime, Customer customer) {
		Timer timer = new Timer();
		sellingTime = (int) (Math.random() * 3 + 2);
		// System.out.println(listOfCustomers.get(0).customerName + " arrives at
		// " + this.name + "'s queue");
		System.out.println(name + " takes " + sellingTime + " mins");
		while (timer.getElapsedTime() < sellingTime) {
		} // Do nothing until it's time to sell.
		if (!listOfCustomers.isEmpty()) {
			checkSeatMap(customer);
		}
	}

	/**
	 * Checks the seating map with synchronization between sellers.
	 * 
	 * @param customer
	 *            - the customer to place into the seating map.
	 */
	public synchronized void checkSeatMap(Customer customer) {
		int counter = 0;
		boolean turned = true;
		boolean x = true;
		for (int ro = 5; (ro > 0 && ro < 10) && x; counter++) {
			for (int co = 0; co < 10 && x; co++) {
				if (!map.isSold(ro, co)) {
					x = false;
					Customer c = listOfCustomers.remove(0);
					numTicketsSold++;
					map.seats[ro][co] = customer.customerName;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println();
					System.out.println(c.customerName + " bought a ticket and leaves.");
					map.toString();
					System.out.println();
				}else if( map.soldAllSeats() && turned){
					System.out.println(customer.customerName +" arrived at "+ customer.customerArrivalTime+ " turned away at " + t.getElapsedTime());
					turned = false;
				}
			}
			if (counter % 2 == 0) {
				ro = ro - counter;
			} else {
				ro = ro + counter;
			}
		}
	}
}