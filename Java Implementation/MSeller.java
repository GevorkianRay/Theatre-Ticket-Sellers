public class MSeller extends Seller {
	public MSeller(int numCust, seats a,String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=4;
		min=2;
		row=5;
		
	}
	public void sellTicket(int min1, int max1,Customer c) {
		Timer a = new Timer();
		int currentTime=a.getTime();
		sellingTime=(int)(Math.random()*3 + 2);
		System.out.println(name + " takes " + sellingTime + " mins");
		while(a.getTime()<sellingTime) {
			//System.out.println("i am selling" + a.getTime()  + "\t " + sellingTime);//do nothing until it is time to sell
		}
		if(!listOfCust.isEmpty()) {
		checkSeatMap(c);
		}
		turnedAway=listOfCust.size();
		
	}
	public synchronized void checkSeatMap(Customer cust) {
		
		Customer c=listOfCust.remove(0); //remove first customer on list
		boolean x = true;
		for(int ro = 5 ;ro > 0 && x; ro--) {
			for(int co=0; co < 10 && x; co++ ) {
				if(!map.isSold(ro, co)) {
					x=false;
					numTicketsSold++;
					map.seat[ro][co]=c.name;
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
