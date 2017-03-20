public class LSeller extends Seller {
	
	public LSeller(int numCust,seats a, String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=7;
		min=4;
		row = 9;
		
	}
	public void sellTicket(int min1, int max1,Customer c) {
		Timer a = new Timer();
		int currentTime=a.getTime();
		sellingTime=(int)(Math.random()*4 + 4);
		System.out.println(name + " takes " + sellingTime + " mins");
		while(a.getTime()<sellingTime) {
			//System.out.println("i am selling" + a.getTime()  + "\t " + sellingTime);//do nothing until it is time to sell
		}
		if(!listOfCust.isEmpty()) {
		checkSeatMap(c);
		}
		
		
	}
	
	public synchronized void checkSeatMap(Customer cust) {
		boolean x = true;
		for(int ro = 9 ;ro > 0 && x; ro--) {
			for(int co=0; co < 10 && x; co++ ) {
				if(!map.isSold(ro, co)) {
					x=false;
					listOfCust.remove(0);
					numTicketsSold++;
					map.seat[ro][co]=this.name + "-" + numTicketsSold;
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