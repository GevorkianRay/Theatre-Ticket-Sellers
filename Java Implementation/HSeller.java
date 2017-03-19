public class HSeller extends Seller {
	public HSeller(int numCust,seats a,String sellerName,Timer timer) {
		super(numCust,a,sellerName,timer);
		max=2;
		min=1;
		row=0;
	}
	
	public void sellTicket(int min1, int max1,Customer c) {
		Timer a = new Timer();
		int currentTime=a.getTime();
		sellingTime=(int)Math.ceil((Math.random()*2));
		System.out.println(name + " takes " + sellingTime + " mins");
		while(a.getTime()<sellingTime) {
			//System.out.println("i am selling" + a.getTime()  + "\t " + sellingTime);//do nothing until it is time to sell
		}
		if(!listOfCust.isEmpty()) {
		checkSeatMap(c);
		}
		
		
	}
	
	public synchronized void checkSeatMap( Customer c ) {
	
		boolean checkingForEmptySeat = true;
		for(int ro = 0 ; ro < 10 && checkingForEmptySeat; ro++) {
			for(int co=0;co < 10 && checkingForEmptySeat; co++ ) {
				if(!map.isSold(ro, co)) {
					numTicketsSold++;
					listOfCust.remove(0);
					checkingForEmptySeat=false;
					map.seat[ro][co]=c.name;
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