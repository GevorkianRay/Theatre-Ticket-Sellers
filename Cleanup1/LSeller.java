public class LSeller extends Seller {
	
	public LSeller(int numCust,Seats a, String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		maxTimeToServe=7;
		minTimeToServe=4;
		row = 9;
		
	}
	public void sellTicket(int min1, int max1,Customer c) {
		Timer a = new Timer();
		int currentTime=a.getElapsedTime();
		sellingTime=(int)(Math.random()*4 + 4);
		System.out.println(name + " takes " + sellingTime + " mins");
		while(a.getElapsedTime()<sellingTime) {
			//System.out.println("i am selling" + a.getTime()  + "\t " + sellingTime);//do nothing until it is time to sell
		}
		if(!listOfCustomers.isEmpty()) {
		checkSeatMap(c);
		}
		
		
	}
	
	public synchronized void checkSeatMap(Customer cust) {
		
		boolean x = true;
		for(int ro = 9 ;ro > 0 && x; ro--) {
			for(int co=0; co < 10 && x; co++ ) {
				if(!map.isSold(ro, co)) {
					x=false;
					listOfCustomers.remove(0);
					numTicketsSold++;
					map.seat[ro][co]=cust.customerName;
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