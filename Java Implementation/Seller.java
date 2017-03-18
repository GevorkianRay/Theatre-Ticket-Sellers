import java.util.*;
public class Seller implements Runnable {
	 ArrayList<Customer> listOfCust ;
	 Timer t;
	 int numTicketsSold;
	 int totalCustomers;
	 int sellingTime;
	 int max;
	 int min;
	 seats map;
	 
	 
	 
	 public Seller(int numCustomers, seats mapOfSeats) {
		 map=mapOfSeats;
		 totalCustomers=numCustomers;
		 t=new Timer();
		 numTicketsSold=0;
		 listOfCust= new ArrayList<Customer>();
		 max=0;
		 min =0 ;
		 for(int i = 0 ; i < numCustomers;i++) {
			 
			 listOfCust.add(new Customer((int)(Math.random()*59)));
		 }
		 
		 Collections.sort(listOfCust, new customerArrivalCompare());
		 
		 
	 }
	 /*
	  * makes list of customers in sorted order
	  * 
	  */
	 static class customerArrivalCompare implements Comparator<Customer> {
			public int compare(Customer arg0, Customer arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
		}
	 
	public void run() {
		
		while(t.minutesElapsed<60 && numTicketsSold<totalCustomers) {
			t.run();
			Customer current=listOfCust.get(0);
			if(shouldSell(t.minutesElapsed,current)) {
				sellTicket(max, min);
			}
			
		}
		
	}
	
	/*
	 * checks if the customer is here at the right time
	 */
	public boolean shouldSell(int currentMinute, Customer currentCustomer) {
		if(currentMinute>=currentCustomer.arrivalT) {
			
			return true;
		}
		return false;
	}
	/*
	 * sells ticket to customers
	 */
	public void sellTicket(int min1, int max1) {
		int range = max1-min1+1;
		sellingTime=min1 +(int)((Math.random()*range));
		
		
		
	}
	
	
	/*
	 * prints customers in list
	 * 
	 */
	public void printMyCustomers() {
		Iterator i = listOfCust.iterator();
		while(i.hasNext()) {
			Customer current=(Customer) i.next();
			System.out.println(current.arrivalT);
		}
	}
}
