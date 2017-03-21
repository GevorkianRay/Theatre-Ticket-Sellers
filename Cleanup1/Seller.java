import java.util.*;

public class Seller implements Runnable {
    ArrayList<Customer> listOfCustomers;
    Timer t;
    int numTicketsSold;
    int totalCustomers;
    int sellingTime;
    int maxTimeToServe;
    int minTimeToServe;
    Seats map;
    int row;
    int col;
    String name;
    int turnedAway;

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
            listOfCustomers.get(i).customerName = SellerName + i;
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
     *
     */
    public void run() {
        while (t.secondsElapsed < 60) {
            int currentTime = t.getElapsedTime();
            if (!listOfCustomers.isEmpty() && map.soldAllSeats()) {
                Customer current = listOfCustomers.get(0);
                if (shouldSell(currentTime, current)) {
                    System.out.println(name + " is currently working on sale" + " at time " + currentTime);

                    sellTicket(maxTimeToServe, minTimeToServe, current);                //work for a time
                }

            }

        }


    }

    public int getNumTurned() {
        turnedAway = totalCustomers - numTicketsSold;
        return turnedAway;
    }

    /*
     * checks if the customer is here at the right time
     */
    public boolean shouldSell(int currentMinute, Customer currentCustomer) {
        if (currentMinute >= currentCustomer.customerArrivalTime) {
            System.out.println(name + "\t" + listOfCustomers.size());
            return true;
        }
        return false;
    }

    /*
     * sells ticket to customers
     */
    public void sellTicket(int min1, int max1, Customer c) {
        int range = max1 - min1 + 1;
        sellingTime = min1 + (int) ((Math.random() * range));

        int timeToSell = sellingTime + t.secondsElapsed;  // creates a random sale time depending on seller type
        System.out.println(t.secondsElapsed);
        System.out.println(name + " is selling in " + timeToSell);
        Integer tTS = new Integer(timeToSell);
        Integer elapsed = new Integer(t.secondsElapsed);
        System.out.println(elapsed.compareTo(tTS) == 0);


    }

    public void checkSeatMap(Customer c) {
        //remove first customer on list
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