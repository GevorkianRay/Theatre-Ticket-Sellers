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
	 int row;
	 int col;
	 String name;
	 int turnedAway;
	 
	 public Seller(int numCustomers, seats mapOfSeats,String SellerName,Timer timer) {
		 turnedAway = 0;
		 name=SellerName;
		 t=timer;
		 row=0;
		 col=0;
		 map=mapOfSeats;
		 totalCustomers=numCustomers;
		 numTicketsSold=0;
		 listOfCust= new ArrayList<Customer>();
		 max=0;
		 min =0 ;
		 for(int i = 0 ; i < numCustomers;i++) {
			 
			 listOfCust.add(new Customer((int)(Math.random()*59), SellerName+i));
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
		while(t.minutesElapsed<60) {
			int currentTime= t.getTime();
			if(!listOfCust.isEmpty()) { 
			Customer current=listOfCust.get(0);
			if(shouldSell(currentTime,current)) {	
				current=listOfCust.remove(0);
				
				System.out.println(name + " is currently working on sale" + " at time " + currentTime);
			
				sellTicket(max, min,current);				//work for a time
			}
			
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
	public void sellTicket(int min1, int max1,Customer c) {
		int range = max1-min1+1;							
		sellingTime=min1 +(int)((Math.random()*range));
		
		int timeToSell= sellingTime+ t.minutesElapsed;  // creates a random sale time depending on seller type
		System.out.println(t.minutesElapsed);
		System.out.println(name+ " is selling in " + timeToSell);
		Integer tTS=new Integer(timeToSell);
		Integer elapsed=new Integer(t.minutesElapsed);
		System.out.println(elapsed.compareTo(tTS)==0);

		
	
		
	}
	
	public void checkSeatMap(Customer c) {
	 //remove first customer on list
		boolean x = true;
		for(int ro = 0 ; x; ro++) {
			for(int co=0; x; co++ ) {
				if(map.isSold(ro, co)) {
					x=false;
					map.seat[ro][co]=c.name;
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
		Iterator i = listOfCust.iterator();
		while(i.hasNext()) {
			Customer current=(Customer) i.next();
			System.out.println(current.arrivalT);
		}
	}
}