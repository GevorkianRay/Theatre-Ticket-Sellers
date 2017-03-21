/**
 * L Seller is a type of Seller.
 * It sells within a specific row pattern and takes the longest time to serve.
 */
public class LSeller extends Seller {

	/**

	 * Constructor for the M Seller.
	 * @param numberOfCustomers - the maximum number of customers to serve.
	 * @param seats             - the seats that the L seller can serve.
	 * @param sellerName        - the name of the current L Seller.
	 * @param timer             - the timer to track the L seller.
	 */
	public LSeller(int numberOfCustomers,Seats seats, String sellerName, Timer timer) {
		super(numberOfCustomers, seats, sellerName, timer);
		maxTimeToServe = 7;
		minTimeToServe = 4;
		row = 9;
	}

	/**
	 * Method to sell a ticket to the given customer.
	 * @param minServeTime - the minimum time to serve a customer.
	 * @param maxServeTime - the maximum time to serve a customer.
	 * @param customer     - the customer to sell a ticket to.
	 */
	public void sellTicket(int minServeTime, int maxServeTime, Customer customer) {
		Timer timer = new Timer();
		sellingTime =(int)(Math.random()* 4 + 4);
		System.out.println(name + " takes " + sellingTime + " mins");
		while(timer.getElapsedTime() < sellingTime) {} // Do nothing until it is time to sell.
		if(!listOfCustomers.isEmpty()) {
		checkSeatMap(customer);
		}
	}

	/**
	 * Checks the seating map with synchronization between sellers.
	 * @param customer - the customer to place into the seating map.
	 */
	public synchronized void checkSeatMap(Customer customer) {
		boolean x = true;
		for(int ro = 9; ro > 0 && x; ro--) {
			for(int co = 0; co < 10 && x; co++ ) {
				if(!map.isSold(ro, co)) {
					x = false;
					listOfCustomers.remove(0);
					numTicketsSold++;
					map.seat[ro][co] = customer.customerName;
					try {
		                Thread.sleep(10);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
					System.out.println();
					System.out.println();
					System.out.println();
					map.toString();
				}
			}
		}
	}
}
