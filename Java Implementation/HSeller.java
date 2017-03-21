/**
 * H Seller is a type of Seller.
 * It sells exclusively in the first row and has the shortest serving time.
 */
public class HSeller extends Seller {

    /**
     * Constructor for a HSeller.
     * @param numberOfCustomers - the maximum number of customers to serve.
     * @param seats             - the seats that the H seller can serve.
     * @param sellerName        - the name of the current H Seller.
     * @param timer             - the timer to track the H seller.
     */

    public HSeller(int numberOfCustomers, Seats seats, String sellerName, Timer timer) {
        super(numberOfCustomers, seats, sellerName, timer);
        maxTimeToServe = 2; // The maximum amount of time a HSeller can take.
        minTimeToServe = 1; // The minimum amount of time a LSeller can take.
        row = 0; // The only row that a HSeller can sell in.
    }

    /**
     * Method to sell a ticket to the given customer.
     * @param minServeTime - the minimum time to serve a customer.
     * @param maxServeTime - the maximum time to serve a customer.
     * @param customer     - the customer to sell a ticket to.
     */

    public void sellTicket(int minServeTime, int maxServeTime, Customer customer) {
        Timer timer = new Timer();
        sellingTime = (int) Math.ceil((Math.random() * 2));
        System.out.println(name + " takes " + sellingTime + " mins for customer " + customer.customerName );
        while (timer.getElapsedTime() < sellingTime) {} //do nothing until it is time to sell
        if (!listOfCustomers.isEmpty()) {
            checkSeatMap(customer);
        }
    }

    /**
     * Checks the seating map with synchronization between sellers.
     * @param customer - the customer to place into the seating map.
     */
    public synchronized void checkSeatMap(Customer customer) {
        boolean emptySeat = true;
        for (int ro = 0; ro < 10 && emptySeat; ro++) {
            for (int co = 0; co < 10 && emptySeat; co++) {
                if (!map.isSold(ro, co)) {
                    numTicketsSold++;
                    listOfCustomers.remove(0);
                    emptySeat = false;
                    map.seats[ro][co] = customer.customerName;
                    try {
                        Thread.sleep(100);
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