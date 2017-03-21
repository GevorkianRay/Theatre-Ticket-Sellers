/**
 * Customer class holds customer objects.
 * Implements comparable to test the arrival time between two customers.
 */
public class Customer implements Comparable<Customer>
{
	public int customerArrivalTime; // Arrival time of a specific customer.
	public String customerName; // Name of the customer.

	/**
	 * Constructor for a customer.
	 * @param time - the time to initialize for a customer.
	 * @param name - the name to initialize for a customer.
     */
	public Customer(int time, String name)
	{
		customerArrivalTime = time; // Setting the customer's arrival time to the given time.
		customerName = name; // Setting the customer's name to the given name.
	}

	/**
	 * Comparable method for comparing two customer's arrival times.
	 * @param customer - the customer we are comparing.
	 * @return value - the customer which should be served first.
     */
	public int compareTo(Customer customer) {
		if (this.customerArrivalTime > customer.customerArrivalTime)
		{
			return 1; // Customer arrived later.
		}
		else if (this.customerArrivalTime < customer.customerArrivalTime)
		{
			return -1; // Customer arrived earlier.
		}
		else return 0; // Customers arrived at the same time.
	}
}
